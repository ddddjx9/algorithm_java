package cn.ustb.edu.test;

import myStack.LinkedListStack;
import org.junit.jupiter.api.Test;


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
        System.out.println(peek);

        for (Integer i : stack) {
            System.out.println(i);
        }
    }
}
