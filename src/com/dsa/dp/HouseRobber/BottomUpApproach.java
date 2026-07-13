package com.dsa.dp.HouseRobber;

/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob 
 * tonight without alerting the police.*/

public class BottomUpApproach {
	private static int maxAmount(int[] nums, int n, int[] dp) {
		//base case
		if(n == 1) {
			return nums[0];
		}
		if(n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		for(int i = 2; i < n; i++) {
			dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
		}
		
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		int n = nums.length;
		int[] dp = new int[n];
		System.out.println(maxAmount(nums, n, dp));
	}
}
