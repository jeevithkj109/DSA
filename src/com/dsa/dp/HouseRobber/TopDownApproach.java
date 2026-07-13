package com.dsa.dp.HouseRobber;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob 
 * tonight without alerting the police.*/

public class TopDownApproach {
	private static int maxAmount(int[] nums, int n, int[] dp) {
		//base case
		if(n == 0) {
			return nums[0];
		}
		if(n == 1) {
			return Math.max(nums[0], nums[1]);
		}
		if(dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = Math.max(nums[n] + maxAmount(nums, n-2, dp), maxAmount(nums, n-1, dp));
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		int n = nums.length;
		int[] dp = new int[n];
		System.out.println(maxAmount(nums, n-1, dp));
	}
}
