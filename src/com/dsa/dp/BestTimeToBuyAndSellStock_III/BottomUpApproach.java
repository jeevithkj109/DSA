package com.dsa.dp.BestTimeToBuyAndSellStock_III;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/

public class BottomUpApproach {

	private static int maximumProfit(int n, int[] prices) {
		
		// int[index][buy][transaction]
		// index - 0 to n (n+1)-> i: n to 0
		// buy - 1 to 0 (2)-> j: 0 to 1
		// j == 1: dp[i][j][k] = Math.max(-prices[i]+dp[i+1][0][k], dp[i+1][1][k])
		// j == 0: dp[i][j][k] = Math.max(prices[i]+dp[i+1][1][k-1], dp[i+1][0][k])
		// transaction - 2, 1, 0 (3)-> k: 0 to 2
		int[][][] dp = new int[n+1][2][3];
		
		//Initialization
		//If k == 0: Make everything 0
		// If i == n: Make everything 0

		for (int i = n-1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				for (int k = 1; k <= 2; k++) {
					if (j == 1) {
						dp[i][j][k] = Math.max(-prices[i] + dp[i + 1][0][k], dp[i + 1][1][k]);
					} else {
						dp[i][j][k] = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
					}
				}
			}
		}
		
		return dp[0][1][2];

	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 4, 5 };
		int n = prices.length;

		System.out.println(maximumProfit(n, prices));
	}
}
