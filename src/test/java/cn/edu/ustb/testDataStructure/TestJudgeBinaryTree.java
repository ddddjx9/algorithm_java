package cn.edu.ustb.testDataStructure;

import myBinaryTree.JudgeBinaryTree;
import myBinaryTree.dataStructure.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJudgeBinaryTree {
    /*
           1
          / \
         2   2
        / \ / \
       3  4 3  4
     */
    @Test
    public void judge() {
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

        assertTrue(new JudgeBinaryTree().judgeBinaryTree(root1));
        assertFalse(new JudgeBinaryTree().judgeBinaryTree(root2));
    }
}
