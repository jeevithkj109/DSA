package com.dsa.dp.Strings.DistinctSubsequences;

import java.util.Arrays;

/* Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * The test cases are generated so that the answer fits on a 32-bit signed integer.*/

public class TopDownApproach {
	public static int numDistinct(int m, int n, String s, String t, int[][] dp) {
		
		if(n == 0) {
			return 1;
		}
		if(m == 0) {
			return 0;
		}
		
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		
		if(s.charAt(m-1) == t.charAt(n-1)) {
			return dp[m][n] = numDistinct(m-1, n-1, s, t, dp) + numDistinct(m-1, n, s, t, dp);
		}
		else {
			return dp[m][n] = numDistinct(m-1, n, s, t, dp);
		}
		
	}
	
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		
		int m = s.length();
		int n = t.length();
		
		//m: from m to 0 (m+1)
		//n: from n to 0 (n+1)
		int[][] dp = new int[m+1][n+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(numDistinct(m, n, s, t, dp));
	}
}
