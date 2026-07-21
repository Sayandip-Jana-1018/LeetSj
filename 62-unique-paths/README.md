# 62. Unique Paths

🟡 **Medium** · `Math` `Dynamic Programming` `Combinatorics`

## Problem Summary
The problem asks us to calculate the total number of distinct paths a robot can take to travel from the top-left corner to the bottom-right corner of an `m x n` grid. The robot is restricted to moving only down or right at any step. We need to find how many unique sequences of 'down' and 'right' moves exist to reach the destination. See the [full problem on LeetCode](https://leetcode.com/problems/unique-paths/).

## Approach & Implementation
The provided solution uses a classic Dynamic Programming (DP) approach to solve the problem. The core idea is to build up the solution for each cell in the grid based on the solutions of its preceding cells.

*   **DP Table Initialization:** A 2D integer array `dp` of size `m x n` is created. Each cell `dp[r][c]` will store the number of unique paths from the starting cell `(0, 0)` to the current cell `(r, c)`.

*   **Base Cases - First Column:** The first loop, `for(int r=0; r<m; r++) { dp[r][0] = 1; }`, initializes all cells in the first column. For any cell `(r, 0)`, there is only one way to reach it from `(0, 0)`: by moving 'down' `r` times. Thus, `dp[r][0]` is set to 1 for all `r`.

*   **Base Cases - First Row:** Similarly, the second loop, `for(int c=0; c<n; c++) { dp[0][c] = 1; }`, initializes all cells in the first row. For any cell `(0, c)`, there is only one way to reach it from `(0, 0)`: by moving 'right' `c` times. Thus, `dp[0][c]` is set to 1 for all `c`.

*   **Filling the DP Table (Recurrence Relation):** The nested loops, `for(int r=1; r<m; r++) { for(int c=1; c<n; c++) { ... } }`, iterate through the rest of the grid, starting from `(1, 1)`. For any cell `(r, c)`, the robot can reach it in two ways:
    *   By moving 'down' from the cell directly above it: `(r-1, c)`.
    *   By moving 'right' from the cell directly to its left: `(r, c-1)`.
    The total number of unique paths to `(r, c)` is the sum of unique paths to `(r-1, c)` and unique paths to `(r, c-1)`. This is precisely captured by the recurrence relation: `dp[r][c] = dp[r-1][c] + dp[r][c-1];`.

*   **Final Result:** After iterating through and filling all relevant cells in the `dp` table, the value at `dp[m-1][n-1]` will contain the total number of unique paths to reach the bottom-right corner of the `m x n` grid. This value is then returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(m*n) - The algorithm initializes the first row and column, taking O(m + n) time. The dominant part is filling the rest of the `m x n` DP table using two nested loops, where each cell's value is computed in O(1) time. Therefore, the total time complexity is proportional to the number of cells in the grid.
- **Space:** O(m*n) - A 2D array `dp` of size `m x n` is used to store all intermediate results. This leads to a space complexity directly proportional to the size of the grid.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 42 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/unique-paths/)
- [View My Submission](https://leetcode.com/submissions/detail/2075863455/)
