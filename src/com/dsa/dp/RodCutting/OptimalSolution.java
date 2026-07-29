package com.dsa.dp.RodCutting;

/* Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i (1-based Index).
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Note: The value of n is equal to the size of price array.*/

public class OptimalSolution {
	public static int findMaxVal(int n, int[] price) {
		
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return price[0];
		}
		
		int[] dp = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			dp[i] = price[i-1];
		}
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i/2; j++) {
				dp[i] = Math.max(dp[i], dp[j] + dp[i-j]);
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
		int n = price.length;
		
		System.out.println(findMaxVal(n, price));
	}
}
