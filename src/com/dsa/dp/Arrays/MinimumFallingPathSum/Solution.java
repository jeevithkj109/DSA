package com.dsa.dp.Arrays.MinimumFallingPathSum;

/* Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 * A falling path starts at any element in the first row and chooses the element in the next row
 * that is either directly below or diagonally left/right. Specifically, the next element from position (row, col)
 * will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).*/

public class Solution {

	public static int minFallingPathSum(int[][] matrix) {

		int n = matrix.length;

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {

				int minChoice = matrix[i + 1][j];

				if (j > 0) {
					minChoice = Math.min(minChoice, matrix[i + 1][j - 1]);
				}
				if (j < n - 1) {
					minChoice = Math.min(minChoice, matrix[i + 1][j + 1]);
				}

				matrix[i][j] += minChoice;
			}
		}

		int result = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			result = Math.min(result, matrix[0][j]);
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
		
		System.out.println(minFallingPathSum(matrix));
	}
}
