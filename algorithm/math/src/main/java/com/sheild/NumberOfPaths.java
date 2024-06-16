package com.sheild;

/**
 * @author miller
 * @date 2023/9/20
 * @version 1.0.0
 */
public class NumberOfPaths {
    public static int uniquePaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a DP table to store the number of paths to each cell
        int[][] dp = new int[rows][cols];

        // Initialize the first cell with 1
        dp[0][0] = 1;

        // Fill in the DP table
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row > 0)
                    dp[row][col] += dp[row - 1][col];
                if (col > 0)
                    dp[row][col] += dp[row][col - 1];
            }
        }

        // Return the number of paths to the last cell
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9},
                {1, 2, 3,4,5,6,7,8,9}
        };
        int numberOfPaths = uniquePaths(grid);
        System.out.println("Number of paths: " + numberOfPaths);
    }
}
