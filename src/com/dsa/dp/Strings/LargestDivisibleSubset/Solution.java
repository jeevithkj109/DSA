package com.dsa.dp.Strings.LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		
		int n = nums.length;
		Arrays.sort(nums);
		
		int[] LDS = new int[n];
		Arrays.fill(LDS, 1);
		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		int maxLen = 0, index = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[i]%nums[j] == 0) {
					if(LDS[i] < 1+LDS[j]) {
						LDS[i] = 1+LDS[j];
						parent[i] = j;
					}
				}
			}
			if(maxLen < LDS[i]) {
				maxLen = LDS[i];
				index = i;
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		
		while(index != -1) {
			result.addFirst(nums[index]);
			index = parent[index];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		
		System.out.println(largestDivisibleSubset(nums));
	}
}
