package com.dsa.dp.Strings.LongestBitonicSubsequence;

import java.util.Arrays;

/* Given an array of positive integers. Find the maximum length of Bitonic subsequence. 
 * A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing.
 * Return the maximum length of bitonic subsequence.
 * Note : A strictly increasing or a strictly decreasing sequence should not be considered as a bitonic sequence*/

public class Solution {
	
	public static int longestBitonicSequence(int n, int[] nums) {
		
		int[] LIS = new int[n];
		Arrays.fill(LIS, 1);
		int[] LDS = new int[n];
		Arrays.fill(LDS, 1);
		
		for(int i=1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i]>nums[j]) {
					LIS[i] = Math.max(LIS[i], 1+LIS[j]);
				}
			}
		}
		
		for(int i = n-2; i >= 0; i--) {
			for(int j = i+1; j < n; j++) {
				if(nums[i] > nums[j]) {
					LDS[i] = Math.max(LDS[i], 1+LDS[j]);
				}
			}
		}
		
		int result = 0;
		
		for(int i = 0; i < n; i++) {
			if(LIS[i] != 1 && LDS[i] != 1) {
				result = Math.max(result, LIS[i]+LDS[i]-1);
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		
		int[] nums = {1, 2, 5, 3, 2};
		int n = nums.length;
		
		System.out.println(longestBitonicSequence(n, nums));
	}
}
