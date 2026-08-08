package com.dsa.dp.Arrays.MinimumPathSum;

/* Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.*/

public class Solution {

	public static int minPathSum(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {

				if (i == m - 1 && j != n - 1) {
					grid[i][j] = grid[i][j] + grid[i][j + 1];
				} else if (j == n - 1 && i != m - 1) {
					grid[i][j] = grid[i][j] + grid[i + 1][j];
				} else if (i != m - 1 && j != n - 1) {
					grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
				}
			}
		}

		return grid[0][0];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		System.out.println(minPathSum(grid));
	}
}
