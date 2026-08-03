package com.dsa.dp.Strings.WildcardMatching;

/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).*/

public class Recursive {

	public static int isMatch(int m, int n, String s, String p) {
		
		if(m == 0 && n == 0) {
			return 1;
		}
		if(n == 0) { // n == 0 && m != 0
			return 0;
		}
		if(m == 0) {
			for(int k = 0; k < n; k++) {
				if(p.charAt(k) != '*') {
					return 0;
				}
			}
			return 1;
		}
		
		if(p.charAt(n-1) == '?') {
			return isMatch(m-1, n-1, s, p);
		}
		else if(p.charAt(n-1) == '*') {
			return isMatch(m, n-1, s, p) | isMatch(m-1, n, s, p);
		}
		else if(s.charAt(m-1) == p.charAt(n-1)) {
			return isMatch(m-1, n-1, s, p);
		}
		else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
		String s = "aa";
		String p = "*";
		
		int m = s.length();
		int n = p.length();
		
		System.out.println(isMatch(m, n, s, p));
	}
}
