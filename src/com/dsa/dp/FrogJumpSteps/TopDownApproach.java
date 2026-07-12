package com.dsa.dp.FrogJumpSteps;

/* A Frog jumps either 1, 2 or 3 steps to reach the top of a staircase with n steps.
 * Calculate the number of distinct ways the frog can reach the nth step.*/

public class TopDownApproach {
	private static int waysToJump(int n, int[] dp) {
		if(n <= 2) {
			return n;
		}
		if(n == 3) {
			return 4;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		return dp[n] = waysToJump(n-1, dp) + waysToJump(n-2, dp) + waysToJump(n-3, dp);
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] dp = new int[n+1];
		System.out.println(waysToJump(n, dp));
	}
}
