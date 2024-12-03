package cn.edu.ustb.testDataStructure;

import org.junit.jupiter.api.Test;
import sort.HeapSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TestHeapSort {
    @Test
    public void testHeapSort() {
        int[] arr = {8, 3, 7, 9, 4, 6, 1, 0, 5, 2, 3, 8, 7, 9};
        HeapSort.heapSort(arr);

        int[] actual = {0, 1, 2, 3, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9};
        assertArrayEquals(arr, actual);
    }
}
