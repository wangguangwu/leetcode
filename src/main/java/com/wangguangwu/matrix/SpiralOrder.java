package com.wangguangwu.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 思路：
 * 1. 维护 4 个边界：上（top）、下（bottom）、左（left）、右（right）
 * 2. 维护从左往右、从上到下、从右到左、从下到上的顺序遍历
 * 3. 每完成一次遍历后，调整对应的边界
 * 4. 重复上述过程，直到所有的元素都被遍历。
 *
 * @author wangguangwu
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        // 上边界
        int top = 0;
        // 下边界
        int bottom = matrix.length - 1;
        // 左边界
        int left = 0;
        // 右边界
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            // 调整上边界
            top++;

            // 从上到下
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            // 调整右边界
            right--;

            // 从右到左
            // m 行 n 列
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                // 调整下边界
                bottom--;
            }

            // 从下到上
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                // 调整左边界
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder solution = new SpiralOrder();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = solution.spiralOrder(matrix);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
