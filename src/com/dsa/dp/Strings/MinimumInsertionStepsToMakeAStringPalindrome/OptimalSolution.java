package com.dsa.dp.Strings.MinimumInsertionStepsToMakeAStringPalindrome;

/* Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 * A Palindrome String is one that reads the same backward as well as forward.*/

public class OptimalSolution {
	
	private static int longestPallindromicSubsequence(String s) {

		int n = s.length();

		// start: worst case: from 0 to n-1 (n) -> i: n-1 to 0
		// end: worst case: from n-1 to 0 (n) -> 0 to n-1
		// if s.char(i) == s.char(j) -> dp[i][j] = 2+dp[i+1][j-1];
		// else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		
		// Subtract the longest pallindromic sequence from the length of the String.
		return n-dp[0][n - 1];
	}

	public static void main(String[] args) {
		String s = "cbbd";

		System.out.println(longestPallindromicSubsequence(s));
	}
}
