package com.wangguangwu.stock;

import java.util.Arrays;

/**
 * @author wangguangwu
 */
public class MaxProfit6 {

    public static void main(String[] args) {
        MaxProfit6 solution = new MaxProfit6();
        int result = solution.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(result);
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        // 优化1：快速路径
        // 一次交易需要两天，大于 n/2，说明每天都可以交易
        // 这段代码不意味着每天都在买入和卖出，只是算法上的简化。
        // 连续的单日利润等于这段时间的总利润
        if (k > n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        // 优化2：降维处理
        // 不持有股票
        int[] dp0 = new int[k + 1];
        // 持有股票
        int[] dp1 = new int[k + 1];
        Arrays.fill(dp1, -prices[0]);

        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                dp0[j] = Math.max(dp0[j], dp1[j] + prices[i]);
                dp1[j] = Math.max(dp1[j], dp0[j - 1] - prices[i]);
            }
        }
        return dp0[k];
    }
}
