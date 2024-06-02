package cn.ustb.edu.test;

import myBinaryTree.TreeNode;
import myQueue.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueue {
    @Test
    public void Test1() {
        LinkedListImitateQueue<Integer> queue = new LinkedListImitateQueue(4);
        //queue.peek();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.poll();
        assertIterableEquals(List.of(2, 3, 4, 5), queue);
    }

    @Test
    public void Test2() {
        CycleArrayQueue<Integer> queue = new CycleArrayQueue<>(4);
        //queue.peek();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.poll();

    }

    @Test
    public void Test3() {
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
    public void Test4() {
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
    public void Test5() {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(5)
                ),
                1,
                new TreeNode(
                        new TreeNode(6),
                        3,
                        new TreeNode(7)
                ));
        List<List<Integer>> lists = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void TestCircularQueue() {
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
