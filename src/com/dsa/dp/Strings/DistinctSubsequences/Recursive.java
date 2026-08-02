package com.dsa.dp.Strings.DistinctSubsequences;

/* Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * The test cases are generated so that the answer fits on a 32-bit signed integer.*/

public class Recursive {
	public static int numDistinct(int m, int n, String s, String t) {
		
		if(n == 0) {
			return 1;
		}
		if(m == 0) {
			return 0;
		}
		
		if(s.charAt(m-1) == t.charAt(n-1)) {
			return numDistinct(m-1, n-1, s, t) + numDistinct(m-1, n, s, t);
		}
		else {
			return numDistinct(m-1, n, s, t);
		}
		
	}
	
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		
		int m = s.length();
		int n = t.length();
		
		System.out.println(numDistinct(m, n, s, t));
	}
}
