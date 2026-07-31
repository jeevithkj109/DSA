package com.dsa.dp.BestTimeToBuyAndSellStock_III;

import java.util.Arrays;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/

public class TopDownApproach {
	
	private static int maximumProfit(int index, int buy, int transaction, int n, int[] prices, int[][][] dp) {
		
		if(transaction == 0 || index == n) {
			return 0;
		}
		
		if(dp[index][buy][transaction] != -1) {
			return dp[index][buy][transaction];
		}
		
		
		if(buy == 1) {
			return dp[index][buy][transaction] = Math.max(-prices[index]+maximumProfit(index+1, 0, transaction, n, prices, dp),
					maximumProfit(index+1, 1, transaction, n, prices, dp));
		}
		else {
			return dp[index][buy][transaction] = Math.max(prices[index]+maximumProfit(index+1, 1, transaction-1, n, prices, dp),
					maximumProfit(index+1, 0, transaction, n, prices, dp));
		}
	}
	
	public static void main(String[] args) {
		int[] profits = {1,2,3,4,5};
		int n = profits.length;
		
		
		//int[index][buy][transaction]
		// index - 0 to n
		// buy - 0 to 1
		// transaction - 2 to 0
		int[][][] dp = new int[n+1][2][3];
		for(int[][] rows: dp) {
			for(int[] row: rows) {
				Arrays.fill(row, -1);
			}
		}
		
		System.out.println(maximumProfit(0, 1, 2, n, profits, dp));
	}
}
