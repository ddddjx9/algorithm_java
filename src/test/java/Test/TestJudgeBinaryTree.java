package Test;

import myBinaryTree.JudgeBinaryTree;
import myBinaryTree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class TestJudgeBinaryTree {
    /*
           1
          / \
         2   2
        / \ / \
       3  4 3  4
     */
    @Test
    public void Judge() {
        TreeNode root1 = new TreeNode(
                new TreeNode(
                        new TreeNode(3),
                        2,
                        new TreeNode(4)
                ),
                1,
                new TreeNode(
                        new TreeNode(4),
                        2,
                        new TreeNode(3)
                )
        );

        TreeNode root2 = new TreeNode(
                new TreeNode(
                        new TreeNode(3),
                        2,
                        new TreeNode(4)
                ),
                1,
                new TreeNode(
                        new TreeNode(3),
                        2,
                        new TreeNode(4)
                )
        );

        Assert.assertTrue(new JudgeBinaryTree().judgeBinaryTree(root1));
        Assert.assertFalse(new JudgeBinaryTree().judgeBinaryTree(root2));
    }
}
