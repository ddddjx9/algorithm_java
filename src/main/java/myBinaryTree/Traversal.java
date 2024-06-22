package myBinaryTree;

import java.util.LinkedList;

/**
 * 非递归实现二叉树遍历
 */
public class Traversal {
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

        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode cur = root;
        //问题：如何不使用递归让节点记住来时的路，回溯的时候好找
        //用栈来记录来时的顺序，压入和弹出的顺序刚好相反
        //递的过程实现了前序遍历
        //归的过程实现了中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                System.out.println("递：" + cur.val);
                stack.push(cur); //压栈，记住来时的路
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println("归：" + pop.val);
                cur = pop.right;
            }
        }
    }
}
