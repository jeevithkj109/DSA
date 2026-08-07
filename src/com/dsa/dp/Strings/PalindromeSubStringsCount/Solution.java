package com.dsa.dp.Strings.PalindromeSubStringsCount;

/* Given a string s, count all palindromic sub-strings present in the string.
 * The length of the palindromic sub-string must be greater than or equal to 2.
 * Note: A substring is palindromic if it reads the same forwards and backwards.*/

public class Solution {
	public static int countPS(String s) {

		int n = s.length();

		int[][] dp = new int[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}

		int totalPalindrome = 0;

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;

				if (s.charAt(i) == s.charAt(j) && (len == 2 || dp[i + 1][j - 1] != 0)) {
					dp[i][j] = 1;
					totalPalindrome++;
				}
			}
		}

		return totalPalindrome;
	}
	
	public static void main(String[] args) {
		String s = "abbaeae";
		
		System.out.println(countPS(s));
	}
}
