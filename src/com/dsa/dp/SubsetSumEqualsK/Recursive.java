package com.dsa.dp.SubsetSumEqualsK;

/* Given an array of positive integers arr[] and a value k, determine if there is a subset of arr[] with sum equal to given k. */

public class Recursive {

	public static boolean findSubset(int index, int sum, int[] arr) {
		
		if(sum == 0) {
			return true;
		}
		if(sum < 0 || index < 0) {
			return false;
		}
		
		//Not pick OR pick
		return findSubset(index-1, sum, arr) || findSubset(index-1, sum-arr[index], arr);
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 5, 3, 6, 8, 1};
		int k = 15;
		int n = arr.length;
		
		System.out.println(findSubset(n-1, k, arr));
	}
}
