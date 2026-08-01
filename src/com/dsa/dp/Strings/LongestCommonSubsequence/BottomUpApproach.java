package com.dsa.dp.Strings.LongestCommonSubsequence;

/* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.*/

public class BottomUpApproach {

	private static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		if (m == 0 || n == 0) {
			return 0;
		}

		// m: from m to 0 (m+1) -> i: 0 to m
		// n: from n to 0 (n+1) -> j: 0 to n
		// if(char(m) == char(n)) -> dp[i][j] = 1+dp[i-1][j-1];
		// else -> dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
		int[][] dp = new int[m + 1][n + 1];
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String text1 = "bl";
		String text2 = "yby";

		System.out.println(longestCommonSubsequence(text1, text2));
	}
}
