package org.example;

public class SolutionDeepestLeavesSum {
    int maxDepth = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // 如果是叶子节点
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                // 如果当前深度大于最大深度，更新最大深度并重置和
                maxDepth = depth;
                sum = node.val;
            } else if (depth == maxDepth) {
                // 如果当前深度等于最大深度，累加当前叶子节点的值
                sum += node.val;
            }
        }
        // 递归遍历左子树
        dfs(node.left, depth + 1);
        // 递归遍历右子树
        dfs(node.right, depth + 1);
    }
}
