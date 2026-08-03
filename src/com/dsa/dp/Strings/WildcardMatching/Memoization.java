package com.dsa.dp.Strings.WildcardMatching;

import java.util.Arrays;

/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).*/

public class Memoization {

	public static int isMatch(int m, int n, String s, String p, int[][] dp) {
		
		if(m == 0 && n == 0) {
			return 1;
		}
		if(n == 0) { // n == 0 && m != 0
			return 0;
		}
		if(m == 0) {
			for(int k = 0; k < n; k++) {
				if(p.charAt(k) != '*') {
					return 0;
				}
			}
			return 1;
		}
		
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		
		if(p.charAt(n-1) == '?') {
			return dp[m][n] = isMatch(m-1, n-1, s, p, dp);
		}
		else if(p.charAt(n-1) == '*') {
			return dp[m][n] = isMatch(m, n-1, s, p, dp) | isMatch(m-1, n, s, p, dp);
		}
		else if(s.charAt(m-1) == p.charAt(n-1)) {
			return dp[m][n] = isMatch(m-1, n-1, s, p, dp);
		}
		else {
			return dp[m][n] = 0;
		}
	}
	
	public static void main(String[] args) {
		
		String s = "aa";
		String p = "*";
		
		int m = s.length();
		int n = p.length();
		
		// m: from m to 0 (m+1)
		// n: from n to 0 (n+1)
		int[][] dp = new int[m+1][n+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(isMatch(m, n, s, p, dp));
	}
}
