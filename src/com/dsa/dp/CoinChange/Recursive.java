package com.dsa.dp.CoinChange;

/* You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.*/

public class Recursive {

	private static int findMinCoins(int n, int amount, int[] coins) {
		
		if(amount == 0) {
			return 0;
		}
		if(n == 0 || amount < 0) {
			return (int) 1e9;
		}
		
		return Math.min(findMinCoins(n-1, amount, coins), 1+findMinCoins(n, amount-coins[n-1], coins));
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 2};
		int amount = 5;
		
		int n = coins.length;
		
		int answer = findMinCoins(n, amount, coins);
		
		if(answer >= (int)1e9) {
			System.out.println(-1);
		}
		else {
			System.out.println(answer);
		}
	}
}
