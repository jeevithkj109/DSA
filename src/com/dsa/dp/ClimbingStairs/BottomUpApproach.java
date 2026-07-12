package com.dsa.dp.ClimbingStairs;

/*You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class BottomUpApproach {
	
	private static int waysToClimb(int n, int[] dp) {
		if(n <= 2) {
			return n;
		}
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[n+1];
		System.out.println(waysToClimb(n, dp));
	}
}
