package com.dsa.dp.KnapsackProblem;

/* Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively,
 * and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).
 * The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.
 * Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.*/

public class BottomUpApproach {
	public static int findMaxValue(int n, int W, int[] val, int[] wt) {
		
		if(n == 0 || W == 0) {
			return 0;
		}
		
		int[][] dp = new int[n+1][W+1]; //make first row and first column as 0
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= W; j++) {
				if(j-wt[i-1] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][W];
	}
	
	public static void main(String[] args) {
		int[] val = {10, 40, 30, 50};
		int[] wt = {4, 5, 2, 3};
		int W = 5;
		
		int n = wt.length;
		
		System.out.println(findMaxValue(n, W, val, wt));
	}
}
