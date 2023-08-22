package com.wangguangwu.stock;

/**
 * @author wangguangwu
 */
public class MaxProfit4 {

    public static void main(String[] args) {
        MaxProfit4 solution = new MaxProfit4();
        int result = solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(result);
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }
}
