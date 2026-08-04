package com.dsa.dp.Strings.NumberOfLongestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {
	public static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		
		int[] LIS = new int[n];
		Arrays.fill(LIS, 1);
		int[] count = LIS.clone();
		int maxLen = 1;
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					if(LIS[i] < 1 + LIS[j]) {
						LIS[i] = 1 + LIS[j];
						count[i] = count[j];
					}
					else if(LIS[i] == 1 + LIS[j]) {
						count[i] += count[j];
					}
				}
			}
			maxLen = Math.max(maxLen, LIS[i]);
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			if(maxLen == LIS[i]) {
				result += count[i];
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
		
		System.out.println(findNumberOfLIS(nums));
	}
}
