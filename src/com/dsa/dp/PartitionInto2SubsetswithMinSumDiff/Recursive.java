package com.dsa.dp.PartitionInto2SubsetswithMinSumDiff;

/* Given an array arr[] containing non-negative integers, the task is to divide it into two sets set1 and set2
 * such that the absolute difference between their sums is minimum and find the minimum difference.*/

public class Recursive {

	private static int findMinDiff(int n, int sum1, int totalSum, int[] arr) {
		if (n == 0) {
			int sum2 = totalSum - sum1;
			return Math.abs(sum1 - sum2);
		}
		return Math.min(findMinDiff(n - 1, sum1 + arr[n - 1], totalSum, arr),
				findMinDiff(n - 1, sum1, totalSum, arr));
	}

	public static void main(String[] args) {

		int[] arr = { 1, 6, 11, 5 };
		int sum1 = 0, totalSum = 0, n = arr.length;
		for(int i = 0; i < n; i++) {
			totalSum += arr[i];
		}

		System.out.println(findMinDiff(n, sum1, totalSum, arr));
	}

}

/* Brute Force Idea*/

//	private static int findMinDiff(int n, int sum1, int sum2, int[] arr) {
//		if (n == 0) {
//			return Math.abs(sum1 - sum2);
//		}
//		return Math.min(findMinDiff(n - 1, sum1 + arr[n - 1], sum2, arr),
//				findMinDiff(n - 1, sum1, sum2 + arr[n - 1], arr));
//	}
//
//	public static void main(String[] args) {
//	
//		int[] arr = {1, 6, 11, 5};
//		int sum1 = 0, sum2 = 0, n = arr.length;
//	
//		System.out.println(findMinDiff(n, sum1, sum2, arr));
//	}
