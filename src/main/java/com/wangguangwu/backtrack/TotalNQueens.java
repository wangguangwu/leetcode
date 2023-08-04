package com.wangguangwu.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangguangwu
 */
public class TotalNQueens {

    public static void main(String[] args) {
        TotalNQueens solution = new TotalNQueens();
        int result = solution.totalNQueens(4);
        System.out.println(result);
    }

    int result = 0;

    public int totalNQueens(int n) {
        // 初始化棋盘
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return result;
    }

    private void backtrack(List<String> board, int row) {
        // base case
        if (row == board.size()) {
            result++;
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                // 不符合条件，跳过
                continue;
            }
            // 做选择
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            // 向下一层做决策
            backtrack(board, row + 1);

            // 取消选择
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    /**
     * 计算当前列的正上方、左上方、右上方是否存在皇后位置
     */
    private boolean isValid(List<String> board, int row, int col) {
        int n = board.get(row).length();

        // 当前列的正上方
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // 当前节点的右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 当前节点的左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
