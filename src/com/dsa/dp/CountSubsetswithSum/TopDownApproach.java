package com.dsa.dp.CountSubsetswithSum;

import java.util.Arrays;

/*Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.*/

public class TopDownApproach {
	public static int totalSubset(int n, int target, int[] arr, int[][] dp) {

		if (n == 0) {
			if (target == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		if (target < 0) {
			return 0;
		}
		
		if (dp[n][target] != -1) {
			return dp[n][target];
		}

		// Not pick OR pick
		return dp[n][target] = totalSubset(n - 1, target, arr, dp) + totalSubset(n - 1, target - arr[n-1], arr, dp);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 10, 6, 8 };
		int target = 10;
		int n = arr.length;

		int[][] dp = new int[n+1][target + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(totalSubset(n, target, arr, dp));
	}
}
