package cn.edu.ustb.testDataStructure;

import myStack.dataStructure.LinkedListStack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class TestLinkedListStack {
    @Test
    public void testStack() {
        //测试Stack的情况
        LinkedListStack<Integer> stack = new LinkedListStack<>(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();

        Integer peek = stack.peek();
        assertEquals(3, peek);

        assertIterableEquals(List.of(3, 2, 1), stack);
    }
}
