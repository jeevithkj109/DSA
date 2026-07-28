package com.dsa.dp.CombinationSumIV;

import java.util.Arrays;

/* Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * The test cases are generated so that the answer can fit in a 32-bit integer.*/

public class TopDownApproach {

	
	public static int findTotalCombinations(int n, int target, int[] nums, int[] dp) {
		
		if(target == 0) {
			return 1;
		}
		if(target < 0) {
			return 0;
		}
		
		if(dp[target] != -1) {
			return dp[target];
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			result += findTotalCombinations(n, target-nums[i], nums, dp);
		}
		
		return dp[target] = result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int target = 4;
		
		int n = nums.length;
		int[] dp = new int[target+1];
		Arrays.fill(dp, -1);
		
		System.out.println(findTotalCombinations(n, target, nums, dp));
	}
}
