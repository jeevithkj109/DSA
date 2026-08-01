package com.dsa.dp.BestTimeToBuyAndSellStockWithCooldown;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/

public class OptimalSolution {

	private static int maximumProfit(int[] prices) {

		int n = prices.length;

		int[][] dp = new int[n + 1][2];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				if (j == 1) {
					dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
				}
				else {
					if (i + 2 <= n) {
						dp[i][j] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
					}
					else {
						dp[i][j] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
					}
				}
			}
		}

		return dp[0][1];
	}

	public static void main(String[] args) {
		int[] prices = {};

		System.out.println(maximumProfit(prices));
	}
}
