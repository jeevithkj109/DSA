package com.dsa.dp.Strings.EditDistance;

/* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character */

public class BottomUpApproach {

	public static int minDistance(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();

		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}

		// m: from m to 0 (m+1) -> i from 0 to m
		// n: from n to 0 (n+1) -> j from 0 to n
		int[][] dp = new int[m + 1][n + 1];
		
		// fill column zero
		for(int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
		
		// fill row zero
		for(int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
				}
			}
		}
		
		return dp[m][n];
	}

	public static void main(String[] args) {
		String word1 = "intention";
		String word2 = "execution";

		System.out.println(minDistance(word1, word2));
	}
}
