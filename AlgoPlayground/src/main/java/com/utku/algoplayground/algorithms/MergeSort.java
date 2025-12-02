package com.utku.algoplayground.algorithms;

/**
 * Generic Merge Sort.
 * Time: O(n log n), Space: O(n)
 */
public final class MergeSort {
    private MergeSort() {}

    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null || array.length < 2) return;
        @SuppressWarnings("unchecked")
        T[] buffer = (T[]) new Comparable[array.length];
        mergeSort(array, 0, array.length - 1, buffer);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] a, int left, int right, T[] buf) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(a, left, mid, buf);
        mergeSort(a, mid + 1, right, buf);
        merge(a, left, mid, right, buf);
    }

    private static <T extends Comparable<T>> void merge(T[] a, int left, int mid, int right, T[] buf) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (a[i].compareTo(a[j]) <= 0) buf[k++] = a[i++];
            else buf[k++] = a[j++];
        }
        while (i <= mid) buf[k++] = a[i++];
        while (j <= right) buf[k++] = a[j++];
        for (int x = left; x <= right; x++) a[x] = buf[x];
    }
}


