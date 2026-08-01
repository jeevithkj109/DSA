package com.dsa.dp.BestTimeToBuyAndSellStockWithTransactionFee;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * Note:
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.*/

public class BottomUpApproach {

	private static int maximumProfit(int fee, int[] prices) {

		int n = prices.length;

		// int[index][buy]
		// index: 0 to n (n+1) -> i: n to 0
		// buy: 1 to 0 (2) -> j: 0 to 1
		// j == 1: dp[i][j] = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
		// j == 0: dp[i][j] = Math.max(prices[i]-fee+dp[i+1][1], dp[i+1][0]);
		int[][] dp = new int[n + 1][2];

		for(int i = n-1; i >= 0; i--) {
			for(int j = 0; j <= 1; j++) {
				if(j == 1) {
					dp[i][j] = Math.max(-prices[i]+dp[i+1][0], dp[i+1][1]);
				}
				else {
					dp[i][j] = Math.max(prices[i]-fee+dp[i+1][1], dp[i+1][0]);
				}
			}
		}
		return dp[0][1];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 7, 5, 10, 3 };
		int fee = 3;

		System.out.println(maximumProfit(fee, prices));
	}
}
