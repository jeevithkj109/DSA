package com.dsa.dp.Strings.LongestCommonSubstring;

/* Given two strings s1 and s2, determine the length of the longest substring that appears in both strings.*/

public class Recursive {
	
	public static int result = 0;
	
	private static int longCommSubstr(int m, int n, String s1, String s2) {
        
		if(m == 0 || n == 0) {
			return 0;
		}
		
		int answer = 0;
		//if text matches
		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			answer = 1 + longCommSubstr(m-1, n-1, s1, s2);
			result = Math.max(result, answer);
			return answer;
		}
		
		longCommSubstr(m-1, n, s1, s2);
		longCommSubstr(m, n-1, s1, s2);
		return 0;
    }
	
	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		
		int m = s1.length();
		int n = s2.length();
		
		longCommSubstr(m, n, s1, s2);
		
		System.out.println(result);
	}
}
