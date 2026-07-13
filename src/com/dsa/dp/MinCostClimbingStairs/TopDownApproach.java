package com.dsa.dp.MinCostClimbingStairs;

/* You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.*/

public class TopDownApproach {
	
	private static int minCost(int[] cost, int n, int[] dp) {
		if(n <= 1) {
			return 0;
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = Math.min(minCost(cost, n-1, dp) + cost[n-1], minCost(cost, n-2, dp) + cost[n-2]);
	}
	
	public static void main(String[] args) {
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		int n = cost.length;
		int[] dp = new int[n+1];
		System.out.println(minCost(cost, n, dp));
	}
}
