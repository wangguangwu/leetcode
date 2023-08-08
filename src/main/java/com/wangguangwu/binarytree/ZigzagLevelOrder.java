package com.wangguangwu.binarytree;

import java.util.*;

/**
 * @author wangguangwu
 */
public class ZigzagLevelOrder {


    public static void main(String[] args) {
        ZigzagLevelOrder solution = new ZigzagLevelOrder();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5, null, null)));
        List<List<Integer>> lists = solution.zigzagLevelOrder(root);
        System.out.println(lists);
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> current = new LinkedList<>();
        current.add(root);
        traverse(current, true);
        return res;
    }

    public void traverse(Deque<TreeNode> traverse, boolean forward) {
        // base case
        if (traverse.isEmpty()) {
            return;
        }
        List<Integer> level = new LinkedList<>();

        int size = traverse.size();
        for (int i = 0; i < size; i++) {
            if (forward) {
                TreeNode treeNode = traverse.pollFirst();
                level.add(treeNode.val);

                if (treeNode.left != null) {
                    traverse.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    traverse.addLast(treeNode.right);
                }
            } else {
                TreeNode treeNode = traverse.pollLast();
                level.add(treeNode.val);
                if (treeNode.right != null) {
                    traverse.offerFirst(treeNode.right);
                }
                if (treeNode.left != null) {
                    traverse.offerFirst(treeNode.left);
                }
            }
        }
        res.add(level);
        // 递归
        traverse(traverse, !forward);
    }
}
