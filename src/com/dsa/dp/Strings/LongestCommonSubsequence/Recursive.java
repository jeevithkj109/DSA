package com.dsa.dp.Strings.LongestCommonSubsequence;

/* Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.*/

public class Recursive {
	
	private static int longestCommonSubsequence(int m, int n, String text1, String text2) {
		
		if(m == 0 || n == 0) {
			return 0;
		}
		
		if(text1.charAt(m-1) == text2.charAt(n-1)) {
			return 1 + longestCommonSubsequence(m-1, n-1, text1, text2);
		}
		else {
			return Math.max(longestCommonSubsequence(m, n-1, text1, text2), longestCommonSubsequence(m-1, n, text1, text2));
		}
	}
	
	public static void main(String[] args) {
		String text1 = "abc";
		String text2 = "def";
		
		int m = text1.length();
		int n = text2.length();
		
		System.out.println(longestCommonSubsequence(m, n, text1, text2));
	}
}
