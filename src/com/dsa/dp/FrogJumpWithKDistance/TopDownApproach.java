package com.dsa.dp.FrogJumpWithKDistance;

/* There is a frog on the 1st step of an N stairs long staircase. The frog wants to reach the Nth stair. heights[i] is the height of the (i+1)th stair.
 * If the frog jumps from the ith to the jth stair, the energy lost in the jump is given by the absolute value of |heights[i-1] - heights[j-1]|.
 * If the Frog is on the ith staircase,it can jump to any stair (i+1), (i+2),..., (i+k).
 * Your task is to find the minimum total energy used by the frog to reach from the 1st stair to the Nth stair*/

public class TopDownApproach {

	private static int minEnergy(int index, int[] heights, int k, int[] dp) {
		if(index == 0) {
			return 0;
		}
		if(dp[index] != 0) {
			return dp[index];
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= k && i <= index; i++) {
			result = Math.min(result, Math.abs(heights[index]-heights[index-i]) + minEnergy(index-i, heights, k, dp));
		}
		
		
		return dp[index] = result;
	}

	public static void main(String[] args) {
		int[] heights = {10, 20, 30,10};
		int k = 2;
		int n = heights.length;
		int[] dp = new int[n];
		System.out.println(minEnergy(n-1, heights, k, dp));
	}
}
