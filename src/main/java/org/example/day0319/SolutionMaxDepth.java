package org.example.day0319;

import org.example.day0319.TreeNode;

/**
 * 二叉树的最大深度
 * @author zhouchengliang
 */
public class SolutionMaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
