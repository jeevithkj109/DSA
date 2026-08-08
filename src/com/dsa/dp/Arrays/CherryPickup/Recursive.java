package com.dsa.dp.Arrays.CherryPickup;

/* You are given an n x n grid representing a field of cherries, each cell is one of three possible integers.
 * 0 means the cell is empty, so you can pass through,
 * 1 means the cell contains a cherry that you can pick up and pass through, or
 * -1 means the cell contains a thorn that blocks your way.
 * Return the maximum number of cherries you can collect by following the rules below:
 * Starting at the position (0, 0) and reaching (n - 1, n - 1) by moving right or down through valid path cells (cells with value 0 or 1).
 * After reaching (n - 1, n - 1), returning to (0, 0) by moving left or up through valid path cells.
 * When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell 0.
 * If there is no valid path between (0, 0) and (n - 1, n - 1), then no cherries can be collected.*/

public class Recursive {
	
	private static int findMaximumCherryPickup(int r1, int c1, int r2, int n, int[][] grid) {
		
		int c2 = (r1+c1) - r2;
		
		//Base Case
		if(r1>=n || r2>=n || c1>=n || c2>=n) {
			return Integer.MIN_VALUE;
		}
		if(grid[r1][c1] == -1 || grid[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		}
		
		// Reached the Target
		if(r1 == n-1 && c1 == n-1) {
			return grid[n-1][n-1];
		}
		
		
		int cherries  = grid[r1][c1];
		
		if(r1!=r2 || c1!=c2) {
			cherries += grid[r2][c2];
		}
		
		// DD, DR, RD, RR
		int DD = findMaximumCherryPickup(r1+1, c1, r2+1, n, grid);
		int DR = findMaximumCherryPickup(r1+1, c1, r2, n, grid);
		int RD = findMaximumCherryPickup(r1, c1+1, r2+1, n, grid);
		int RR = findMaximumCherryPickup(r1, c1+1, r2, n, grid);
		
		int pick  = Math.max(DD, Math.max(DR, Math.max(RD, RR)));
		
		if(pick == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		return cherries + pick;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,-1},{1,0,-1},{1,1,1}};
		int n = grid.length;
		
		System.out.println(Math.max(0, findMaximumCherryPickup(0, 0, 0, n, grid)));
	}
}
