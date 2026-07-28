package com.dsa.dp.CoinChange2;

import java.util.Arrays;

/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The final answer is guaranteed to fit into a signed 32-bit integer.*/

public class TopDownApproach {
	
	public static int totalWays(int n, int amount, int[] arr, int[][] dp) {
		if(amount == 0) {
			return 1;
		}
		if(n == 0 || amount < 0) {
			return 0;
		}
		if(dp[n][amount] != -1) {
			return dp[n][amount];
		}
		
		return dp[n][amount] = totalWays(n-1, amount, arr, dp) + totalWays(n, amount-arr[n-1], arr, dp);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5};
		int amount = 5;
		
		int n = arr.length;
		int[][] dp = new int[n+1][amount+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		
		System.out.println(totalWays(n, amount, arr, dp));
	}
}
