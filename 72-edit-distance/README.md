# 72. Edit Distance

🟡 **Medium** · `String` `Dynamic Programming`

## Problem Summary

The "Edit Distance" problem asks us to find the minimum number of operations required to transform one given string (`word1`) into another (`word2`). The allowed operations are: inserting a character, deleting a character, or substituting a character. Each operation counts as one step. The goal is to determine the fewest total steps to make the two strings identical.

See the [full problem on LeetCode](https://leetcode.com/problems/edit-distance/).

## Approach & Implementation

This problem is a classic application of **Dynamic Programming**. The core idea is to break down the problem of finding the edit distance between two strings into smaller, overlapping subproblems. We build up a solution by finding the edit distances for prefixes of the given strings.

The provided Java code implements this dynamic programming approach using a 2D array.

*   **Data Structure: `dp` array**
    *   A 2D integer array `dp` of size `(row + 1) x (col + 1)` is created, where `row` is the length of `word1` and `col` is the length of `word2`.
    *   `dp[i][j]` stores the minimum edit distance between the first `i` characters of `word1` (i.e., `word1.substring(0, i)`) and the first `j` characters of `word2` (i.e., `word2.substring(0, j)`).
    *   The `+1` in dimensions accommodates the base cases where one or both strings are empty (represented by index 0).

*   **Initialization (Base Cases)**
    *   The first row and first column of the `dp` array are initialized to handle cases where one of the strings is empty:
        *   `for(int r=0; r<=row; r++) { dp[r][0] = r; }`
            *   `dp[r][0]` represents the distance to transform `word1.substring(0, r)` into an empty string (`""`). This requires `r` deletion operations. For example, to transform "abc" (length 3) into "" requires 3 deletions.
        *   `for(int c=0; c<=col; c++) { dp[0][c] = c; }`
            *   `dp[0][c]` represents the distance to transform an empty string (`""`) into `word2.substring(0, c)`. This requires `c` insertion operations. For example, to transform "" into "xyz" (length 3) requires 3 insertions.

*   **Filling the `dp` Table (Recurrence Relation)**
    *   The code then iterates through the rest of the `dp` table, starting from `dp[1][1]`, using nested loops:
        *   `for(int r=1; r<=row; r++) { for(int c=1; c<=col; c++) { ... } }`
    *   For each cell `dp[r][c]`, it compares the characters `word1.charAt(r-1)` and `word2.charAt(c-1)` (we use `r-1` and `c-1` because string indices are 0-based while `dp` indices are 1-based for string lengths):
        *   **Case 1: Characters Match**
            *   `if(word1.charAt(r-1) == word2.charAt(c-1))`
            *   If the current characters are the same, no operation is needed for these specific characters. The edit distance `dp[r][c]` is simply the edit distance of the previous prefixes: `dp[r-1][c-1]`.
        *   **Case 2: Characters Don't Match**
            *   `else dp[r][c] = 1 + Math.min(dp[r-1][c-1], Math.min(dp[r][c-1], dp[r-1][c]));`
            *   If the characters differ, an operation must occur. We take `1` (for the current operation) plus the minimum of three possibilities:
                1.  **Substitution:** `dp[r-1][c-1]` represents changing `word1.charAt(r-1)` to `word2.charAt(c-1)`. This covers the previous prefixes, plus 1 for the substitution.
                2.  **Insertion:** `dp[r][c-1]` represents inserting `word2.charAt(c-1)` into `word1`. This means we effectively match `word1.substring(0, r)` with `word2.substring(0, c-1)` and then insert the new character.
                3.  **Deletion:** `dp[r-1][c]` represents deleting `word1.charAt(r-1)` from `word1`. This means we match `word1.substring(0, r-1)` with `word2.substring(0, c)` and then delete the `word1.charAt(r-1)`.

*   **Result**
    *   After filling the entire `dp` table, `dp[row][col]` will contain the minimum edit distance between the full `word1` and the full `word2`. This value is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(m*n) - The algorithm involves initializing the first row and column (O(m) + O(n)) and then iterating through a 2D `dp` table of size `(m+1) x (n+1)` (where `m` is `word1.length()` and `n` is `word2.length()`). Each cell calculation takes constant time. Thus, the dominant factor is the nested loop, leading to O(m*n) time complexity.
- **Space:** O(m*n) - A 2D array `dp` of size `(m+1) x (n+1)` is used to store the intermediate results, directly proportional to the product of the lengths of the two input strings.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 5 ms |
| Memory | 47.1 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/edit-distance/)
- [View My Submission](https://leetcode.com/submissions/detail/2076587861/)
