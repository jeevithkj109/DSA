package com.dsa.dp.Strings.LongestPalindromicSubsequence;

public class AlternateApproach {
	
	private static int longestPalindromicSubsequence(String s) {
		
		int n = s.length();
		
		String text1 = s;
		String text2 = new StringBuilder(s).reverse().toString();

		// m: from m to 0 (m+1) -> i: 0 to m
		// n: from n to 0 (n+1) -> j: 0 to n
		// if(char(m) == char(n)) -> dp[i][j] = 1+dp[i-1][j-1];
		// else -> dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = 1+dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[n][n];
	}

	public static void main(String[] args) {
		String s = "aabbyaab";

		System.out.println(longestPalindromicSubsequence(s));
	}
}
