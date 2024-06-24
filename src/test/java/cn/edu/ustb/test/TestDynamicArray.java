package cn.edu.ustb.test;

import dynamicArrayDemo.DynamicArray;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;

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

        da.foreach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        da.remove(2);
        assertIterableEquals(List.of(1, 2, 5), da);
    }
}
