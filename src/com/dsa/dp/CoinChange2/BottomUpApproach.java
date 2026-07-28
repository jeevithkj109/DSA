package com.dsa.dp.CoinChange2;

/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The final answer is guaranteed to fit into a signed 32-bit integer.*/

public class BottomUpApproach {
	
	public static int totalWays(int n, int amount, int[] arr, int[][] dp) {
		if(amount == 0) {
			return 1;
		}
		if(n == 0 || amount < 0) {
			return 0;
		}
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= amount; j++) {
				if(j-arr[i-1] >= 0) {
					dp[i][j] = dp[i-1][j] + dp[i][j-arr[i-1]];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][amount];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5};
		int amount = 5;
		
		int n = arr.length;
		int[][] dp = new int[n+1][amount+1];
		
		System.out.println(totalWays(n, amount, arr, dp));
	}
}
