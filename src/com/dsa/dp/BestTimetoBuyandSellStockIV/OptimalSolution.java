package com.dsa.dp.BestTimetoBuyandSellStockIV;

/* You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/

public class OptimalSolution {

	private static int maximumProfit(int transaction, int[] prices) {
		int n = prices.length;
		int[][] prev = new int[2][transaction + 1];

		for (int i = n - 1; i >= 0; i--) {
			int[][] curr = new int[2][transaction + 1];
			for (int j = 0; j <= 1; j++) {
				for (int k = 1; k <= transaction; k++) {
					if (j == 1) {
						curr[j][k] = Math.max(-prices[i] + prev[0][k], prev[1][k]);
					} else {
						curr[j][k] = Math.max(prices[i] + prev[1][k - 1], prev[0][k]);
					}
				}
			}
			prev = curr;
		}

		return prev[1][transaction];
	}

	public static void main(String[] args) {
		int[] prices = { 3, 2, 6, 5, 0, 3 };
		int transaction = 2;

		System.out.println(maximumProfit(transaction, prices));
	}
}
