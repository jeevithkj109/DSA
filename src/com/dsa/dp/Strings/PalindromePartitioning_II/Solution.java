package com.dsa.dp.Strings.PalindromePartitioning_II;

import java.util.Arrays;

/* Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.*/

public class Solution {
	public static int minCut(String s) {

		int n = s.length();
		
		if(n == 1) {
			return 0;
		}

		int[][] palindrome = new int[n][n];

		for (int i = 0; i < n; i++) {
			palindrome[i][i] = 1;
		}

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;

				if (s.charAt(i) == s.charAt(j) && (len == 2 || palindrome[i + 1][j - 1] != 0)) {
					palindrome[i][j] = 1;
				}
			}
		}

		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[n-1] = 0;
		
		for(int i = n-2; i >= 0; i--) {
			for(int j = i; j < n; j++) {
				if(palindrome[i][j]==1) {
					if(j == n-1) {
						dp[i] = 0;
					}
					else {
						dp[i] = Math.min(dp[i], 1+dp[j+1]);
					}
				}
			}
		}
		
		return dp[0];
	}
	
	public static void main(String[] args) {
		String s = "aab";
		
		System.out.println(minCut(s));
	}
}
