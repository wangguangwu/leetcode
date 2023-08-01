package com.wangguangwu.dp;

import java.util.Arrays;

/**
 * @author wangguangwu
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int result = solution.coinChange(new int[]{2, 5, 1}, 11);
        System.out.println(result);
    }

    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 设置一个无法达到的初始值
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
