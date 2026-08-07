package com.dsa.dp.EggDroppingPuzzle;

/* Given n identical eggs and you have access to a k-floored building from 1 to k.
 * There exists a floor f where 0 <= f <= k such that any egg dropped from a floor higher than f will break,
 * and any egg dropped from or below floor f will not break.

 * There are few rules given below. 
 * An egg that survives a fall can be used again.
 * A broken egg must be discarded.
 * The effect of a fall is the same for all eggs.
 * If the egg doesn't break at a certain floor, it will not break at any floor below.
 * If the egg breaks on a certain floor, it will break on any floor above.
 * Return the minimum number of moves you need to determine the value of f with certainty.*/

public class RecursiveOptimized {
	
	private static int findTotalFloor(int eggs, int moves) {
		if(eggs == 0 || moves == 0) {
			return 0;
		}
		if(eggs == 1) {
			return moves;
		}
		
		return 1 + findTotalFloor(eggs-1, moves-1) + findTotalFloor(eggs, moves-1);
        
    }
	
	public static void main(String[] args) {
		int n = 2;
		int k= 36;
		
		int moves  = 0;
		
		while(findTotalFloor(n, moves) < k) {
			moves++;
		}
		
		System.out.println(moves);
	}
	
}
