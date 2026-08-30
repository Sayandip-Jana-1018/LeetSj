# 2212. Removing Minimum and Maximum From Array

🟡 **Medium** · `Array` `Greedy`

## Problem Summary

The problem asks us to find the minimum number of deletions required to remove both the minimum and maximum elements from a given array. We can only delete elements from either the front or the back of the array. The goal is to achieve this removal with the fewest possible operations.
See the [full problem on LeetCode](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/).

## Approach & Implementation

The core idea behind this solution is to first identify the positions of the minimum and maximum elements, and then exhaustively check the total deletions needed for the three fundamental strategies: removing both from the front, removing both from the back, or removing one from the front and the other from the back. The provided code cleverly encapsulates these three strategies by iterating through all possible counts of front deletions.

Here's a detailed breakdown of the implementation:

*   **1. Find Indices of Minimum and Maximum Elements:**
    *   The code initializes `left = 0` and `right = 0`. These variables will store the *indices* of the minimum and maximum elements found so far, respectively.
    *   It then iterates through the array starting from the second element (`i = 1`).
    *   `if (nums[i] < nums[left])`: If a new minimum is found, update `left` to `i`.
    *   `if (nums[i] > nums[right])`: If a new maximum is found, update `right` to `i`.
    *   After this loop, `left` will hold the index of the overall minimum element, and `right` will hold the index of the overall maximum element.

*   **2. Normalize Indices for Simpler Strategy Evaluation:**
    *   `if (left < right) { int temp = left; left = right; right = temp; }`
    *   This conditional swap ensures that `right` always stores the index of the element that is *closer to the beginning* of the array (the leftmost of the two target elements, min or max), and `left` stores the index of the element that is *closer to the end* of the array (the rightmost of the two target elements).
    *   Let's call these `min_idx_of_targets` (stored in `right`) and `max_idx_of_targets` (stored in `left`) for clarity from this point forward.

*   **3. Evaluate Deletion Strategies:**
    *   `int ans = n;`: `ans` is initialized to `n` (the total length of the array), representing the worst-case scenario where we delete all elements.
    *   The code then enters a loop: `for (int i = 0; i <= n; i++)`. This loop iterates through all possible numbers of elements `i` that could be deleted from the *front* of the array.
    *   Inside the loop, `int extra = 0;` is initialized to track deletions from the back.
    *   **Conditional Logic for `extra` (Deletions from Back):**
        *   `if (right >= i)`: This condition checks if the leftmost target element (`min_idx_of_targets`) is *still present* in the array after `i` deletions from the front. If it is, then to remove it, we *must* delete `n - right` elements from the back of the original array. This `extra` accounts for removing `min_idx_of_targets` and potentially `max_idx_of_targets` if it's also located to the right of `min_idx_of_targets` and hasn't been removed by `i` front deletions. This scenario covers:
            *   Removing both targets from the back (when `i = 0`).
            *   Removing `min_idx_of_targets` from the back, and `max_idx_of_targets` from the front (if `i` is such that `max_idx_of_targets < i` but `min_idx_of_targets >= i`). (Note: The specific `if/else if` structure handles this. If `right >= i`, `left` could be `< i` or `>= i`. If `left >= i` it's handled by `n-right`. If `left < i` it's already removed.)
        *   `else if (left >= i)`: This condition is checked if `min_idx_of_targets` has already been removed by the `i` front deletions (`right < i`). It then checks if the rightmost target element (`max_idx_of_targets`) is *still present*. If it is, we need to delete `n - left` elements from the back to remove it. This covers the strategy where `min_idx_of_targets` is removed from the front, and `max_idx_of_targets` is removed from the back.
        *   If neither `if` nor `else if` condition is met, it means both `min_idx_of_targets` and `max_idx_of_targets` have already been removed by the `i` deletions from the front. In this case, `extra` remains `0`. This covers the strategy of removing both targets from the front.
    *   `ans = Math.min(ans, i + extra);`: The total deletions for the current strategy (`i` from front, `extra` from back) are `i + extra`. We update `ans` with the minimum total deletions found so far.
*   **4. Return Result:**
    *   Finally, the function returns `ans`, which holds the minimum number of deletions required.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N) - The first loop to find the minimum and maximum indices iterates through the array once, taking O(N) time. The second loop iterates `N+1` times, performing constant-time operations in each iteration, contributing another O(N) time. Therefore, the dominant factor is linear with the input array size.
-   **Space:** O(1) - The solution uses a fixed number of integer variables (`n`, `left`, `right`, `temp`, `ans`, `i`, `extra`) regardless of the input array size. No additional data structures are allocated that scale with `N`.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 4 ms |
| Memory | 86.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/)
- [View My Submission](https://leetcode.com/submissions/detail/2124857822/)
