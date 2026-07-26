package com.dsa.dp.SubsetSumEqualsK;

/* Given an array of positive integers arr[] and a value k, determine if there is a subset of arr[] with sum equal to given k. */

public class BestApproach {
	
	public static boolean findSubset(int n, int k, int[] arr) {
		if (k == 0) {
			return true;
		}
		if (k < 0 || n == 0) {
			return false;
		}
		boolean[] curr = new boolean[k+1];
		curr[0] = true;
		if(arr[0] <= k) {
			curr[arr[0]] = true;
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = k; j > 0; j--) {
				
				if(j-arr[i] >= 0) {
					curr[j] = curr[j] || curr[j-arr[i]];
				}
			}
		}
		
		return curr[k];
	}
	
	public static void main(String[] args) {
		int[] arr = { 2, 5, 3, 6, 8, 1 };
		int k = 10;
		int n = arr.length;

		System.out.println(findSubset(n, k, arr));
	}
}
