package com.wangguangwu.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 皇后可以攻击同一行、同一列、左上左下右上右下四个方向的任意单位。
 *
 * @author wangguangwu
 */
public class SolveNQueens {

    List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        SolveNQueens solution = new SolveNQueens();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }

    /**
     * 输入棋盘边长 n，返回所有合法的位置
     */
    public List<List<String>> solveNQueens(int n) {
        List<String> board = new ArrayList<>();
        // 初始化棋盘
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        // 回溯
        backtrack(board, 0);
        return res;
    }

    /**
     * 是否可以在 board[row][col] 的位置放置皇后
     */
    private void backtrack(List<String> board, int row) {
        // base case
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                // 当前位置不能放置皇后，跳过
                continue;
            }
            // 做选择
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            // 进入下一个决策树
            backtrack(board, row + 1);

            // 取消选择
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    private boolean isValid(List<String> board, int row, int col) {
        // 放数据是从上往下一层层放的，所以只需要检测上层数据是否冲突
        int n = board.size();

        // 检查列是否有皇后相互冲突
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后相互冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后相互冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
