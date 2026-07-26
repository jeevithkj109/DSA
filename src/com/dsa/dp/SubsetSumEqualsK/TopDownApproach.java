package com.dsa.dp.SubsetSumEqualsK;

/* Given an array of positive integers arr[] and a value k, determine if there is a subset of arr[] with sum equal to given k. */

import java.util.Arrays;

public class TopDownApproach {
	public static int findSubset(int index, int sum, int[] arr, int[][] dp) {

		if (sum == 0) {
			return 1;
		}
		if (sum < 0 || index < 0) {
			return 0;
		}
		
		if(dp[index][sum] != -1) {
			return dp[index][sum];
		}

		// Not pick OR pick
		return dp[index][sum] = findSubset(index - 1, sum, arr, dp) | findSubset(index - 1, sum - arr[index], arr, dp);
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 6, 8, 1 };
		int k = 50;
		int n = arr.length;
		
		int[][] dp = new int[n][k+1];
		for (int[] row : dp) {
		    Arrays.fill(row, -1);
		}
		System.out.println(findSubset(n - 1, k, arr, dp));
	}
}
