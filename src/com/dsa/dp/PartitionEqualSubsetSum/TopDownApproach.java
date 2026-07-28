package com.dsa.dp.PartitionEqualSubsetSum;

import java.util.Arrays;

/* Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.
 * Note: Each element must be in exactly one subset.*/

public class TopDownApproach {
	public static int findSubset(int n, int target, int[] arr, int[][] dp) {
		if(target == 0) {
			return 1;
		}
		if(n == 0 || target < 0) {
			return 0;
		}
		if(dp[n][target] != -1) {
			return dp[n][target];
		}
		
		return dp[n][target] = findSubset(n-1, target, arr, dp) | findSubset(n-1, target-arr[n-1], arr, dp);
	}
	public static void main(String[] args) {
		int[] arr = {2 , 3, 3, 8};
		int target = 0;
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			target += arr[i];
		}
		
		if(target%2 == 1) {
			System.out.println(0);
			return;
		}
		
		int[][] dp = new int[n+1][target+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(findSubset(n, target/2,arr, dp));
		
	}
}
