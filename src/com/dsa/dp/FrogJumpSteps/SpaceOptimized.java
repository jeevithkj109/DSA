package com.dsa.dp.FrogJumpSteps;

/* A Frog jumps either 1, 2 or 3 steps to reach the top of a staircase with n steps.
 * Calculate the number of distinct ways the frog can reach the nth step.*/

public class SpaceOptimized {
	private static int waysToJump(int n, int[] dp) {
		if(n <= 2) {
			return n;
		}
		if(n == 3) {
			return 4;
		}
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= n; i++) {
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = dp[3];
			dp[3] = dp[0] + dp[1] + dp[2];
		}
		return dp[3];
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[4];
		System.out.println(waysToJump(n, dp));
	}
}
