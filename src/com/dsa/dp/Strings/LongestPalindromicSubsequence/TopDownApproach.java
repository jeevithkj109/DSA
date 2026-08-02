package com.dsa.dp.Strings.LongestPalindromicSubsequence;

import java.util.Arrays;

/* Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some
 * or no elements without changing the order of the remaining elements.*/

public class TopDownApproach {
	
	private static int longestPallindromicSubsequence(int start, int end, String s, int[][] dp) {
		
		if(start == end) {
			return 1;
		}
		if(start > end) {
			return 0;
		}
		
		if(dp[start][end] != -1) {
			return dp[start][end];
		}
		
		if(s.charAt(start) == s.charAt(end)) {
			return dp[start][end] = 2 + longestPallindromicSubsequence(start+1, end-1, s, dp);
		}
		else {
			return dp[start][end] = Math.max(longestPallindromicSubsequence(start+1, end, s, dp),
					longestPallindromicSubsequence(start, end-1, s, dp));
		}
	}
	
	public static void main(String[] args) {
		String s = "cbbd";
		
		int n = s.length();
		
		//start: worst case: from 0 to n-1 (n)
		//end: worst case: from n-1 to 0 (n)
		int[][] dp = new int[n][n];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(longestPallindromicSubsequence(0, n-1, s, dp));
	}
}
