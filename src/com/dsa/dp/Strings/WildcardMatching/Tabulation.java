package com.dsa.dp.Strings.WildcardMatching;

/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).*/

public class Tabulation {

	public static boolean isMatch(String s, String p) {

		int m = s.length();
		int n = p.length();

		if (m == 0 && n == 0) {
			return true;
		}
		if (n == 0) { // n == 0 && m != 0
			return false;
		}
		if (m == 0) {
			for (int k = 0; k < n; k++) {
				if (p.charAt(k) != '*') {
					return false;
				}
			}
			return true;
		}

		// m: from m to 0 (m+1) -> i: from 0 to m
		// n: from n to 0 (n+1) -> j: from 0 to n
		boolean[][] dp = new boolean[m + 1][n + 1];

		// Initialization
		dp[0][0] = true;
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) != '*') {
				break;
			}
			dp[0][j] = true;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				} else if (s.charAt(i - 1) == p.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {

		String s = "aa";
		String p = "*";

		System.out.println(isMatch(s, p));
	}
}
