package com.dsa.dp.Strings.LongestCommonSubsequence;

/* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.*/

public class SpaceOptimized {

	private static int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		if (m == 0 || n == 0) {
			return 0;
		}

		int[] prev = new int[n+1];
		
		for(int i = 1; i <= m; i++) {
			int[] curr = new int[n+1];
			for(int j = 1; j <= n; j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					curr[j] = 1+prev[j-1];
				}
				else {
					curr[j] = Math.max(curr[j-1], prev[j]);
				}
			}
			prev = curr;
		}
		return prev[n];
	}

	public static void main(String[] args) {
		String text1 = "bl";
		String text2 = "yby";

		System.out.println(longestCommonSubsequence(text1, text2));
	}
}
