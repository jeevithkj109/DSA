package com.dsa.dp.HouseRobber;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob 
 * tonight without alerting the police.*/

public class SpaceOptimized {
	private static int maxAmount(int[] nums, int n, int[] dp) {
		//base case
		if(n == 1) {
			return nums[0];
		}
		if(n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		dp[1] = nums[0];
		dp[2] = Math.max(nums[0], nums[1]);
		
		for(int i = 2; i < n; i++) {
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = Math.max(nums[i] + dp[0], dp[1]);
		}
		
		return dp[2];
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		int n = nums.length;
		int[] dp = new int[3];
		System.out.println(maxAmount(nums, n, dp));
	}
}
