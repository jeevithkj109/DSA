package com.dsa.dp.Strings.DistinctSubsequences;

/* Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * The test cases are generated so that the answer fits on a 32-bit signed integer.*/

public class BottomUpApproach {
	public static int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();

		if (n == 0) {
			return 1;
		}
		if (m == 0) {
			return 0;
		}
		
		// m: from m to 0 (m+1)
		// n: from n to 0 (n+1)
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";

		System.out.println(numDistinct(s, t));
	}
}
