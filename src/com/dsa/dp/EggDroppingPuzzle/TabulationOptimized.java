package com.dsa.dp.EggDroppingPuzzle;

/* Given n identical eggs and you have access to a k-floored building from 1 to k.
 * There exists a floor f where 0 <= f <= k such that any egg dropped from a floor higher than f will break,
 * and any egg dropped from or below floor f will not break.

 * There are few rules given below. 
 * An egg that survives a fall can be used again.
 * A broken egg must be discarded.
 * The effect of a fall is the same for all eggs.
 * If the egg doesn't break at a certain floor, it will not break at any floor below.
 * If the egg breaks on a certain floor, it will break on any floor above.
 * Return the minimum number of moves you need to determine the value of f with certainty.*/

public class TabulationOptimized {

	private static int findTotalFloor(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
		// eggs from n to 0 (n+1) -> eggs from 0 to n
		// k from k to 0 (k+1) -> moves from 0 to k
		int[][] dp = new int[n + 1][k + 1];
		
		for(int j = 0; j <= k; j++) {
			dp[1][j] = j;
		}

		for(int moves = 1; moves <= k; moves++) {
			for(int eggs = 2; eggs <= n; eggs++) {
				dp[eggs][moves] = 1 + dp[eggs-1][moves-1] + dp[eggs][moves-1];
			}
			if(dp[n][moves] >= k) {
				return moves;
			}
		}
		
		return k;

	}

	public static void main(String[] args) {
		int n = 2;
		int k = 36;

		System.out.println(findTotalFloor(n, k));
	}

}
