package cn.ustb.edu.test;

import myStack.ArrayStack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrayStack {
    @Test
    public void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertFalse(stack.push(6));
        assertEquals(5, stack.pop());
        assertEquals(4, stack.peek());
        assertIterableEquals(List.of(4, 3, 2, 1), stack);
    }
}
