package com.wangguangwu.stock;

/**
 * @author wangguangwu
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            // 今天没有股票的最大收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 今天持有股票的最大收益
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();
        int maxProfit = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }
}
