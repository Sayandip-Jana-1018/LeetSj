# 3805. Maximize Active Section with Trade I

🟡 **Medium** · `String` `Enumeration`

## Problem Summary

The problem asks us to maximize the total length of "active sections" (contiguous blocks of '1's) within a binary string, given that we can perform at most one "trade" operation. An "active section" refers to a continuous sequence of '1's. The "trade" operation involves converting one or more '0's to '1's to strategically extend or merge these active sections. Our objective is to find the maximum possible sum of lengths of all such '1' blocks after performing the single allowed trade.

See the [full problem on LeetCode](https://leetcode.com/problems/maximize-active-section-with-trade-i/).

## Approach & Implementation

The provided solution uses a single pass through the string, grouping consecutive identical characters. This is a common pattern for problems involving segments or "runs" of characters. The core idea is to calculate the baseline sum of existing '1's and then determine the maximum additional '1's that can be gained by a single "trade" operation.

The algorithm can be broken down into these steps:

*   **Initialization:**
    *   `initialOnes`: An integer variable initialized to `0`. This will accumulate the total length of all '1' blocks that are already present in the string.
    *   `maxGain`: An integer variable initialized to `0`. This will store the maximum additional length of '1' sections that can be achieved through the "trade" operation.
    *   `preZero`: An integer variable initialized to `-1`. This stores the length of the *immediately preceding* block of '0's encountered. It's crucial for identifying opportunities to bridge two '0' blocks.
    *   `n`: Stores the length of the input string `s`.
    *   `i`: An outer loop pointer, initialized to `0`, marking the start of the current character block.

*   **Iterating Through Blocks:**
    *   The `while (i < n)` loop iterates through the string, processing it block by block.
    *   Inside this loop, an inner `while (j < n && s.charAt(j) == s.charAt(i))` loop identifies the end of the current block of identical characters.
    *   `curLength`: Calculates the length of the current block (`j - i`).

*   **Processing '1' Blocks:**
    *   If `s.charAt(i) == '1'` (the current block consists of '1's):
        *   `initialOnes += curLength`: The length of this '1' block is added to `initialOnes`, as these are already active sections.

*   **Processing '0' Blocks (The "Trade" Logic):**
    *   If `s.charAt(i) == '0'` (the current block consists of '0's):
        *   `if (preZero != -1)`: This condition checks if a *previous* '0' block was encountered (`preZero` stores its length). If so, it means we have a pattern like `... (previous '0' block) ... (some '1' blocks) ... (current '0' block) ...`.
            *   `maxGain = Math.max(maxGain, preZero + curLength);`: The problem's "Trade I" interpretation here is critical. This line implies that one type of allowed "trade" is to conceptually merge two distinct '0' blocks (`preZero` and `curLength`) that are separated by '1's. By doing so, the additional length of '1's gained is simply the sum of the lengths of these two '0' blocks. The existing '1's between them are already accounted for in `initialOnes`. `maxGain` keeps track of the largest such sum found.
        *   `preZero = curLength`: After processing the current '0' block, its length becomes the `preZero` for any subsequent '0' blocks.

*   **Moving to the Next Block:**
    *   `i = j`: The outer loop pointer `i` is updated to `j`, moving to the start of the next distinct character block.

*   **Final Result:**
    *   `return initialOnes + maxGain`: The total maximum active sections are the sum of the initial active '1' sections and the maximum additional gain achievable through one "trade".

This approach effectively calculates the sum of all existing '1's and then finds the maximum potential gain from converting two separate blocks of '0's (if separated by '1's) into '1's, as a single "trade" operation.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

*   **Time:** O(N) - The algorithm iterates through the string `s` once using the `i` pointer, and the inner `j` pointer also moves forward, ensuring that each character is visited a constant number of times. Therefore, the time complexity is directly proportional to the length of the string `N`.
*   **Space:** O(1) - The algorithm uses a fixed number of auxiliary variables (`initialOnes`, `maxGain`, `preZero`, `n`, `i`, `j`, `curLength`) regardless of the input string's size. Thus, the space complexity is constant.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 81 ms |
| Memory | 47.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/maximize-active-section-with-trade-i/)
- [View My Submission](https://leetcode.com/submissions/detail/2075268870/)
