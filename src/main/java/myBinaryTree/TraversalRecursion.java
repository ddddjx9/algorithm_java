package myBinaryTree;

/**
 * 递归实现二叉树遍历
 */
public class TraversalRecursion {
    /*
             1
           /  \
          2    3
         /    / \
        4    5  6
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        new TraversalRecursion().preOrder(root);
        new TraversalRecursion().inOrder(root);
        new TraversalRecursion().postOrder(root);
    }

    /**
     * 前序遍历: LeetCode144
     *
     * @param node 二叉树的根节点
     */
    public void preOrder(TreeNode node) {
        //递归实现，每个节点遍历规则相同
        //递归出口
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历: LeetCode94
     *
     * @param node 二叉树的根节点
     */
    public void inOrder(TreeNode node) {
        //递归出口
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    /**
     * 后序遍历: LeetCode145
     *
     * @param node 二叉树的根节点
     */
    public void postOrder(TreeNode node) {
        //递归出口
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
}
