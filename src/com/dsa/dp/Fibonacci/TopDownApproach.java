package com.dsa.dp.Fibonacci;

public class TopDownApproach {
	
	private static int fibonacci(int n, int[] dp) {
		if(n == 0 || n == 1) {
			return n;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = fibonacci(n-1, dp) + fibonacci(n-2, dp);
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[n+1];
		System.out.println(fibonacci(n, dp));
	}
}
