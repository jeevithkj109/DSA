package com.dsa.dp.CountSubsetswithSum;

/*Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.*/

public class SpaceOptimized {
	public static int totalSubset(int size, int target, int[] arr) {

		if(size == 0) {
			if(target == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		if (target < 0) {
			return 0;
		}
		
		int[] prev = new int[target + 1];
		prev[0]= 1;
		if(arr[0] <= target) {
			prev[arr[0]]++;
		}
		
		for(int i = 1; i < size; i++) {
			int[] curr = new int[target + 1];
			
			for(int j = 0; j <= target; j++) {
				if(j-arr[i] >= 0) {
					curr[j] = prev[j] + prev[j-arr[i]];
				}
				else {
					curr[j] = prev[j];
				}
			}
			prev = curr;
		}
		return prev[target];
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 3, 10, 6, 8 };
		int target = 10;
		int n = arr.length;

		System.out.println(totalSubset(n, target, arr));
	}
}
