package com.dsa.dp.Strings.LongestStringChain;

import java.util.Arrays;

/* You are given an array of words where each word consists of lowercase English letters.
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA
 * without changing the order of the other characters to make it equal to wordB.
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
 * word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * Return the length of the longest possible word chain with words chosen from the given list of words.*/

public class Solution {
	
	public static boolean isPredecessor(String word1, String word2) {
		if(word1.length()+1 != word2.length()) {
			return false;
		}
		
		int i = word1.length(), j = word2.length();
		
		while(i!=0 && j!=0) {
			if(word1.charAt(i-1) == word2.charAt(j-1)) {
				i--; j--;
			}
			else {
				j--;
			}
		}
		
		return i==0?true:false;
	}

	public static int longestStrChain(String[] words) {
		
		Arrays.sort(words, (word1, word2) -> {
			return word1.length() - word2.length();
		});
		int n = words.length;
		int[] LSC = new int[n];
		Arrays.fill(LSC, 1);
		int maxLen = 1;
		
		for(int i = 0; i < n; i++) { 
			for(int j = i-1; j >= 0; j--) {
				if(isPredecessor(words[j], words[i])) {
					LSC[i] = Math.max(LSC[i], 1+LSC[j]);
				}
			}
			maxLen = Math.max(maxLen, LSC[i]);
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
		
		System.out.println(longestStrChain(words));

	}
}
