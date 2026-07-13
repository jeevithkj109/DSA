package com.dsa.dp.HouseRobber2;

/* You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.*/

public class SpaceOptimized {
	private static int rob(int[] nums) {
		int n = nums.length;

		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] dp = new int[3];
		dp[1] = nums[0];
		dp[2] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n - 1; i++) {
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = Math.max(nums[i] + dp[0], dp[1]);
		}
		int result = dp[2];

		dp[1] = nums[1];
		dp[2] = Math.max(nums[1], nums[2]);
		for (int i = 3; i < n; i++) {
			dp[0] = dp[1];
			dp[1] = dp[2];
			dp[2] = Math.max(nums[i] + dp[0], dp[1]);
		}

		return Math.max(result, dp[2]);
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3,1};
		System.out.println(rob(nums));
	}

}
