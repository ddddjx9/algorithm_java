package myBinaryTree;

import myBinaryTree.dataStructure.TreeNode;

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

        preOrderAndInOrder(root);
        postOrder(root);
        commonOrder(root);
    }

    private static void preOrderAndInOrder(TreeNode root) {
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

    private static void postOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null; //代表最近一次弹栈的元素
        TreeNode cur = root;
        //问题：如何不使用递归让节点记住来时的路，回溯的时候好找
        //用栈来记录来时的顺序，压入和弹出的顺序刚好相反
        //递的过程实现了前序遍历
        //归的过程实现了中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                //System.out.println("递：" + cur.val);
                stack.push(cur); //压栈，记住来时的路
                cur = cur.left;
            } else {
                //在执行后序遍历的时候，加判断条件，当两颗子树都处理完毕后，才能弹栈，否则不能弹栈
                //这样的话就不会导致右子树回来找不到父节点的情况出现
                TreeNode top = stack.peek();
                //去的时候已经将左子树处理完毕，只需要判断右子树是否还有元素即可
                //如何判断右子树是否处理完毕？
                //1. 右子树为空 - 处理完毕
                //2. 记录弹栈时候的值，如果和栈顶右孩子值相等，说明右孩子已经准备要出栈了，处理完毕
                if (top.right == null || top.right == pop) {
                    pop = stack.pop();
                    System.out.println("归：" + pop.val);
                } else {
                    cur = top.right;
                }
            }
        }
    }

    private static void commonOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null; //代表最近一次弹栈的元素
        TreeNode cur = root;
        //问题：如何不使用递归让节点记住来时的路，回溯的时候好找
        //用栈来记录来时的顺序，压入和弹出的顺序刚好相反
        //递的过程实现了前序遍历
        //归的过程实现了中序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                //待处理左子树
                ColorPrint.printPre(cur.val);
                stack.push(cur); //压栈，记住来时的路
                cur = cur.left;
            } else {
                //在执行后序遍历的时候，加判断条件，当两颗子树都处理完毕后，才能弹栈，否则不能弹栈
                //这样的话就不会导致右子树回来找不到父节点的情况出现
                TreeNode top = stack.peek();
                if (top.right == null) {
                    //没有右子树
                    ColorPrint.printIn(top.val);
                    pop = stack.pop();
                    ColorPrint.printPost(pop.val);
                } else if (top.right == pop) {
                    //右子树已经处理完成，开始回溯
                    pop = stack.pop();
                    ColorPrint.printPost(pop.val);
                } else {
                    //待处理右子树
                    ColorPrint.printIn(top.val);
                    cur = top.right;
                }
            }
        }
    }

    public static class ColorPrint {
        // ANSI颜色码
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";

        public static void printPost(int num) {
            System.out.println(ANSI_RED + "后：" + num + ANSI_RESET);
        }

        public static void printIn(int num) {
            System.out.println(ANSI_YELLOW + "中：" + num + ANSI_RESET);
        }

        public static void printPre(int num) {
            System.out.println(ANSI_BLUE + "前：" + num + ANSI_RESET);
        }
    }
}
