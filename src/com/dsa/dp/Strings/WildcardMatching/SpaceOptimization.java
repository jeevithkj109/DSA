package com.dsa.dp.Strings.WildcardMatching;

/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).*/

public class SpaceOptimization {

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
		boolean[] prev = new boolean[n + 1];

		// Initialization
		prev[0] = true;
		for (int j = 1; j <= n; j++) {
			if (p.charAt(j - 1) != '*') {
				break;
			}
			prev[j] = true;
		}

		for (int i = 1; i <= m; i++) {
			boolean[] curr = new boolean[n + 1];
			for (int j = 1; j <= n; j++) {
				
				if (p.charAt(j - 1) == '?') {
					curr[j] = prev[j - 1];
				}
				else if (p.charAt(j - 1) == '*') {
					curr[j] = curr[j - 1] || prev[j];
				}
				else if (s.charAt(i - 1) == p.charAt(j - 1)) {
					curr[j] = prev[j - 1];
				}
			}
			prev = curr;
		}

		return prev[n];
	}

	public static void main(String[] args) {

		String s = "aa";
		String p = "*";

		System.out.println(isMatch(s, p));
	}
}
