package com.dsa.dp.Fibonacci;

public class SpaceOptimized {
	
	private static int fibonacci(int n, int[] dp) {
		
		if(n <= 1) {
			return n;
		}
		
		dp[1] = 0;
		dp[2] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = dp[0] + dp[1];
		}
		return dp[2];
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[3];
		System.out.println(fibonacci(n, dp));
	}
}
