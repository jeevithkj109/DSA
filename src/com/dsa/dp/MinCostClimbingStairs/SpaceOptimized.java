package com.dsa.dp.MinCostClimbingStairs;

/* You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.*/

public class SpaceOptimized {
	
	private static int minCost(int[] cost, int n, int[] dp) {
		if(n <= 1) {
			return 0;
		}
		dp[0] = 0;
		dp[1] = 0;
		dp[2] = Math.min(dp[0]+cost[0],dp[1]+cost[1]);
		for(int i = 3;i <= n; i++) {
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = Math.min(dp[0]+cost[i-2],dp[1]+cost[i-1]);
		}
		
		return dp[2];
	}
	
	public static void main(String[] args) {
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		int n = cost.length;
		int[] dp = new int[3];
		System.out.println(minCost(cost, n, dp));
	}
}
