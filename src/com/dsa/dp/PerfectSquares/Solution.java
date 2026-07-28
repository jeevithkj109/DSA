package com.dsa.dp.PerfectSquares;

import java.util.Arrays;

/* Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.*/

public class Solution {
	
	public static int numSquares(int n) {
		
		if(n <= 3) {
			return n;
		}
		
		int[] minimumPerfectSquares = new int[n+1];
		Arrays.fill(minimumPerfectSquares, Integer.MAX_VALUE);
		
		minimumPerfectSquares[0] = 0;
		minimumPerfectSquares[1] = 1;
		minimumPerfectSquares[2] = 2;
		minimumPerfectSquares[3] = 3;
		
		for(int i = 4; i <= n; i++) {
			for(int j = 1; j*j <= i; j++) {
				minimumPerfectSquares[i] = Math.min(minimumPerfectSquares[i], 1+minimumPerfectSquares[i-j*j]);
			}
		}
		
		return minimumPerfectSquares[n];
	}
}
