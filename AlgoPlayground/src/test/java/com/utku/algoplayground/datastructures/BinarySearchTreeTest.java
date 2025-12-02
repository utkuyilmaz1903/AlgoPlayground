package com.utku.algoplayground.datastructures;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void insertContainsTraversal() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] vals = {5, 3, 7, 2, 4, 6, 8};
        for (int v : vals) bst.insert(v);
        assertTrue(bst.contains(4));
        assertFalse(bst.contains(100));
        List<Integer> inorder = bst.inOrderTraversal();
        assertEquals(List.of(2,3,4,5,6,7,8), inorder);
    }

    @Test
    void removeVariants() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] vals = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int v : vals) bst.insert(v);
        bst.remove(1); // leaf
        bst.remove(6); // node with two children (4,7)
        bst.remove(10); // node with one child (14->13)
        assertFalse(bst.contains(1));
        assertFalse(bst.contains(6));
        assertFalse(bst.contains(10));
        List<Integer> inorder = bst.inOrderTraversal();
        assertEquals(List.of(3,4,7,8,13,14), inorder);
    }
}


