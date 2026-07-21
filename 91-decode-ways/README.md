# 91. Decode Ways

🟡 **Medium** · `String` `Dynamic Programming`

## Problem Summary
This problem asks us to calculate the total number of ways a given digit string can be decoded into letters. Each digit can be mapped to a letter based on the standard A-Z mapping: 'A' corresponds to '1', 'B' to '2', ..., 'Z' to '26'. A crucial constraint is that '0' cannot be mapped on its own; it must be part of a two-digit number like '10' (J) or '20' (T). We need to consider all possible groupings of digits (either single digits or valid two-digit combinations) to form a sequence of letters and count how many such unique sequences exist.

For example:
*   "12" can be decoded as "AB" (1 2) or "L" (12), so there are 2 ways.
*   "226" can be decoded as "BBF" (2 2 6), "VF" (22 6), or "BZ" (2 26), so there are 3 ways.
*   "06" cannot be decoded, as '0' is invalid on its own and '06' is not a valid two-digit mapping (must be 10-26), so there are 0 ways.

See the [full problem on LeetCode](https://leetcode.com/problems/decode-ways/).

## Approach & Implementation
The problem exhibits optimal substructure and overlapping subproblems, making Dynamic Programming an ideal approach. We build up the solution for the entire string by leveraging solutions for its prefixes.

*   **Core Pattern:** Dynamic Programming

Here's a step-by-step breakdown of the code's logic:

*   **Initial Edge Cases:**
    *   `if(s.length() == 0 || s == null || s.charAt(0) == '0') return 0;`
        *   The code first handles immediate invalid or empty scenarios. An empty string or a `null` string cannot be decoded.
        *   If the string starts with '0', it's impossible to decode because '0' alone doesn't map to a letter, and any two-digit number starting with '0' (e.g., "01", "06") is not a valid encoding (must be 10-26). In all these cases, `0` ways are returned.

*   **Dynamic Programming Array Initialization:**
    *   `int[] dp = new int[s.length() + 1];`
        *   A `dp` array is created with a size of `s.length() + 1`. `dp[i]` will store the number of ways to decode the substring `s[0...i-1]` (i.e., the prefix of length `i`).
    *   `dp[0] = 1;`
        *   `dp[0]` represents an "empty string" (or the state before any characters are processed). It's initialized to `1` because there's one way to decode an empty string (the "empty way"). This base case is crucial for the recurrence relation to correctly add ways from previous subproblems.
    *   `dp[1] = 1;`
        *   `dp[1]` represents the first character of the string `s[0]`. Since we've already checked that `s.charAt(0)` is not '0', a single-digit string will always have exactly one way to decode (e.g., "1" -> "A").

*   **Iterating and Building DP Table:**
    *   `for(int i=2; i<=s.length(); i++) { ... }`
        *   The loop starts from `i=2` up to `s.length()`. In each iteration, `i` represents the current length of the prefix we are trying to decode, and we calculate `dp[i]`. This means `s.substring(0, i)` is the current prefix under consideration.

*   **Checking One-Digit Decoding:**
    *   `int one = Integer.parseInt(s.substring(i-1, i));`
        *   This extracts the *last digit* of the current prefix (e.g., for `i=2`, it's `s.charAt(1)`).
    *   `if(one >= 1 && one <= 9) dp[i] += dp[i-1];`
        *   If this single digit is valid (between '1' and '9'), it can be decoded independently. The number of ways to decode the prefix `s[0...i-1]` by treating `s[i-1]` as a single digit is equal to the number of ways to decode the prefix `s[0...i-2]` (which is `dp[i-1]`). We add this to `dp[i]`.

*   **Checking Two-Digit Decoding:**
    *   `int two = Integer.parseInt(s.substring(i-2, i));`
        *   This extracts the *last two digits* of the current prefix (e.g., for `i=2`, it's `s.substring(0,2)`).
    *   `if(two >= 10 && two <= 26) dp[i] += dp[i-2];`
        *   If these two digits form a valid number between '10' and '26' (inclusive), they can be decoded together. The number of ways to decode the prefix `s[0...i-1]` by treating `s[i-2...i-1]` as a two-digit number is equal to the number of ways to decode the prefix `s[0...i-3]` (which is `dp[i-2]`). We add this to `dp[i]`.

*   **Final Result:**
    *   `return dp[s.length()];`
        *   After the loop completes, `dp[s.length()]` will hold the total number of ways to decode the entire input string `s`.

This dynamic programming approach systematically builds up the solution by considering all valid single-digit and two-digit decodings at each step, ensuring all possible combinations are counted without recomputing subproblems.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N)
    -   The code iterates through the string once with a single `for` loop that runs `s.length() - 1` times. Inside the loop, operations like `substring()` and `parseInt()` for fixed-length (1 or 2 characters) substrings take constant time. Therefore, the total time complexity is linear with respect to the length of the input string `N`.
-   **Space:** O(N)
    -   An integer array `dp` of size `s.length() + 1` is created to store the number of ways for each prefix. This array consumes space proportional to the length of the input string `N`.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 42.7 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/decode-ways/)
- [View My Submission](https://leetcode.com/submissions/detail/2075331819/)
