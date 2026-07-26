package com.dsa.dp.CountSubsetswithSum;

/*Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.*/

public class BottomUpApproach {
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
		
		dp[0][0] = 1;

		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= target; j++) {
				if(j-arr[i-1] >= 0) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		return dp[n][target];
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 10, 6, 8 };
		int target = 10;
		int n = arr.length;

		int[][] dp = new int[n+1][target + 1];

		System.out.println(totalSubset(n, target, arr, dp));
	}
}
