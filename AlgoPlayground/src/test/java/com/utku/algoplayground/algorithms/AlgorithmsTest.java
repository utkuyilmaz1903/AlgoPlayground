package com.utku.algoplayground.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    @Test
    void mergeSortAndQuickSortSorts() {
        Integer[] a = {5, 2, 9, 1, 5, 6};
        Integer[] b = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        MergeSort.sort(a);
        QuickSort.sort(b);
        assertArraySorted(a);
        assertArraySorted(b);
    }

    @Test
    void binarySearchFindsAndNotFinds() {
        int[] ints = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(ints, 5));
        assertEquals(-1, BinarySearch.binarySearch(ints, 6));

        Integer[] arr = {1, 2, 3, 4, 5};
        assertEquals(3, BinarySearch.binarySearch(arr, 4));
        assertEquals(-1, BinarySearch.binarySearch(arr, 8));
    }

    private static <T extends Comparable<T>> void assertArraySorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            assertTrue(a[i - 1].compareTo(a[i]) <= 0, "Array not sorted at " + (i - 1) + "," + i);
        }
    }
}


