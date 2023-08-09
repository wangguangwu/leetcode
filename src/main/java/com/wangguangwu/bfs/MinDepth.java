package com.wangguangwu.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangguangwu
 */
public class MinDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(4, null, null), new TreeNode(5, null, null)));
        MinDepth solution = new MinDepth();
        System.out.println(solution.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // root 本身就是第一层
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 达到叶子节点
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                // 将 cur 的相邻节点加入队列
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            // 遍历完一层后，加一
            depth++;
        }
        return depth;
    }
}
