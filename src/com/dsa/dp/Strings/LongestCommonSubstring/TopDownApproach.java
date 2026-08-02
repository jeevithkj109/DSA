package com.dsa.dp.Strings.LongestCommonSubstring;

import java.util.Arrays;

/* Given two strings s1 and s2, determine the length of the longest substring that appears in both strings.*/

public class TopDownApproach {
	
	public static int result = 0;
	
	private static int longCommSubstr(int m, int n, String s1, String s2, int[][] dp) {
        
		if(m == 0 || n == 0) {
			return 0;
		}
		
		if(dp[m][n] != -1) {
			return dp[m][n];
		}
		
		int answer = 0;
		//if text matches
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			answer = 1 + longCommSubstr(m-1, n-1, s1, s2, dp);
			result = Math.max(result, answer);
			return dp[m][n] = answer;
		}
		
		longCommSubstr(m-1, n, s1, s2, dp);
		longCommSubstr(m, n-1, s1, s2, dp);
		return dp[m][n] = 0;
    }
	
	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		
		int m = s1.length();
		int n = s2.length();
		
		// m: from m to 0 (m+1)
		// n: from n to 0 (n+1)
		int[][] dp = new int[m+1][n+1];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		longCommSubstr(m, n, s1, s2, dp);
		
		System.out.println(result);
	}
}
