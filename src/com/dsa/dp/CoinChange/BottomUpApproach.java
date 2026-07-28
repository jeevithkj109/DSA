package com.dsa.dp.CoinChange;

/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.*/

public class BottomUpApproach {

	private static int findMinCoins(int n, int amount, int[] coins) {
		
		if(amount == 0) {
			return 0;
		}
		if(n == 0 || amount < 0) {
			return -1;
		}
		
		int[][] dp = new int[n+1][amount+1];
		
		// initialize n==0(0th row) with 1e9
		// initialize all amount==0(0th column) with 0
		for(int j = 1; j <= amount; j++) {
			dp[0][j] = (int)1e9;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= amount; j++) {
				if(j-coins[i-1] >= 0) {
					dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][amount] >= (int)1e9? -1 : dp[n][amount] ;
		
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		
		int n = coins.length;
		
		int answer = findMinCoins(n, amount, coins);
		
		System.out.println(answer);
	}
}
