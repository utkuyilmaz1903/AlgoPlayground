package com.utku.algoplayground.datastructures;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StackQueueTest {

    @Test
    void stackBasic() {
        Stack<Integer> s = new Stack<>();
        assertTrue(s.isEmpty());
        s.push(1);
        s.push(2);
        assertEquals(2, s.peek());
        assertEquals(2, s.pop());
        assertEquals(1, s.pop());
        assertTrue(s.isEmpty());
        assertThrows(NoSuchElementException.class, s::pop);
        assertThrows(NoSuchElementException.class, s::peek);
    }

    @Test
    void queueBasicAndResize() {
        Queue<String> q = new Queue<>(2);
        assertTrue(q.isEmpty());
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C"); // triggers resize
        assertFalse(q.isEmpty());
        assertEquals("A", q.peek());
        assertEquals("A", q.dequeue());
        assertEquals("B", q.dequeue());
        assertEquals("C", q.dequeue());
        assertTrue(q.isEmpty());
        assertThrows(NoSuchElementException.class, q::dequeue);
        assertThrows(NoSuchElementException.class, q::peek);
    }
}


