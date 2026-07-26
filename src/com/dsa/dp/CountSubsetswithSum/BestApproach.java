package com.dsa.dp.CountSubsetswithSum;

/*Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.*/

public class BestApproach {
	public static int totalSubset(int size, int target, int[] arr) {

		if(size == 0) {
			if(target == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		int[] curr = new int[target + 1];
		curr[0]= 1;
		if(arr[0] <= target) {
			curr[arr[0]]++;
		}
		
		for(int i = 1; i < size; i++) {
			for(int j = target; j >= 0; j--) {
				if(j-arr[i] >= 0) {
					curr[j] = curr[j] + curr[j-arr[i]];
				}
				else {
					curr[j] = curr[j];
				}
			}
		}
		return curr[target];
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 10, 6, 8 };
		int target = 10;
		int n = arr.length;

		System.out.println(totalSubset(n, target, arr));
	}
}
