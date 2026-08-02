package com.dsa.dp.Strings.EditDistance;

/* Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character */

public class Recursive {
	
	public static int minDistance(int m, int n, String word1, String word2) {
		
		if(m == 0) {
			return n;
		}
		if(n == 0) {
			return m;
		}
		
		if(word1.charAt(m-1) == word2.charAt(n-1)) {
			return minDistance(m-1, n-1, word1, word2);
		}
		
		else {
			int deleted = 1+ minDistance(m-1, n, word1, word2);
			int inserted = 1 + minDistance(m, n-1, word1, word2);
			int replaced = 1 + minDistance(m-1, n-1, word1, word2);
			
			return Math.min(deleted, Math.min(inserted, replaced));
		}
	}
	
	public static void main(String[] args) {
		String word1 = "intention";
		String word2 = "execution";
		
		int m = word1.length();
		int n = word2.length();
		
		System.out.println(minDistance(m, n, word1, word2));
	}
}
