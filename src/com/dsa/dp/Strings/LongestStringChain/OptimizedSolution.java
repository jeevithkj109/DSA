package com.dsa.dp.Strings.LongestStringChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* You are given an array of words where each word consists of lowercase English letters.
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA
 * without changing the order of the other characters to make it equal to wordB.
 * For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2,
 * word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 * Return the length of the longest possible word chain with words chosen from the given list of words.*/

public class OptimizedSolution {

	public static int longestStrChain(String[] words) {
		
		Arrays.sort(words, (word1, word2) -> {
			return word1.length() - word2.length();
		});
		
		Map<String, Integer> dp = new HashMap<String, Integer>();
		int maxLen = 1;
		
		for(String w: words) {
			dp.put(w, 1);
			
			for(int i = 0; i < w.length(); i++) {
				String str = w.substring(0, i) + w.substring(i+1);
				
				if(dp.containsKey(str)) {
					dp.put(w, Math.max(dp.get(w), 1+dp.get(str)));
				}
			}
			maxLen = Math.max(maxLen, dp.get(w));
		}
		
		return maxLen;
	}

	public static void main(String[] args) {
		String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
		
		System.out.println(longestStrChain(words));

	}
}
