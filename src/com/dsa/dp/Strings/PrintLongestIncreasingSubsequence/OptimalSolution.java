package com.dsa.dp.Strings.PrintLongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.Arrays;

/* You are given an array of integers arr[], return the Longest Increasing Subsequence (LIS) of the given array.
 * LIS is the longest subsequence where each element is strictly greater than the previous one.
 * Note: If multiple LIS of the same maximum length exist, return the one that appears first based on the lexicographical order of their indices
 * (i.e., the earliest combination of positions from the original sequence).*/

public class OptimalSolution {

	
	public static ArrayList<Integer> lengthOfLIS(int[] arr) {
        int n = arr.length;
        
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int result = 1;
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int index = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && LIS[i] < 1+LIS[j]) {
                    LIS[i] = 1+LIS[j];
                    parent[i] = j;
                }
            }
            if(result < LIS[i]) {
            	result = LIS[i];
            	index = i;
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        while(index != -1) {
        	answer.addFirst(arr[index]);
        	index = parent[index];
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {10,9,2,5,3,7,101,18};
		
		System.out.println(lengthOfLIS(arr));
	}
}
