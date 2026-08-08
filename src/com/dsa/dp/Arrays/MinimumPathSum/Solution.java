package com.dsa.dp.Arrays.MinimumPathSum;

public class Solution {

	public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // m: 0 to m-1 (m) -> m-1 to 0
        // n: 0 to n-1(n) -> n-1 to 0
        int[] prev = new int[n];

        for(int i = m-1; i >= 0; i--) {
            int[] curr = new int[n];
            for(int j = n-1; j >= 0; j--) {

                if(i == m-1 && j == n-1) {
                    curr[j] = grid[m-1][n-1];
                }
                else if(i == m-1) {
                    curr[j] = grid[i][j] + curr[j+1];
                }
                else if(j == n-1) {
                    curr[j] = grid[i][j] + prev[j];
                }
                else {
                    curr[j] = grid[i][j] + Math.min(curr[j+1], prev[j]);
                }
            }
            prev = curr;
        }
        
        return prev[0];
    }
	
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		
		System.out.println(minPathSum(grid));
	}
}
