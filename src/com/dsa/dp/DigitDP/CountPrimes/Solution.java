package com.dsa.dp.DigitDP.CountPrimes;

/* Given an integer n, return the number of prime numbers that are strictly less than n.*/

public class Solution {
	public static int countPrimes(int n) {

        if(n <= 2) {
            return 0;
        }

        int[] a = new int[n];
        int count = 0;

        for(int i = 2; i < Math.sqrt(n); i++) {
            if(a[i] == 0) {
                for(int j = i*i; j < n; j=j+i) {
                    a[j] = 1;
                }
            }
        }
        for(int i = 2; i < n; i++) {
            if(a[i] == 0) {
                count++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		int n = 20;
		
		System.out.println(countPrimes(n));
	}
}
