package com.utku.algoplayground.datastructures;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void addAndResize() {
        DynamicArray<Integer> arr = new DynamicArray<>(2);
        arr.add(1);
        arr.add(2);
        arr.add(3); // resize
        arr.add(4);
        assertEquals(4, arr.size());
        assertEquals(1, arr.get(0));
        assertEquals(4, arr.get(3));
    }

    @Test
    void removeAtShifts() {
        DynamicArray<Integer> arr = new DynamicArray<>(2);
        arr.add(10);
        arr.add(20);
        arr.add(30);
        int removed = arr.removeAt(1);
        assertEquals(20, removed);
        assertEquals(2, arr.size());
        assertEquals(30, arr.get(1));
    }

    @Test
    void boundsChecks() {
        DynamicArray<Integer> arr = new DynamicArray<>(2);
        arr.add(5);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.removeAt(1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.set(2, 9));
    }
}


