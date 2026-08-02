package com.dsa.dp.Strings.LongestCommonSubstring;

/* Given two strings s1 and s2, determine the length of the longest substring that appears in both strings.*/

public class BottomUpApproach {

	private static int longCommSubstr(String s1, String s2) {

		int m = s1.length();
		int n = s2.length();

		if (m == 0 || n == 0) {
			return 0;
		}
		
		int result = 0;

		// m: from m to 0 (m+1) -> i from 0 to m
		// n: from n to 0 (n+1) -> j from 0 to n
		int[][] dp = new int[m + 1][n + 1];
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";

		System.out.println(longCommSubstr(s1, s2));
	}
}
