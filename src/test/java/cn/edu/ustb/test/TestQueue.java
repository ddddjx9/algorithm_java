package cn.edu.ustb.test;

import myQueue.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueue {
    @Test
    public void testOffer() {
        LinkedListImitateQueue<Integer> queue = new LinkedListImitateQueue<>(4);
        //queue.peek();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.poll();
        for (Integer i : queue) {
            System.out.println(i);
        }
    }

    @Test
    public void testQueue1() {
        CycleArrayQueue<Integer> queue = new CycleArrayQueue<>(4);
        //queue.peek();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.poll();

        for (Integer i : queue) {
            System.out.println(i);
        }
    }

    @Test
    public void testQueue2() {
        CycleArrayQueue2<Integer> queue = new CycleArrayQueue2<>(4);
        //queue.peek();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.poll();
        for (Integer i : queue) {
            System.out.println(i);
        }
    }

    @Test
    public void testQueue3() {
        CycleArrayQueue3<Integer> queue = new CycleArrayQueue3<>(4);
        //queue.peek();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.poll();
        for (Integer i : queue) {
            System.out.println(i);
        }
    }


    @Test
    public void testCircularQueue() {
        MyCircularQueue queue = new MyCircularQueue(5);
        assertTrue(queue.enQueue(1));
        assertTrue(queue.enQueue(2));
        assertTrue(queue.enQueue(3));
        assertTrue(queue.enQueue(4));
        assertTrue(queue.enQueue(5));
        assertFalse(queue.enQueue(6));

        assertTrue(queue.deQueue());

        assertEquals(2, queue.Front());
        assertEquals(5, queue.Rear());
    }
}
