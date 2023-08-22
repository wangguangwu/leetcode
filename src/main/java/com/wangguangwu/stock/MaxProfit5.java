package com.wangguangwu.stock;

/**
 * @author wangguangwu
 */
public class MaxProfit5 {

    public static void main(String[] args) {
        MaxProfit5 solution = new MaxProfit5();
        int result = solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        // 最大交易次数
        int maxK = 2;
        int n = prices.length;
        int[][][] dp = new int[n][maxK + 1][2];
        for (int i = 0; i < n; i++) {
            // 当 k = 0 时，表示没有交易机会，值为 0
            for (int k = maxK; k >= 1; k--) {
                if (i == 0) {
                    // base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                // 第 i 天，还可以进行 k 次交易，手上没有股票
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                // 第 i 天，还可以进行 k 次交易，手上有股票
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }
}
