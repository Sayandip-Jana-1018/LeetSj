# 516. Longest Palindromic Subsequence

🟡 **Medium** · `String` `Dynamic Programming`

## Problem Summary

This problem asks us to find the length of the longest subsequence within a given string `s` that is also a palindrome. A *subsequence* is a sequence that can be derived from another sequence by deleting zero or more elements without changing the order of the remaining elements. A *palindrome* is a sequence that reads the same forwards and backward. For example, if `s = "bbbab"`, the longest palindromic subsequence is `"bbbb"`, which has a length of 4.

See the [full problem on LeetCode](https://leetcode.com/problems/longest-palindromic-subsequence/).

## Approach & Implementation

The core technique used here is **Dynamic Programming**. We build up a solution for larger subproblems by leveraging solutions to smaller, overlapping subproblems.

Let `dp[i][j]` represent the length of the longest palindromic subsequence (LPS) within the substring `s[i...j]` (inclusive). Our goal is to find `dp[0][n-1]`, which represents the LPS of the entire string `s`.

Here's a step-by-step breakdown of the implementation:

*   **Initialization:**
    *   `int n = s.length();`: We first get the length of the input string.
    *   `int[][] dp = new int[n][n];`: A 2D array `dp` of size `n x n` is initialized. `dp[i][j]` will store the length of the LPS for `s[i...j]`.
    *   `for (int i = 0; i < n; i++) { dp[i][i] = 1; }`: Every single character substring `s[i...i]` is a palindrome of length 1. So, we initialize the diagonal elements of our `dp` table.

*   **Filling the DP Table (Bottom-Up):**
    *   The loops iterate in a specific order: `for (int i = n - 1; i >= 0; i--)` and `for (int j = i + 1; j < n; j++)`. This order is critical because `dp[i][j]` depends on values like `dp[i+1][j-1]`, `dp[i+1][j]`, and `dp[i][j-1]`. By iterating `i` downwards and `j` upwards from `i+1`, we ensure that these "smaller" subproblems (i.e., those representing shorter substrings or substrings starting/ending later) have already been computed.
    *   **Case 1: Characters Match (`s.charAt(i) == s.charAt(j)`)**
        *   If the characters at the ends of the current substring `s[i]` and `s[j]` are the same, they can form the outermost pair of a palindrome.
        *   The length of the LPS for `s[i...j]` will then be 2 (for `s[i]` and `s[j]`) plus the length of the LPS for the inner substring `s[i+1...j-1]`.
        *   This is captured by: `dp[i][j] = dp[i + 1][j - 1] + 2;`
    *   **Case 2: Characters Don't Match (`s.charAt(i) != s.charAt(j)`)**
        *   If the characters at the ends of the current substring `s[i]` and `s[j]` are different, we cannot include both in the same palindromic subsequence.
        *   We must decide to either:
            *   Exclude `s[i]` and find the LPS of `s[i+1...j]`, which is `dp[i+1][j]`.
            *   Exclude `s[j]` and find the LPS of `s[i...j-1]`, which is `dp[i][j-1]`.
        *   We take the maximum of these two options, as we want the *longest* palindromic subsequence: `dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);`

*   **Result:**
    *   After the loops complete, `dp[0][n-1]` will contain the length of the longest palindromic subsequence for the entire input string `s`. This value is then returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N^2)
    *   The code involves two nested loops, each iterating up to `n` times (where `n` is the length of the string `s`).
    *   Inside the loops, operations like character comparison, array access, and `Math.max` take constant time.
    *   Therefore, the total time complexity is proportional to `n * n`.
-   **Space:** O(N^2)
    *   A 2D `dp` array of size `n x n` is used to store intermediate results.
    *   This array's size directly scales with the square of the input string's length.
    *   No other data structures consume space proportional to `n`.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 33 ms |
| Memory | 64.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/longest-palindromic-subsequence/)
- [View My Submission](https://leetcode.com/submissions/detail/2076652702/)
