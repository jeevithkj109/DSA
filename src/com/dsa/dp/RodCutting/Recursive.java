package com.dsa.dp.RodCutting;

/* Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i (1-based Index).
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * Note: The value of n is equal to the size of price array.*/

public class Recursive {
	public static int findMaxVal(int n, int[] price) {
		
		if(n == 0) {
			return 0;
		}
		
		int result = 0;
		for(int j = 1; j <= n; j++) {
			result = Math.max(result, price[j-1] + findMaxVal(n-j, price));
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] price = {3, 5, 8, 9, 10, 17, 17, 20};
		int n = price.length;
		
		System.out.println(findMaxVal(n, price));
	}
}
