package com.dsa.dp.DigitDP.CountNumbersFrom1ToNWithDigitSumS;

import java.util.ArrayList;
import java.util.Arrays;

/* Given an Integer N and a Sum S, find the count of positive integers less than or equal to N
 * that have a digit sum equal to S.*/

public class Memoization {
	
	private static long findTotalDigits(int index, int s, int tight, ArrayList<Integer> nums, long[][][] dp) {
		
		if(s == 0) {
			return 1;
		}
		else if(s < 0 || index == nums.size()) {
			return 0;
		}
		
		if(dp[index][s][tight] != -1) {
			return dp[index][s][tight];
		}
		
		long result = 0;
		
		if(tight == 1) {
			for(int i = 0; i < nums.get(index); i++) {
				result +=  findTotalDigits(index+1, s - i, 0, nums, dp);
			}
			result +=  findTotalDigits(index+1, s - nums.get(index), 1, nums, dp);
		}
		else {
			for(int i = 0; i <= 9; i++) {
				result += findTotalDigits(index+1, s - i, 0, nums, dp);
			}
		}
		return dp[index][s][tight] = result;
	}
	
	public static void main(String[] args) {
		
		long n = 20;
		int s = 5;
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		while(n > 0) {
			nums.addFirst((int)n%10);
			n /= 10;
		}
		
		long[][][] dp = new long[nums.size()+1][s+1][2];
		for(long[][] rows: dp) {
			for(long[] row: rows) {
				Arrays.fill(row, -1);
			}
		}
		
		System.out.println(s==0?0:findTotalDigits(0, s, 1, nums, dp));
		
	}
}
