package com.dsa.dp.CombinationSumIV;

import java.util.Arrays;

/* Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * The test cases are generated so that the answer can fit in a 32-bit integer.*/

public class BottomUpApproach {

	
	public static int findTotalCombinations(int n, int target, int[] nums) {
		
		if(target == 0) {
			return 1;
		}
		if(target < 0) {
			return 0;
		}
		
		int[] dp = new int[target+1];
		dp[0] = 1;
		
		for(int i = 1; i <= target; i++) {
			int result = 0;
			for(int j = 0; j < n; j++) {
				if(i-nums[j] >= 0) {
					result += dp[i-nums[j]];
				}
			}
			dp[i] = result;
		}
		
		return dp[target];
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int target = 4;
		int n = nums.length;
		
		System.out.println(findTotalCombinations(n, target, nums));
	}
}
