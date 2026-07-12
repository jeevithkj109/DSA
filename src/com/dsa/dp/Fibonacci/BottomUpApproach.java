package com.dsa.dp.Fibonacci;

public class BottomUpApproach {

	private static int fibonacci(int n, int[] dp) {
		
		if(n <= 1) {
			return n;
		}
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[] dp = new int[n+1];
		System.out.println(fibonacci(n, dp));
	}
}
