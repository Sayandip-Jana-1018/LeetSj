# 3150. Shortest and Lexicographically Smallest Beautiful String

🟡 **Medium** · `String` `Sliding Window`

## Problem Summary

This problem asks us to find a "beautiful" substring within a given binary string `s`. A substring is considered beautiful if it contains exactly `k` ones. Among all beautiful substrings, we need to return the one that is the shortest. If there are multiple beautiful substrings with the same minimum length, we should return the one that is lexicographically smallest. If no beautiful substring exists, an empty string should be returned.

See the [full problem on LeetCode](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/).

## Approach & Implementation

The core technique used in the provided code is the **Sliding Window** pattern. We use two pointers, `left` and `right`, to define a dynamic window within the string `s`. The algorithm expands the window with `right` and shrinks it with `left` to maintain a count of '1's (`ones`) and find candidate substrings.

Here's a detailed breakdown of the implementation:

1.  **Initialization:**
    *   `n`: Stores the length of the input string `s`.
    *   `left`: The left pointer of the sliding window, initialized to `0`.
    *   `ones`: A counter for the number of '1's within the current window `s[left...right]`, initialized to `0`.
    *   `ans`: Stores the shortest and lexicographically smallest beautiful string found so far, initialized as an empty string.

2.  **Expanding the Window (Outer `for` loop):**
    *   The `right` pointer iterates from `0` to `n-1`, effectively expanding the window to the right.
    *   `if (s.charAt(right) == '1') ones++;`: If the character at the `right` pointer is '1', we increment our `ones` counter.

3.  **Shrinking the Window (First `while` loop):**
    *   `while (ones > k)`: This loop is executed when the current window `s[left...right]` contains *more than* `k` ones. To satisfy the condition of having exactly `k` ones, we need to shrink the window from the `left`.
    *   `if (s.charAt(left) == '1') ones--;`: If the character at the `left` pointer is '1', we decrement the `ones` counter as it's leaving the window.
    *   `left++;`: We then move the `left` pointer one step to the right.
    *   This process continues until `ones` is exactly `k` or less than `k`.

4.  **Checking for a Beautiful Substring (Conditional `if (ones == k)`):**
    *   Once `ones == k`, the current window `s[left...right]` contains exactly `k` ones, making it a potential beautiful substring.
    *   **Removing Unnecessary Leading Zeros (Second `while` loop):**
        *   `while (left < right && s.charAt(left) == '0') { left++; }`: Before processing the substring, we need to ensure it's as short as possible and lexicographically smallest for *its current configuration of `k` ones*. This is achieved by moving the `left` pointer past any leading zeros, as these zeros do not contribute to the `ones` count and only increase the substring's length and potentially affect its lexicographical order negatively (e.g., "0101" is longer and lexicographically larger than "101"). This step is crucial for both length and lexicographical comparisons.

    *   **Extracting Current Substring:**
        *   `String cur = s.substring(left, right + 1);`: We extract the beautiful substring from the adjusted `left` to `right` pointer.

    *   **Updating `ans` (Comparison Logic):**
        *   `if (ans.isEmpty() || cur.length() < ans.length() || (cur.length() == ans.length() && cur.compareTo(ans) < 0))`: This is the core logic for selecting the best beautiful string based on the problem's criteria:
            *   `ans.isEmpty()`: If `ans` is currently empty (meaning no beautiful string has been found yet), `cur` becomes the first candidate.
            *   `cur.length() < ans.length()`: If `cur` is strictly shorter than the current `ans`, `cur` is preferred.
            *   `cur.length() == ans.length() && cur.compareTo(ans) < 0`: If `cur` has the same length as `ans`, we compare them lexicographically. If `cur` is lexicographically smaller than `ans` (e.g., "101" is smaller than "110"), `cur` is preferred.
        *   `ans = cur;`: If `cur` is preferred based on these conditions, `ans` is updated.

5.  **Return Result:**
    *   After the `for` loop finishes iterating through the entire string, `ans` will hold the shortest and lexicographically smallest beautiful substring, which is then returned. If no such string was found, `ans` remains an empty string.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

*   **Time:** O(N^2)
    *   The `right` pointer iterates `N` times. The `left` pointer also iterates at most `N` times in total across all iterations of the `right` pointer, as it only moves forward. These pointer movements are `O(N)`.
    *   However, within the loop, `s.substring(left, right + 1)` creates a new string which takes `O(L)` time, where `L` is the length of the substring. The `cur.compareTo(ans)` operation also takes `O(L)` time. In the worst case, `L` can be `O(N)`. If `ans` is updated multiple times, or if many long candidate substrings are generated and compared, these string operations can lead to a total time complexity of `O(N^2)`. While in many practical cases for this specific problem (due to the "shortest" constraint) the average length `L` might be small, `O(N^2)` is the safer upper bound for direct string operations in Java within a loop.

*   **Space:** O(N)
    *   The `ans` string stores the result, which in the worst case could be the entire input string `s`.
    *   The `cur` string is temporarily created to hold candidate substrings, also potentially `O(N)` in length.
    *   Other variables (`n`, `left`, `ones`, `right`) consume constant space.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 2 ms |
| Memory | 43.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/)
- [View My Submission](https://leetcode.com/submissions/detail/2120446291/)
