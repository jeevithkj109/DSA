package com.dsa.dp.BestTimeToBuyAndSellStock_III;

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/

public class Recursive {
	
	private static int maximumProfit(int index, int buy, int transaction, int n, int[] prices) {
		
		if(transaction == 0 || index == n) {
			return 0;
		}
		
		if(buy == 1) {
			return Math.max(-prices[index]+maximumProfit(index+1, 0, transaction, n, prices), maximumProfit(index+1, 1, transaction, n, prices));
		}
		else {
			return Math.max(prices[index]+maximumProfit(index+1, 1, transaction-1, n, prices), maximumProfit(index+1, 0, transaction, n, prices));
		}
	}
	
	public static void main(String[] args) {
		int[] profits = {3,3,5,0,0,3,1,4};
		int n = profits.length;
		
		System.out.println(maximumProfit(0, 1, 2, n, profits));
	}
}
