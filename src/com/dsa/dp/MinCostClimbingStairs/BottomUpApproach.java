package com.dsa.dp.MinCostClimbingStairs;

/* You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.*/

public class BottomUpApproach {
	
	private static int minCost(int[] cost, int n, int[] dp) {
		if(n <= 1) {
			return 0;
		}
		dp[0] = 0;
		dp[1] = 0;
		for(int i = 2;i <= n; i++) {
			dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int[] cost = {10,15,20};
		int n = cost.length;
		int[] dp = new int[n+1];
		System.out.println(minCost(cost, n, dp));
	}
}
