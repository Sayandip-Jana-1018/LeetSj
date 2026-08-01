# 486. Predict the Winner

🟡 **Medium** · `Array` `Math` `Dynamic Programming` `Recursion` `Game Theory`

## Problem Summary
The problem involves predicting the winner of a game where two players take turns picking numbers from an array, with the goal of having a higher total score than the opponent. The game's rules and constraints lead to a complex decision-making process, requiring a strategic approach to determine the potential winner. See the [full problem on LeetCode](https://leetcode.com/problems/predict-the-winner/).

## Approach & Implementation
The provided code uses a dynamic programming approach to solve the problem. The core pattern employed here is **Memoization with Recursion**. The main steps of the code can be broken down as follows:
* Initialize a 2D array `dp` to store the maximum difference in scores for each subarray, with all values initially set to -1.
* Define a recursive function `maxDiff` that takes the current subarray bounds `i` and `j`, the input array `A`, and the `dp` array as parameters.
* Within the `maxDiff` function:
  + Check if the result for the current subarray is already computed and stored in `dp`. If so, return the stored value.
  + If the subarray contains only one element (`i == j`), return the value of that element as the maximum difference.
  + Otherwise, recursively compute the maximum difference by considering two options: 
    - The current player chooses the first element of the subarray, leaving the opponent with the subarray from `i + 1` to `j`.
    - The current player chooses the last element of the subarray, leaving the opponent with the subarray from `i` to `j - 1`.
  + The `maxDiff` function returns the maximum of these two options, subtracting the opponent's maximum difference from the current player's score.
* The main function `predictTheWinner` checks if the length of the input array is even. If it is, the function returns `true`, as the first player can always win in this case. Otherwise, it calls the `maxDiff` function with the initial subarray bounds and returns `true` if the maximum difference is non-negative, indicating that the first player can win.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n^2) - The time complexity is quadratic due to the recursive function `maxDiff` being called for each subarray, resulting in a total of n*(n+1)/2 unique subarray bounds. The memoization in the `dp` array prevents redundant computations, reducing the time complexity from exponential to quadratic.
- **Space:** O(n^2) - The space complexity is also quadratic, as the `dp` array stores the maximum differences for all possible subarrays, requiring n*(n+1)/2 entries in the worst case.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 42.6 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/predict-the-winner/)
- [View My Submission](https://leetcode.com/submissions/detail/2090189712/)
