package com.dsa.dp.CoinChange;

import java.util.Arrays;

/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.*/

public class TopDownApproach {

	private static int findMinCoins(int n, int amount, int[] coins, int[][] dp) {
		
		if(amount == 0) {
			return 0;
		}
		if(n == 0 || amount < 0) {
			return (int) 1e9;
		}
		if(dp[n][amount] != -1) {
			return dp[n][amount];
		}
		
		return dp[n][amount] = Math.min(findMinCoins(n-1, amount, coins, dp), 1+findMinCoins(n, amount-coins[n-1], coins, dp));
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 2};
		int amount = 5;
		
		int n = coins.length;
		int[][] dp = new int[n+1][amount+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		int answer = findMinCoins(n, amount, coins, dp);
		
		if(answer >= (int)1e9) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}
	}
}
