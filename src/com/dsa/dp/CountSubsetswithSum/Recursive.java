package com.dsa.dp.CountSubsetswithSum;

/*Given an array arr of non-negative integers and an integer target, the task is to count all subsets of the array whose sum is equal to the given target.*/

public class Recursive {
public static int totalSubset(int index, int target, int[] arr) {
		
		if(index < 0) {
			if(target == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		if(target < 0) {
			return 0;
		}
		
		//Not pick OR pick
		return totalSubset(index-1, target, arr) + totalSubset(index-1, target-arr[index], arr);
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 2, 3, 10, 6, 8};
		int target = 10;
		int n = arr.length;
		
		System.out.println(totalSubset(n-1, target, arr));
	}
}
