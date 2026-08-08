package com.dsa.dp.Arrays.NumberOfIncreasingPathsInAGrid;

/* You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all 4 directions.
 * Return the number of strictly increasing paths in the grid such that you can start from any cell and end at any cell.
 * Since the answer may be very large, return it modulo 109 + 7.
 * Two paths are considered different if they do not have exactly the same sequence of visited cells.*/

public class Memoization {

	private static final int MOD = 1_000_000_007;

	private static int increasingPath(int r1, int c1, int rows, int cols, int[][] grid, int[][] dp) {

		if (dp[r1][c1] != 0) {
			return dp[r1][c1];
		}

		long result = 1;

		// Up
		if (r1 - 1 >= 0 && grid[r1 - 1][c1] > grid[r1][c1]) {
			result += increasingPath(r1 - 1, c1, rows, cols, grid, dp);
			result %= MOD;
		}
		// Down
		if (r1 + 1 < rows && grid[r1 + 1][c1] > grid[r1][c1]) {
			result += increasingPath(r1 + 1, c1, rows, cols, grid, dp);
			result %= MOD;
		}
		// Left
		if (c1 - 1 >= 0 && grid[r1][c1 - 1] > grid[r1][c1]) {
			result += increasingPath(r1, c1 - 1, rows, cols, grid, dp);
			result %= MOD;
		}
		// Right
		if (c1 + 1 < cols && grid[r1][c1 + 1] > grid[r1][c1]) {
			result += increasingPath(r1, c1 + 1, rows, cols, grid, dp);
			result %= MOD;
		}

		return dp[r1][c1] = (int) result;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 1 }, { 3, 4 } };

		int rows = grid.length;
		int cols = grid[0].length;

		long totalPaths = 0;

		int[][] dp = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				totalPaths += increasingPath(i, j, rows, cols, grid, dp);
				totalPaths %= MOD;
			}
		}

		System.out.println((int)totalPaths);
	}
}
