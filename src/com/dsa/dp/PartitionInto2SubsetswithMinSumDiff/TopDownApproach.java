package com.dsa.dp.PartitionInto2SubsetswithMinSumDiff;

import java.util.Arrays;

public class TopDownApproach {

	private static int findMinDiff(int n, int sum1, int totalSum, int[] arr, int[][] dp) {
		if (n == 0) {
			int sum2 = totalSum - sum1;
			return Math.abs(sum1 - sum2);
		}
		if(dp[n][sum1] != -1) {
			return dp[n][sum1];
		}
		
		return dp[n][sum1] = Math.min(findMinDiff(n - 1, sum1 + arr[n - 1], totalSum, arr, dp), findMinDiff(n - 1, sum1, totalSum, arr, dp));
	}

	public static void main(String[] args) {

		int[] arr = { 1, 6, 11, 5 };
		int sum1 = 0, totalSum = 0, n = arr.length;
		for(int i = 0; i < n; i++) {
			totalSum += arr[i];
		}
		int[][] dp = new int[n+1][totalSum];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}

		System.out.println(findMinDiff(n, sum1, totalSum, arr, dp));
	}
}

/* Brute Force Idea*/

//	private static int findMinDiff(int n, int sum1, int sum2, int[] arr, int[][][] dp) {
//		if (n == 0) {
//			return Math.abs(sum1 - sum2);
//		}
//		if(dp[n][sum1[sum2] != -1) {
//			return dp[n][sum1[sum2];
//		}

//		return Math.min(findMinDiff(n - 1, sum1 + arr[n - 1], sum2, arr), findMinDiff(n - 1, sum1, sum2 + arr[n - 1], arr));
//	}
//
//	public static void main(String[] args) {
//
//		int[] arr = {1, 6, 11, 5};
//		int sum1 = 0, sum2 = 0, n = arr.length;
//		for(int i = 0; i < n; i++) {
//			totalSum += arr[i];
//		}
//		int[][][] dp = new int[n+1][totalSum+1][totalSum+1];
//		/* Fill all values to -1 */
//
//		System.out.println(findMinDiff(n, sum1, sum2, arr, dp));
//	}
