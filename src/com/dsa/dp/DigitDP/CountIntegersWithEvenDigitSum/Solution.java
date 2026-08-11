package com.dsa.dp.DigitDP.CountIntegersWithEvenDigitSum;

/* Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.
 * The digit sum of a positive integer is the sum of all its digits.*/

public class Solution {
	
	public static int countEven(int num) {
        int n = num;
        int digitSum = 0;

        while(n > 0) {
            int r = n%10;
            digitSum += r;
            n = n/10;
        }

        if(digitSum % 2 == 0) {
            return num/2;
        }
        return (num-1) / 2;
    }
	
	public static void main(String[] args) {
		
		int num = 10;
		
		System.out.println(countEven(num));
	}
}
