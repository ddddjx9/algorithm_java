package myQueue;

import myBinaryTree.dataStructure.TreeNode;
import myQueue.dataStructure.LinkedListImitateQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树层序遍历，LeetCode102
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5 6  7
 * 思路：先设置一个空的队列，将第一层的根节点加入队列
 * 处理完第一层节点后，将下一层节点再次加入队列，就能达到层序遍历的效果
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
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

        //选择没有容量限制的链表模拟队列进行实现
        LinkedListImitateQueue<TreeNode> queue = new LinkedListImitateQueue<>();
        queue.offer(root);
        int currentCount = 1; //表示当前这一层的节点数量

        //为了实现二叉树遍历的分层效果，统计每一层二叉树的孩子数量
        while (!queue.isEmpty()) {
            int nextCount = 0;
            for (int i = 0; i < currentCount; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    nextCount++;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    nextCount++;
                    queue.offer(node.right);
                }
            }
            System.out.println();
            currentCount = nextCount;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedListImitateQueue<TreeNode> queue = new LinkedListImitateQueue<>();
        queue.offer(root);
        int currentCount = 1;
        while (!queue.isEmpty()) {
            List<Integer> binaryTree = new ArrayList<>();
            int nextCount = 0;
            for (int i = 0; i < currentCount; i++) {
                TreeNode node = queue.poll();
                binaryTree.add(node.val);
                if (node.left != null) {
                    nextCount++;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    nextCount++;
                    queue.offer(node.right);
                }
            }
            result.add(binaryTree);
            currentCount = nextCount;
        }
        return result;
    }
}
