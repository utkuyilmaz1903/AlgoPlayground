package com.utku.algoplayground.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple unbalanced Binary Search Tree (BST) for Comparable elements.
 * - insert: O(h) average O(log n), worst O(n)
 * - contains: O(h)
 * - remove: O(h)
 * - inOrderTraversal: O(n)
 *
 * Duplicates are ignored (not inserted).
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        Node(T value) { this.value = value; }
    }

    private Node<T> root;
    private int size;

    /**
     * Inserts a value if not already present.
     */
    public void insert(T value) {
        if (value == null) throw new IllegalArgumentException("Null values not supported");
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            size++;
            return new Node<>(value);
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) node.left = insert(node.left, value);
        else if (cmp > 0) node.right = insert(node.right, value);
        // duplicates ignored
        return node;
    }

    /**
     * @return whether the tree contains the value
     */
    public boolean contains(T value) {
        Node<T> cur = root;
        while (cur != null) {
            int cmp = value.compareTo(cur.value);
            if (cmp == 0) return true;
            cur = (cmp < 0) ? cur.left : cur.right;
        }
        return false;
    }

    /**
     * Removes value if present. No-op if absent.
     */
    public void remove(T value) {
        root = remove(root, value);
    }

    private Node<T> remove(Node<T> node, T value) {
        if (node == null) return null;
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = remove(node.left, value);
        } else if (cmp > 0) {
            node.right = remove(node.right, value);
        } else {
            // Found node to remove
            if (node.left == null && node.right == null) {
                size--;
                return null;
            } else if (node.left == null) {
                size--;
                return node.right;
            } else if (node.right == null) {
                size--;
                return node.left;
            } else {
                // Two children: replace with successor (min of right subtree)
                Node<T> succ = minNode(node.right);
                node.value = succ.value;
                node.right = remove(node.right, succ.value);
            }
        }
        return node;
    }

    private Node<T> minNode(Node<T> node) {
        Node<T> cur = node;
        while (cur.left != null) cur = cur.left;
        return cur;
    }

    /**
     * In-order traversal of the BST.
     */
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node<T> node, List<T> out) {
        if (node == null) return;
        inOrder(node.left, out);
        out.add(node.value);
        inOrder(node.right, out);
    }

    /**
     * @return number of nodes in the tree
     */
    public int size() {
        return size;
    }
}


