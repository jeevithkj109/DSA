package com.dsa.dp.BestTimeToBuyAndSellStockWithTransactionFee;

import java.util.Arrays;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * Note:
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.*/

public class TopDownApproach {
	
	private static int maximumProfit(int index, int buy, int fee, int n, int[] prices, int[][] dp) {
		
		if(index == n) {
			return 0;
		}
		
		if(dp[index][buy] != -1) {
			return dp[index][buy];
		}
		
		if(buy == 1) {
			return dp[index][buy] = Math.max(-prices[index]+maximumProfit(index+1, 0, fee, n, prices, dp),
					maximumProfit(index+1, 1, fee, n, prices, dp));
		}
		else {
			return dp[index][buy] = Math.max(prices[index]-fee+maximumProfit(index+1, 1, fee, n, prices, dp),
					maximumProfit(index+1, 0, fee, n, prices, dp));
		}
	}
	
	public static void main(String[] args) {
		int[] prices = {1,3,7,5,10,3};
		int fee = 3;
		
		int n = prices.length;
		// int[index][buy]
		// index: 0 to n (n+1)
		// buy: 1 to 0 (2)
		int[][] dp = new int[n+1][2];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(maximumProfit(0, 1, fee, n, prices, dp));
	}
}
