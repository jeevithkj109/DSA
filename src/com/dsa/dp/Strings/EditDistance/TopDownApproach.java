package com.dsa.dp.Strings.EditDistance;

import java.util.Arrays;

/* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character */

public class TopDownApproach {
	
	public static int minDistance(int m, int n, String word1, String word2, int[][] dp) {
		
		if(m == 0) {
			return n;
		}
		if(n == 0) {
			return m;
		}
		
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		
		if(word1.charAt(m-1) == word2.charAt(n-1)) {
			return dp[m][n] = minDistance(m-1, n-1, word1, word2, dp);
		}
		
		else {
			int deleted = 1+ minDistance(m-1, n, word1, word2,dp);
			int inserted = 1 + minDistance(m, n-1, word1, word2, dp);
			int replaced = 1 + minDistance(m-1, n-1, word1, word2, dp);
			
			return dp[m][n] = Math.min(deleted, Math.min(inserted, replaced));
		}
	}
	
	public static void main(String[] args) {
		String word1 = "intention";
		String word2 = "execution";
		
		int m = word1.length();
		int n = word2.length();
		
		// m: from m to 0 (m+1)
		// n: from n to 0 (n+1)
		int[][] dp = new int[m+1][n+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(minDistance(m, n, word1, word2, dp));
	}
}
