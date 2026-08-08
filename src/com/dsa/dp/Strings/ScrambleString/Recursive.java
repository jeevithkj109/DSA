package com.dsa.dp.Strings.ScrambleString;

/* We can scramble a string s to get a string t using the following algorithm:
 1. If the length of the string is 1, stop.
 2. If the length of the string is > 1, do the following:
   * Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
   * Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
   * Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.*/

public class Recursive {
	
	private static boolean isScramble(String s1, String s2) {
		
		if(s1.equals(s2)) {
			return true;
		}
		
		int n = s1.length();
		
		int[] freq = new int[26];
		
		for(int i = 0; i < n; i++) {
			freq[s1.charAt(i) - 'a']++;
			freq[s2.charAt(i) - 'a']--;
		}
		
		for(int count: freq) {
			if(count!=0) {
				return false;
			}
		}
		
		//split string at each length
		
		for(int i = 1; i < n; i++) {
			
			boolean noSwap = isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i));
			if(noSwap) {
				return true;
			}
			
			boolean swap = isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i));
			if(swap) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "great";
		String s2 = "rgeat";
		
		System.out.println(isScramble(s1, s2));
	}
}
