package Test;

import myStack.LinkedListStack;

public class TestStack {
    @org.junit.Test
    public void TestStack() {
        //测试Stack的情况
        LinkedListStack<Integer> stack = new LinkedListStack<Integer>(4);
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
