package myBinaryTree;

import myBinaryTree.dataStructure.TreeNode;
import myQueue.dataStructure.LinkedListImitateQueue;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
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
                )
        );

        List<List<Integer>> lists = new LevelOrder().levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 二叉树的层序遍历
     *
     * @param root 二叉树的根节点
     * @return 返回二叉树层序遍历的二维集合
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedListImitateQueue<TreeNode> queue = new LinkedListImitateQueue<>();
        queue.offer(root);

        int currentCount = 1;
        while (!queue.isEmpty()) {
            int nextCount = 0;
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < currentCount; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            result.add(level);
            currentCount = nextCount;
        }
        return result;
    }

}
