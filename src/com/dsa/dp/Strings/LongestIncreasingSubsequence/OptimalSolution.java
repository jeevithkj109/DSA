package com.dsa.dp.Strings.LongestIncreasingSubsequence;

import java.util.Arrays;

public class OptimalSolution {
	
	public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int result = 1;

        for(int i = 1; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]);
                }
            }
            result = Math.max(result, LIS[i]);
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		
		System.out.println(lengthOfLIS(nums));
	}
}
