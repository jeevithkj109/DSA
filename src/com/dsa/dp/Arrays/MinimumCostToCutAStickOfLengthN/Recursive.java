package com.dsa.dp.Arrays.MinimumCostToCutAStickOfLengthN;

import java.util.Arrays;

/* You are given a wooden stick of length n, labeled from 0 to n. You are also given an integer array cuts[],
 * where each element cuts[i] represents a position along the stick at which you can make a cut.
 * Each cut costs an amount equal to the length of the stick being cut at that moment.
 * After performing a cut, the stick is divided into two smaller sticks.
 * You can perform the cuts in any order. Your task is to determine the minimum total cost required to perform all the cuts.*/

public class Recursive {
	
	private static int findMinCost(int start, int end, int rodStart, int rodEnd, int[] cuts) {
		
		if(start > end) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		for(int k = start; k <= end; k++ ) {
			//leftside, rightside
			
			int answer = rodEnd-rodStart + findMinCost(start, k-1, rodStart, cuts[k], cuts) + findMinCost(k+1, end, cuts[k], rodEnd, cuts);
			
			result = Math.min(result, answer);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		int[] cuts = {2, 4, 7};
		Arrays.sort(cuts);
		
		System.out.println(findMinCost(0, cuts.length-1, 0, n, cuts));
	}
}
