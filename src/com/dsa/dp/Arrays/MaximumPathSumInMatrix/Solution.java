package com.dsa.dp.Arrays.MaximumPathSumInMatrix;

/* You are given a matrix mat[][] of size n x m where each element is a positive integer.
 * Starting from any cell in the first row, you are allowed to move to the next row, but with specific movement constraints.
 * From any cell (r, c) in the current row, you can move to any of the three possible positions :
 	* (r+1, c-1) — move diagonally to the left.
 	* (r+1, c) — move directly down.
 	* (r+1, c+1) — move diagonally to the right.
 * Find the maximum sum of any path starting from any column in the first row and ending at any column in the last row,
 * following the above movement constraints.*/

public class Solution {
	public static int maximumPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = m-2; i >= 0; i--) {
            for(int j = n-1; j>= 0; j--) {

                int maxChoice = matrix[i+1][j];

                if(j > 0){
                    maxChoice = Math.max(maxChoice, matrix[i+1][j-1]);
                }
                if(j < n-1) {
                    maxChoice = Math.max(maxChoice, matrix[i+1][j+1]);
                }

                matrix[i][j] += maxChoice;
            }
        }

        int result = Integer.MIN_VALUE;
        for(int j = 0; j < n; j++) {
            result = Math.max(result, matrix[0][j]);
        }

        return result;
        
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{3,6,1},{2,3,4},{5,5,1}};
		
		System.out.println(maximumPath(matrix));
	}
}
