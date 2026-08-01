package com.dsa.dp.Strings.PrintLongestCommonSubsequence;

/* You are given two strings ‘s1’ and ‘s2’.
 * Return the longest common subsequence of these strings.
 * If there’s no such string, return an empty string. If there are multiple possible answers, return any such string.
 * Note:
 * Longest common subsequence of string ‘s1’ and ‘s2’ is the longest subsequence of ‘s1’ that is also a subsequence of ‘s2’.
 * A ‘subsequence’ of ‘s1’ is a string that can be formed by deleting one or more (possibly zero) characters from ‘s1’.*/

public class OptimalSolution {
	
	private static String longestCommonSubsequence(int m, int n, String text1, String text2) {

		
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
		
		int i = m, j = n;
		StringBuilder result = new StringBuilder("");
		
		while(i > 0 && j > 0) {
			if(text1.charAt(i-1) == text2.charAt(j-1)) {
				result.append(text1.charAt(i-1));
				i--; j--;
			}
			else {
				if(dp[i-1][j] > dp[i][j-1]) {
					i--;
				}
				else {
					j--;
				}
			}
		}
		
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		String text1 = "ababa";
		String text2 = "cbbcad";
		int m = text1.length();
		int n = text2.length();

		System.out.println(longestCommonSubsequence(m, n, text1, text2));
	}
}
