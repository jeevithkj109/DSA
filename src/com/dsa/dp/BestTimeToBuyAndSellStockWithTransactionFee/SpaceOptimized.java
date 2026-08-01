package com.dsa.dp.BestTimeToBuyAndSellStockWithTransactionFee;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * Note:
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.*/

public class SpaceOptimized {

	private static int maximumProfit(int fee, int[] prices) {

		int n = prices.length;

		int[] dp = new int[2];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				if (j == 1) {
					dp[j] = Math.max(-prices[i] + dp[0], dp[1]);
				}
				else {
					dp[j] = Math.max(prices[i] - fee + dp[1], dp[0]);
				}
			}
		}
		return dp[1];
	}

	public static void main(String[] args) {
		int[] prices = { 1, 3, 7, 5, 10, 3 };
		int fee = 3;

		System.out.println(maximumProfit(fee, prices));
	}
}

/* First thought */

//public class SpaceOptimized {
//
//	private static int maximumProfit(int fee, int[] prices) {
//
//		int n = prices.length;
//
//		int[] prev = new int[2];
//
//		for(int i = n-1; i >= 0; i--) {
//			int[] curr = new int[2];
//			for(int j = 0; j <= 1; j++) {
//				if(j == 1) {
//					curr[j] = Math.max(-prices[i]+prev[0], prev[1]);
//				}
//				else {
//					curr[j] = Math.max(prices[i]-fee+prev[1], prev[0]);
//				}
//			}
//			prev = curr;
//		}
//		return prev[1];
//	}
//
//	public static void main(String[] args) {
//		int[] prices = { 1, 3, 7, 5, 10, 3 };
//		int fee = 3;
//
//		System.out.println(maximumProfit(fee, prices));
//	}
//}
