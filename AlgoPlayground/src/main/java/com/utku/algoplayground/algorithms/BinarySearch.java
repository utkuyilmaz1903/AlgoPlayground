package com.utku.algoplayground.algorithms;

/**
 * Binary search on sorted arrays.
 * - search: O(log n)
 */
public final class BinarySearch {
    private BinarySearch() {}

    /**
     * Binary search on a sorted int array.
     * @return index of target or -1 if not found.
     */
    public static int binarySearch(int[] array, int target) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    /**
     * Binary search on a sorted array of Comparable elements.
     * @return index of target or -1 if not found.
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array, T target) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = array[mid].compareTo(target);
            if (cmp == 0) return mid;
            if (cmp < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}


