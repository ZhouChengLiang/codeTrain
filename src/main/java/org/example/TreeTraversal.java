package org.example;

public class TreeTraversal {

    public static void main(String[] args) {
        // 构建一个简单的二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        System.out.print("前序遍历结果: ");
        preOrderTraversal(root);
        System.out.println();

        System.out.print("中序遍历结果: ");
        inOrderTraversal(root);
        System.out.println();

        System.out.print("后序遍历结果: ");
        postOrderTraversal(root);
        System.out.println();
    }

    // 前序遍历：根节点 -> 左子树 -> 右子树  MLR
    public static void preOrderTraversal(TreeNode root) {
        if (root != null) {
            // 先访问根节点
            System.out.print(root.val + " ");
            // 递归遍历左子树
            preOrderTraversal(root.left);
            // 递归遍历右子树
            preOrderTraversal(root.right);
        }
    }

    // 中序遍历：左子树 -> 根节点 -> 右子树 LMR
    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            // 递归遍历左子树
            inOrderTraversal(root.left);
            // 访问根节点
            System.out.print(root.val + " ");
            // 递归遍历右子树
            inOrderTraversal(root.right);
        }
    }

    // 后序遍历：左子树 -> 右子树 -> 根节点 LRM
    public static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            // 递归遍历左子树
            postOrderTraversal(root.left);
            // 递归遍历右子树
            postOrderTraversal(root.right);
            // 访问根节点
            System.out.print(root.val + " ");
        }
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    // 构造函数，用于初始化节点的值
    TreeNode(int val) {
        this.val = val;
    }
}