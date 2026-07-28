package com.dsa.dp.PartitionEqualSubsetSum;

/* Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.
 * Note: Each element must be in exactly one subset.*/

public class Recursive {
	public static boolean findSubset(int n, int target, int[] arr) {
		if(target == 0) {
			return true;
		}
		if(n == 0 || target < 0) {
			return false;
		}
		
		return findSubset(n-1, target, arr) || findSubset(n-1, target-arr[n-1], arr);
	}
	public static void main(String[] args) {
		int[] arr = {2 , 3, 3, 8};
		int target = 0;
		int n = arr.length;
		
		for(int i = 0; i < n; i++) {
			target += arr[i];
		}
		
		if(target%2 == 1) {
			System.out.println("false");
			return;
		}
		
		System.out.println(findSubset(n, target/2,arr));
		
	}
}
