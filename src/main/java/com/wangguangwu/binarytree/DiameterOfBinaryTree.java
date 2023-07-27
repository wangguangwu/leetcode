package com.wangguangwu.binarytree;

/**
 * 遇到子树问题，首先想到的是给函数设置返回值，然后在后序位置进行处理
 *
 * @author wangguangwu
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();
        System.out.println(solution.diameterOfBinaryTree(root));
    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = leftDepth + rightDepth;
        maxDiameter = Math.max(myDiameter, maxDiameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
