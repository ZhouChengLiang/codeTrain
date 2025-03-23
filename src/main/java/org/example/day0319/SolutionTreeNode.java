package org.example.day0319;

import org.example.day0319.TreeNode;

/**
 * @author zhouchengliang
 * 翻转二叉树
 */
public class SolutionTreeNode {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}

