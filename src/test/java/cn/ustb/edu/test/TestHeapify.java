package cn.ustb.edu.test;

import heapify.MaxHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestHeapify {
    @Test
    public void testMaxHeapHeapify() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        MaxHeap maxHeap = new MaxHeap(arr);
        int[] expected = {7, 5, 6, 4, 2, 1, 3};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void TestMaxHeapUp() {
        MaxHeap maxHeap = new MaxHeap(7);
        maxHeap.offer(1);
        maxHeap.offer(2);
        maxHeap.offer(3);
        maxHeap.offer(4);
        maxHeap.offer(5);
        maxHeap.offer(6);
        maxHeap.offer(7);
        int[] expected = {7, 4, 6, 1, 3, 2, 5};
        assertArrayEquals(expected, maxHeap.getArr());
    }
}
