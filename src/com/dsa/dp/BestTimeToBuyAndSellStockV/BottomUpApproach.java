package com.dsa.dp.BestTimeToBuyAndSellStockV;

/* You are given an integer array prices where prices[i] is the price of a stock in dollars on the ith day, and an integer k.
 * You are allowed to make at most k transactions, where each transaction can be either of the following:
 * Normal transaction: Buy on day i, then sell on a later day j where i < j. You profit prices[j] - prices[i].
 * Short selling transaction: Sell on day i, then buy back on a later day j where i < j. You profit prices[i] - prices[j].
 * Note that you must complete each transaction before starting another.
 * Additionally, you can't buy or sell on the same day you are selling or buying back as part of a previous transaction.
 * Return the maximum total profit you can earn by making at most k transactions.*/

public class BottomUpApproach {
	
	private static int maximumProfit(int transaction, int[] prices) {
		int n = prices.length;
		
		if(transaction == 0) {
			return 0;
		}
		
		//index: 0 to n (n+1) -> i: n to 0
		//buy: 2 to 0: (3) -> j: 0 to 2
		// j == 2: dp[i][j][k] = Math.max(dp[i+1][2][k], Math.max(-prices[i]+dp[i+1][0][k], prices[i]+dp[i+1][1][k]));
		// j == 1: dp[i][j][k] = Math.max(-prices[i]+dp[i+1][2][k-1], dp[i+1][1][k]);
		//j == 0: dp[i][j][k] = Math.max(prices[i]+dp[i+1][2][k-1], dp[i+1][0][k];
		//transaction: k to 0 (transaction+1) -> k: 0 to transaction
		int[][][] dp = new int[n+1][3][transaction+1];
		
		//Initialization
		// for k == 0: make all values 0 (default)
		// for i == n: if j == 1 make values to int_min else make all values 0
		for(int k = 0; k <= transaction; k++) {
			dp[n][1][k] = Integer.MIN_VALUE;
		}
		
		for(int i = n-1; i >= 0; i--) {
			for(int j = 0; j <= 2; j++) {
				for(int k = 1; k <= transaction; k++) {
					if(j == 2) {
						dp[i][j][k] = Math.max(dp[i+1][2][k], Math.max(-prices[i]+dp[i+1][0][k], prices[i]+dp[i+1][1][k]));
					}
					else if(j == 1) {
						dp[i][j][k] = Math.max(-prices[i]+dp[i+1][2][k-1], dp[i+1][1][k]);
					}
					else {
						dp[i][j][k] =Math.max(prices[i]+dp[i+1][2][k-1], dp[i+1][0][k]);
					}
				}
			}
		}
		
		return dp[0][2][transaction];
		
	}
	
	public static void main(String[] args) {
		int[] prices = {12,16,19,19,8,1,19,13,9};
		int k = 3;
		
		System.out.println(maximumProfit(k, prices));
	}
}
