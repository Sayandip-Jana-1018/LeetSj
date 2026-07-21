# 63. Unique Paths II

🟡 **Medium** · `Array` `Dynamic Programming` `Matrix`

## Problem Summary

This problem asks us to find the number of unique paths a robot can take to travel from the top-left corner to the bottom-right corner of a grid. The robot can only move either down or right at any point. The grid contains obstacles, marked as `1`, while empty spaces are marked as `0`. If a cell is an obstacle, the robot cannot pass through it. We need to return the total count of distinct paths, considering the obstacles.

See the [full problem on LeetCode](https://leetcode.com/problems/unique-paths-ii/).

## Approach & Implementation

The core technique used to solve this problem is **Dynamic Programming (DP)**. We build a 2D DP table, `dp`, where `dp[i][j]` represents the number of unique paths to reach the cell `(i, j)` from the starting point `(0, 0)`.

Here's a step-by-step breakdown of the provided code:

1.  **Initialize Grid Dimensions and Handle Start Obstacle**:
    *   `int m = obstacleGrid.length;` and `int n = obstacleGrid[0].length;` retrieve the dimensions of the grid.
    *   `if(obstacleGrid[0][0] == 1) return 0;` This is a crucial base case. If the starting cell itself is an obstacle, it's impossible to start, so there are 0 unique paths.
    *   `int[][] dp = new int[m][n];` A new 2D array `dp` of the same dimensions as `obstacleGrid` is created to store the number of paths.
    *   `dp[0][0] = 1;` The starting cell `(0, 0)` is reachable in one "path" (by simply being there).

2.  **Initialize the First Column of the DP Table**:
    *   `for(int i=1; i<m; i++) { ... }` This loop iterates through the first column (cells `(1,0)` to `(m-1,0)`).
    *   `if(obstacleGrid[i][0] == 0 && dp[i-1][0] == 1)`: To reach `(i, 0)`, the robot must come from `(i-1, 0)`.
        *   `obstacleGrid[i][0] == 0`: Checks if the current cell `(i,0)` itself is not an obstacle.
        *   `dp[i-1][0] == 1`: Checks if the cell directly above `(i-1,0)` was reachable. If `dp[i-1][0]` is `0` (meaning an obstacle blocked the path somewhere above it), then `(i,0)` also cannot be reached via this column.
    *   `dp[i][0] = 1;` If both conditions are true, then `(i,0)` is reachable with 1 unique path (purely vertical from `(0,0)`).
    *   `else dp[i][0] = 0;` Otherwise, `(i,0)` is unreachable.

3.  **Initialize the First Row of the DP Table**:
    *   `for(int j=1; j<n; j++) { ... }` This loop iterates through the first row (cells `(0,1)` to `(0,n-1)`).
    *   `if(obstacleGrid[0][j] == 0 && dp[0][j-1] == 1)`: Similar logic as the first column, but checking the cell directly to the left `(0,j-1)`.
        *   `obstacleGrid[0][j] == 0`: Checks if `(0,j)` is not an obstacle.
        *   `dp[0][j-1] == 1`: Checks if the cell directly left `(0,j-1)` was reachable.
    *   `dp[0][j] = 1;` If both conditions are true, `(0,j)` is reachable with 1 unique path (purely horizontal from `(0,0)`).
    *   `else dp[0][j] = 0;` Otherwise, `(0,j)` is unreachable.

4.  **Fill the Remaining DP Table**:
    *   `for(int i=1; i<m; i++) { for(int j=1; j<n; j++) { ... } }` These nested loops iterate through the rest of the grid, starting from `(1,1)`.
    *   `if(obstacleGrid[i][j] == 1) dp[i][j] = 0;` If the current cell `(i,j)` contains an obstacle, no paths can reach it, so `dp[i][j]` is set to `0`.
    *   `else dp[i][j] = dp[i-1][j] + dp[i][j-1];` If `(i,j)` is not an obstacle, the number of unique paths to reach it is the sum of paths from the cell directly above (`dp[i-1][j]`) and the cell directly to its left (`dp[i][j-1]`). This is the standard recurrence relation for unique paths.

5.  **Return the Result**:
    *   `return dp[m-1][n-1];` After filling the entire `dp` table, the value at `dp[m-1][n-1]` (the bottom-right cell) will hold the total number of unique paths to reach the destination.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(m*n) - The code iterates through the grid elements a constant number of times (once for initial checks, once for the first column, once for the first row, and once for the rest of the grid with nested loops). Each operation inside the loops is constant time. Therefore, the total time complexity is directly proportional to the number of cells in the grid, `m * n`.
-   **Space:** O(m*n) - An auxiliary 2D array `dp` of size `m x n` is created to store the number of paths to each cell. This is the dominant factor in space usage.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 43.3 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/unique-paths-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2075942198/)
