package com.dsa.dp.BestTimeToBuyAndSellStock_III;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/

public class SpaceOptimized {

	private static int maximumProfit(int n, int[] prices) {
		
		int[][] prev = new int[2][3];

		for (int i = n-1; i >= 0; i--) {
			int[][] curr = new int[2][3];
			for (int j = 0; j <= 1; j++) {
				for (int k = 1; k <= 2; k++) {
					if (j == 1) {
						curr[j][k] = Math.max(-prices[i] + prev[0][k], prev[1][k]);
					} else {
						curr[j][k] = Math.max(prices[i] + prev[1][k - 1], prev[0][k]);
					}
				}
			}
			prev = curr;
		}
		
		return prev[1][2];

	}

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 4, 5 };
		int n = prices.length;

		System.out.println(maximumProfit(n, prices));
	}
}
