package com.dsa.dp.ClimbingStairs;

/*You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class TopDownApproach {
	
	private static int waysToClimb(int n, int[] dp) {
		if(n <= 2) {
			return n;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = waysToClimb(n-1, dp) + waysToClimb(n-2, dp);
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[n+1];
		System.out.println(waysToClimb(n, dp));
	}
}
