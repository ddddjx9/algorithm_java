package myQueue;

import myBinaryTree.TreeNode;
import org.junit.Assert;

import java.util.List;

public class Test {
    @org.junit.Test
    public void Test() {
        LinkedListImitateQueue<Integer> queue = new LinkedListImitateQueue(4);
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

    @org.junit.Test
    public void Test2() {
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

    @org.junit.Test
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

    @org.junit.Test
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

    @org.junit.Test
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

    @org.junit.Test
    public void TestCircularQueue() {
        MyCircularQueue queue = new MyCircularQueue(5);
        Assert.assertTrue(queue.enQueue(1));
        Assert.assertTrue(queue.enQueue(2));
        Assert.assertTrue(queue.enQueue(3));
        Assert.assertTrue(queue.enQueue(4));
        Assert.assertTrue(queue.enQueue(5));
        Assert.assertFalse(queue.enQueue(6));

        Assert.assertTrue(queue.deQueue());

        Assert.assertEquals(2, queue.Front());
        Assert.assertEquals(5, queue.Rear());
    }
}
