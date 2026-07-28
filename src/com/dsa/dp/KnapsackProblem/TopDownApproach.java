package com.dsa.dp.KnapsackProblem;

import java.util.Arrays;

/* Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively,
 * and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).
 * The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.
 * Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.*/

public class TopDownApproach {
	public static int findMaxValue(int n, int W, int[] val, int[] wt, int[][] dp) {
		if(W < 0) {
			return Integer.MIN_VALUE;
		}
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		
		return dp[n][W] = Math.max(findMaxValue(n-1, W, val, wt, dp), val[n-1] + findMaxValue(n-1, W-wt[n-1], val, wt, dp));
	}
	
	public static void main(String[] args) {
		int[] val = {10, 40, 30, 50};
		int[] wt = {4, 5, 2, 3};
		int W = 5;
		
		int n = wt.length;
		int[][] dp = new int[n+1][W+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(findMaxValue(n, W, val, wt, dp));
	}
}
