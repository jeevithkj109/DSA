package com.dsa.dp.Strings.DistinctSubsequences;

/* Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * The test cases are generated so that the answer fits on a 32-bit signed integer.*/

public class SpaceOptimized {
	public static int numDistinct(String s, String t) {
		int m = s.length();
		int n = t.length();

		if (n == 0) {
			return 1;
		}
		if (m == 0) {
			return 0;
		}
		
		// m: from m to 0 (m+1)
		// n: from n to 0 (n+1)
		int[] prev = new int[n+1];
		prev[0] = 1;
		
		for(int i = 1; i <= m; i++) {
			int[] curr = new int[n+1];
			curr[0] = 1;
			for(int j = 1; j <= n; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					curr[j] = prev[j-1] + prev[j];
				}
				else {
					curr[j] = prev[j];
				}
			}
			prev = curr;
		}
		return prev[n];
	}

	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";

		System.out.println(numDistinct(s, t));
	}
}
