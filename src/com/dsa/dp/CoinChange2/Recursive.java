package com.dsa.dp.CoinChange2;

/*You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The final answer is guaranteed to fit into a signed 32-bit integer.*/

public class Recursive {
	
	public static int totalWays(int n, int amount, int[] arr) {
		if(amount == 0) {
			return 1;
		}
		if(n == 0 || amount < 0) {
			return 0;
		}
		
		return totalWays(n-1, amount, arr) + totalWays(n, amount-arr[n-1], arr);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 5};
		int amount = 5;
		
		int n = arr.length;
		System.out.println(totalWays(n, amount, arr));
	}
}
