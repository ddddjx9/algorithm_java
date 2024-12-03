package myBinaryTree;

import myBinaryTree.dataStructure.TreeNode;

public class JudgeBinaryTree {
    /**
     * 调用isSymmetrical方法判断二叉树是否对称
     *
     * @param root 二叉树根节点
     * @return 返回二叉树是否为对称二叉树
     */
    public boolean judgeBinaryTree(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetrical(root.left, root.right);
    }

    /**
     * 实现私有方法，将简单入口暴露给用户
     * 如果两个节点都为空，则对称。
     * 如果有一个节点为空，另一个不为空，则不对称。
     * 如果节点值不相等，则不对称。
     *
     * @param left  左子树
     * @param right 右子树
     * @return 返回是否对称的结果
     */
    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        //多路递归
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return (left.val == right.val) && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
