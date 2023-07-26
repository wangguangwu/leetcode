package com.wangguangwu.binarytree;

/**
 * @author wangguangwu
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        MaxDepth solution = new MaxDepth();
        System.out.println(solution.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        return traverse(root);
    }

    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = traverse(root.left);
        int rightDepth = traverse(root.right);
        // 后序遍历
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
