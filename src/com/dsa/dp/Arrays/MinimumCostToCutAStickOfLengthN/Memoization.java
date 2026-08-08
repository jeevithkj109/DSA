package com.dsa.dp.Arrays.MinimumCostToCutAStickOfLengthN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* You are given a wooden stick of length n, labeled from 0 to n. You are also given an integer array cuts[],
 * where each element cuts[i] represents a position along the stick at which you can make a cut.
 * Each cut costs an amount equal to the length of the stick being cut at that moment.
 * After performing a cut, the stick is divided into two smaller sticks.
 * You can perform the cuts in any order. Your task is to determine the minimum total cost required to perform all the cuts.*/

public class Memoization {
	
	private static int findMinCost(int start, int end, List<Integer> cuts, int[][] dp) {
		
		if(start+1 == end) {
			return 0;
		}
		
		if(dp[start][end] != -1) { 
			return dp[start][end];
		}
		
		int result = Integer.MAX_VALUE;
		for(int k = start+1; k < end; k++ ) {
			//leftside, rightside
			
			int answer = cuts.get(end)-cuts.get(start) + findMinCost(start, k, cuts, dp) + findMinCost(k, end, cuts, dp); 
			
			result = Math.min(result, answer);
		}
		
		return dp[start][end] = result;
		
	}
	
	public static void main(String[] args) {
		
		int n = 10;
		Integer[] cuts = {2, 4, 7};
		
		List<Integer> cutsList= new ArrayList<Integer>(Arrays.asList(cuts));
		cutsList.add(0);
		cutsList.add(n);
		Collections.sort(cutsList);
		int size = cutsList.size();
		
		int[][] dp = new int[size][size];
		for(int[] row: dp) {
			Arrays.fill(row, -1);
		}
		
		System.out.println(findMinCost(0, size-1, cutsList, dp));
	}
}
