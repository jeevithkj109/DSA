package com.dsa.dp.Strings.MaxSumIncreasingSubsequence;

/* Given an array of positive integers arr[], find the maximum sum of a subsequence such that the elements of the subsequence
 * form a strictly increasing sequence.
 * In other words, among all strictly increasing subsequences of the array, return the one with the largest possible sum.*/

public class OptimalSolution {

	public static int maxSumIS(int arr[]) {

		int n = arr.length;

		int[] MSIS = arr.clone();
		int result = arr[0];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					MSIS[i] = Math.max(MSIS[i], arr[i] + MSIS[j]);
				}
			}
			result = Math.max(result, MSIS[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 101, 2, 3, 100 };

		System.out.println(maxSumIS(arr));
	}
}
