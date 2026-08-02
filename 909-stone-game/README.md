# 909. Stone Game

🟡 **Medium** · `Array` `Math` `Dynamic Programming` `Game Theory`

## Problem Summary
The problem involves a game where two players take turns picking stones from a pile, with the goal of having more stones than the opponent. The player can choose to pick stones from either end of the pile, and the game continues until all stones have been picked. The task is to determine if the first player can guarantee a win, regardless of the opponent's strategy. See the [full problem on LeetCode](https://leetcode.com/problems/stone-game/).

## Approach & Implementation
The provided code uses dynamic programming to solve the problem, specifically employing a technique known as memoization. The core pattern here is **Recursive Dynamic Programming with Memoization**. Here's a step-by-step breakdown:

*   The `stoneGame` function initializes a 2D array `memo` to store the results of subproblems, ensuring that each subproblem is solved only once.
*   The `solve` function takes four parameters: the `piles` array, and the `left` and `right` indices representing the current subarray of piles.
*   The base case for the recursion is when `left == right`, meaning there's only one pile left. In this case, the function returns the value of the only pile.
*   If the result for the current subproblem is already stored in `memo`, the function returns the stored value instead of recalculating it.
*   The function calculates the maximum score the first player can get by either picking the leftmost pile or the rightmost pile:
    *   `pickLeft` calculates the score if the first player picks the leftmost pile, subtracting the maximum score the second player can get from the remaining piles.
    *   `pickRight` calculates the score if the first player picks the rightmost pile, subtracting the maximum score the second player can get from the remaining piles.
*   The function stores the maximum of `pickLeft` and `pickRight` in `memo` and returns this value.
*   The main `stoneGame` function calls `solve` with the initial `left` and `right` indices and returns `true` if the result is greater than 0, indicating that the first player can guarantee a win.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(n^2) - The time complexity is quadratic because the `solve` function recursively calculates the maximum score for each subproblem, and there are n^2 possible subproblems (n being the number of piles). Memoization helps avoid redundant calculations, reducing the time complexity from exponential to quadratic.
-   **Space:** O(n^2) - The space complexity is also quadratic due to the use of a 2D `memo` array to store the results of subproblems. The size of this array is n x n, where n is the number of piles.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 10 ms |
| Memory | 49.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/stone-game/)
- [View My Submission](https://leetcode.com/submissions/detail/2091429617/)
