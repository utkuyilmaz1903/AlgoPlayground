package com.utku.algoplayground.algorithms;

/**
 * Generic Quick Sort (Lomuto-style partition simplified).
 * Average O(n log n), worst O(n^2). In-place; recursion depth O(log n) average.
 */
public final class QuickSort {
    private QuickSort() {}

    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length < 2) return;
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] a, int low, int high) {
        if (low >= high) return;
        int p = partition(a, low, high);
        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }

    private static <T extends Comparable<T>> int partition(T[] a, int low, int high) {
        T pivot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j].compareTo(pivot) <= 0) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return i;
    }

    private static <T> void swap(T[] a, int i, int j) {
        if (i == j) return;
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}


