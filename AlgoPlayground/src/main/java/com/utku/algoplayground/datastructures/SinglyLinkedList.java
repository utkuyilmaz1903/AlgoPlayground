package com.utku.algoplayground.datastructures;

import java.util.NoSuchElementException;

/**
 * A simple singly linked list with head/tail references.
 * Operations: addFirst O(1), addLast O(1), removeFirst O(1), removeLast O(n), get(index) O(n).
 *
 * @param <T> element type
 */
public class SinglyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("List is empty");
        T val = head.value;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public T removeLast() {
        if (head == null) throw new NoSuchElementException("List is empty");
        if (head == tail) {
            T val = head.value;
            head = tail = null;
            size--;
            return val;
        }
        Node<T> prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        T val = tail.value;
        tail = prev;
        tail.next = null;
        size--;
        return val;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }
}


