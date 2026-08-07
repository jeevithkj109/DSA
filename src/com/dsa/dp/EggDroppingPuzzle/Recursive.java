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

public class Recursive {
	
	private static int eggDrop(int eggs, int floors) {
        if(eggs == 1) {
        	return floors;
        }
        
        if(floors == 0) {
        	return 0;
        }
        
        int result = Integer.MAX_VALUE;
        for(int j = 1; j <= floors; j++) {
        	int answer = 1 + Math.max(eggDrop(eggs-1, j-1), eggDrop(eggs, floors-j));
        	result  = Math.min(result, answer);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		int n = 2;
		int k= 36;
		
		System.out.println(eggDrop(n, k));
	}
	
}
