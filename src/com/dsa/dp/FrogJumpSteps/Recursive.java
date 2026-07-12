package com.dsa.dp.FrogJumpSteps;

/* A Frog jumps either 1, 2 or 3 steps to reach the top of a staircase with n steps.
 * Calculate the number of distinct ways the frog can reach the nth step.*/

public class Recursive {
	private static int waysToJump(int n) {
		if(n <= 2) {
			return n;
		}
		if(n == 3) {
			return 4;
		}
		return waysToJump(n-1) + waysToJump(n-2) + waysToJump(n-3);
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(waysToJump(n));
	}
}
