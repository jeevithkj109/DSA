package com.dsa.dp.DigitDP.CountNumbersFrom1ToNWithDigitSumS;

import java.util.ArrayList;

/* Given an Integer N and a Sum S, find the count of positive integers less than or equal to N
 * that have a digit sum equal to S.*/

public class Recursive {
	
	private static long findTotalDigits(int index, int s, boolean tight, ArrayList<Integer> nums) {
		
		if(s == 0) {
			return 1;
		}
		else if(s < 0 || index == nums.size()) {
			return 0;
		}
		
		long result = 0;
		
		if(tight) {
			for(int i = 0; i < nums.get(index); i++) {
				result +=  findTotalDigits(index+1, s - i, false, nums);
			}
			result +=  findTotalDigits(index+1, s - nums.get(index), true, nums);
		}
		else {
			for(int i = 0; i <= 9; i++) {
				result += findTotalDigits(index+1, s - i, false, nums);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		long n = 20;
		int s = 5;
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		while(n > 0) {
			nums.addFirst((int)n%10);
			n /= 10;
		}
		
		System.out.println(s==0?0:findTotalDigits(0, s, true, nums));
		
	}
}
