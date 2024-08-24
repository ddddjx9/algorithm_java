package cn.edu.ustb.test;

import dynamicArrayDemo.DynamicArray;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestDynamicArray {
    @Test
    public void testDynamicArray() {
        DynamicArray da = new DynamicArray();
        da.addLast(1);
        da.addLast(2);
        da.addLast(5);
        da.add(2, 4);
        assertIterableEquals(List.of(1, 2, 4, 5), da);

        da.foreach(System.out::println);

        da.remove(2);
        assertIterableEquals(List.of(1, 2, 5), da);
    }
}
