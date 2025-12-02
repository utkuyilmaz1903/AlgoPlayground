package com.utku.algoplayground.datastructures;

import java.util.NoSuchElementException;

/**
 * A simple LIFO stack backed by DynamicArray.
 * push O(1) amortized, pop/peek O(1).
 */
public class Stack<T> {
    private final DynamicArray<T> items = new DynamicArray<>();

    public void push(T value) {
        items.add(value);
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return items.removeAt(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.size() == 0;
    }
}


