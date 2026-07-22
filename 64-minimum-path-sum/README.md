# 64. Minimum Path Sum

🟡 **Medium** · `Array` `Dynamic Programming` `Matrix`

## Problem Summary

The "Minimum Path Sum" problem asks us to find a path from the top-left corner to the bottom-right corner of a grid filled with non-negative numbers. We are only allowed to move either down or right at any point in time. The goal is to find a path such that the sum of all numbers along that path is minimized. We need to return this minimum sum.

See the [full problem on LeetCode](https://leetcode.com/problems/minimum-path-sum/).

## Approach & Implementation

The core technique used in the provided code is **Dynamic Programming**. Specifically, it uses an in-place modification of the input grid to store the minimum path sums to reach each cell. This transforms the original grid into a DP table where `grid[r][c]` eventually stores the minimum sum to reach cell `(r, c)` from the top-left corner.

Here's a step-by-step breakdown of the implementation:

*   **Initialization of Dimensions:**
    *   `int rows = grid.length;` and `int cols = grid[0].length;` retrieve the dimensions of the input grid. These will be used to iterate through the grid and access the final result.

*   **Initialize the First Row:**
    ```java
    for (int c = 1; c < cols; c++) {
        grid[0][c] += grid[0][c - 1];
    }
    ```
    *   This loop iterates through the first row of the grid, starting from the second element (`c = 1`).
    *   For any cell `grid[0][c]` in the first row, the only way to reach it from the top-left corner by moving only down or right is to come from its immediate left neighbor, `grid[0][c-1]`.
    *   Therefore, `grid[0][c]` is updated to store its original value plus the minimum path sum to reach `grid[0][c-1]` (which is already stored in `grid[0][c-1]` from the previous iteration). After this loop, `grid[0][c]` will hold the minimum path sum from `grid[0][0]` to `grid[0][c]`.

*   **Initialize the First Column:**
    ```java
    for (int r = 1; r < rows; r++) {
        grid[r][0] += grid[r - 1][0];
    }
    ```
    *   Similar to the first row, this loop iterates through the first column, starting from the second element (`r = 1`).
    *   For any cell `grid[r][0]` in the first column, the only way to reach it from the top-left corner is to come from its immediate top neighbor, `grid[r-1][0]`.
    *   `grid[r][0]` is updated to store its original value plus the minimum path sum to reach `grid[r-1][0]`. After this loop, `grid[r][0]` will hold the minimum path sum from `grid[0][0]` to `grid[r][0]`.

*   **Fill the Remaining Grid (DP Calculation):**
    ```java
    for (int r = 1; r < rows; r++) {
        for (int c = 1; c < cols; c++) {
            grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
        }
    }
    ```
    *   These nested loops iterate through the rest of the grid, starting from `grid[1][1]`.
    *   For any cell `grid[r][c]`, we can reach it either from the cell directly above it (`grid[r-1][c]`) or from the cell directly to its left (`grid[r][c-1]`).
    *   Since we want the *minimum* path sum, we choose the path that yields a smaller sum from these two options. The values `grid[r-1][c]` and `grid[r][c-1]` already store the minimum path sums to reach those respective cells from `grid[0][0]`.
    *   `grid[r][c]` is updated to its original value plus the minimum of these two path sums (`Math.min(grid[r - 1][c], grid[r][c - 1])`). This ensures that `grid[r][c]` eventually stores the minimum path sum from `grid[0][0]` to `grid[r][c]`.

*   **Return the Result:**
    ```java
    return grid[rows - 1][cols - 1];
    ```
    *   After the loops complete, the bottom-right cell `grid[rows - 1][cols - 1]` will contain the minimum path sum from the top-left corner to itself, which is the desired final answer.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

-   **Time:** O(rows \* cols)
    *   The code involves three main loops: one iterates through the `cols` in the first row, another iterates through `rows` in the first column, and the final nested loops iterate through `(rows - 1) * (cols - 1)` cells. All these operations are linear with respect to the grid dimensions. The dominant factor is the nested loop, leading to a time complexity proportional to the total number of cells in the grid.
-   **Space:** O(1)
    *   The solution modifies the input `grid` in-place to store the intermediate dynamic programming results. No additional data structures are created that scale with the input size. Therefore, the auxiliary space complexity is constant.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 4 ms |
| Memory | 50.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/minimum-path-sum/)
- [View My Submission](https://leetcode.com/submissions/detail/2076539945/)
