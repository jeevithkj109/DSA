package com.dsa.dp.CoinChange;

import java.util.Arrays;

/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.*/

public class SpaceOptimized {

	private static int findMinCoins(int n, int amount, int[] coins) {
		
		if(amount == 0) {
			return 0;
		}
		if(n == 0 || amount < 0) {
			return -1;
		}
		
		int[] dp = new int[amount+1];
		Arrays.fill(dp, (int)1e9);
		dp[0] = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = coins[i]; j <= amount; j++) {
				dp[j] = Math.min(dp[j], 1 + dp[j-coins[i]]);
			}
		}
		
		return dp[amount] >= (int)1e9? -1 : dp[amount] ;
		
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 9;
		
		int n = coins.length;
		
		int answer = findMinCoins(n, amount, coins);
		
		System.out.println(answer);
	}
}

/* First thought */

//public class SpaceOptimized {
//
//	private static int findMinCoins(int n, int amount, int[] coins) {
//		
//		if(amount == 0) {
//			return 0;
//		}
//		if(n == 0 || amount < 0) {
//			return -1;
//		}
//		
//		int[] prev = new int[amount+1];
//		
//		for(int j = 1; j <= amount; j++) {
//			prev[j] = (int)1e9;
//		}
//		
//		for(int i = 1; i <= n; i++) {
//			int[] curr = new int[amount+1];
//			for(int j = 1; j <= amount; j++) {
//				if(j-coins[i-1] >= 0) {
//					curr[j] = Math.min(prev[j], 1 + curr[j-coins[i-1]]);
//				}
//				else {
//					curr[j] = prev[j];
//				}
//			}
//			prev = curr;
//		}
//		
//		return prev[amount] >= (int)1e9? -1 : prev[amount] ;
//		
//	}
//	
//	public static void main(String[] args) {
//		int[] coins = {1, 2, 5};
//		int amount = 11;
//		
//		int n = coins.length;
//		
//		int answer = findMinCoins(n, amount, coins);
//		
//		System.out.println(answer);
//	}
//}
