package com.dsa.dp.SubsetSumEqualsK;

/* Given an array of positive integers arr[] and a value k, determine if there is a subset of arr[] with sum equal to given k. */

public class BottomUpApproach {
	public static int findSubset(int n, int k, int[] arr, int[][] dp) {

		if (k == 0) {
			return 1;
		}
		if (k < 0 || n == 0) {
			return 0;
		}
		// Fill values in dp for sum == 0
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		if(arr[0] <= k) {
			dp[0][arr[0]] = 1;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= k; j++) {
				if(j-arr[i] >= 0) {
					dp[i][j] = dp[i-1][j] | dp[i-1][j-arr[i]];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		return dp[n-1][k];
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 6, 8, 1 };
		int k = 10;
		int n = arr.length;

		int[][] dp = new int[n][k + 1];

		System.out.println(findSubset(n, k, arr, dp));
	}
}
