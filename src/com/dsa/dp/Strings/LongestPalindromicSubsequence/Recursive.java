package com.dsa.dp.Strings.LongestPalindromicSubsequence;

/* Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some
 * or no elements without changing the order of the remaining elements.*/

public class Recursive {
	
	private static int longestPallindromicSubsequence(int start, int end, String s) {
		
		if(start == end) {
			return 1;
		}
		if(start > end) {
			return 0;
		}
		
		if(s.charAt(start) == s.charAt(end)) {
			return  2 + longestPallindromicSubsequence(start+1, end-1, s);
		}
		else {
			return Math.max(longestPallindromicSubsequence(start+1, end, s), longestPallindromicSubsequence(start, end-1, s));
		}
	}
	
	public static void main(String[] args) {
		String s = "cbbd";
		
		int n = s.length();
		
		System.out.println(longestPallindromicSubsequence(0, n-1, s));
	}
}
