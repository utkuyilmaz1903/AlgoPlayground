package com.utku.algoplayground.datastructures;

import java.util.NoSuchElementException;

/**
 * A FIFO queue implemented using a circular array with automatic resizing.
 * enqueue O(1) amortized, dequeue/peek O(1).
 */
public class Queue<T> {
    private static final int DEFAULT_CAPACITY = 8;
    private Object[] data;
    private int head; // index of current front
    private int tail; // index to insert next
    private int size;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int initialCapacity) {
        if (initialCapacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.data = new Object[initialCapacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void enqueue(T value) {
        ensureCapacity(size + 1);
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T val = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return val;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return (T) data[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity <= data.length) return;
        int newCapacity = Math.max(data.length * 2, minCapacity);
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }
}


