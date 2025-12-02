package com.utku.algoplayground.datastructures;

/**
 * A generic resizable array backed by a plain Object[].
 * Supports amortized O(1) append, O(1) random access, and O(n) removeAt due to shifting.
 *
 * @param <T> element type
 */
public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private Object[] data;
    private int size;

    /**
     * Constructs a DynamicArray with default initial capacity.
     */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a DynamicArray with a specified initial capacity.
     *
     * @param initialCapacity initial capacity, must be > 0
     */
    public DynamicArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be > 0");
        }
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Appends value to the end. Amortized O(1).
     */
    public void add(T value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    /**
     * Returns the element at the given index. O(1).
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    /**
     * Sets the element at the given index to value. O(1).
     */
    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    /**
     * Removes the element at the given index and shifts subsequent elements left. O(n).
     *
     * @return removed element
     */
    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        checkIndex(index);
        T old = (T) data[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
        return old;
    }

    /**
     * @return current number of elements
     */
    public int size() {
        return size;
    }

    /**
     * @return whether the array contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= data.length) return;
        int newCapacity = Math.max(data.length * 2, minCapacity);
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }
    }
}


