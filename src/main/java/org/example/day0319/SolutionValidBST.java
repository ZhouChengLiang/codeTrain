package org.example.day0319;

import org.example.day0319.TreeNode;

/**
 * 验证二叉搜索树
 * @author zhouchengliang
 */
public class SolutionValidBST {

    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean check(TreeNode root,long rangeLeft,long rangeRight) {
        if(root == null) {
            return true;
        }
        if(root.val < rangeLeft || root.val > rangeRight) {
            return false;
        }
        return check(root.left,rangeLeft,(long)root.val-1)
                && check(root.right,(long)root.val+1,rangeRight);
    }
}
