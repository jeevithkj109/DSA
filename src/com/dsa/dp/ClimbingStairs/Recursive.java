package com.dsa.dp.ClimbingStairs;

/*You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/

public class Recursive {
	
	private static int waysToClimb(int n) {
		if(n <= 2) {
			return n;
		}
		return waysToClimb(n-1) + waysToClimb(n-2);
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(waysToClimb(n));
	}
}
