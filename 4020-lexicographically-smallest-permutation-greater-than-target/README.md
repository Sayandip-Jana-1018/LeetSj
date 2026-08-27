# 4020. Lexicographically Smallest Permutation Greater Than Target

🟡 **Medium** · `Hash Table` `String` `Greedy` `Counting` `Enumeration`

## Problem Summary
The problem asks us to find the lexicographically smallest string `result` that satisfies two conditions:
1. `result` must be formed by using *all* characters from a given input string `s`. This implies `result` will have the same length as `s`.
2. `result` must be lexicographically strictly greater than another given input string `target`.

If multiple such strings `result` can be formed, we must return the lexicographically smallest one. If no such string can be formed (i.e., all permutations of `s` are lexicographically less than or equal to `target`), an empty string `""` should be returned.

See the [full problem on LeetCode](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/).

## Approach & Implementation
The provided solution employs a **Greedy** strategy, combined with a **right-to-left scan**, which is a common pattern for finding the "next greater permutation" or "next lexicographically greater string" using a given set of characters. The core idea is to find the rightmost position in `target` where a character can be incremented (replaced by a lexicographically larger character) such that the resulting string, when filled with the smallest possible characters afterwards, is still a valid permutation of `s`'s characters and is lexicographically minimal.

Here's a step-by-step breakdown of the implementation:

*   **1. Initialize Character Counts:**
    *   An integer array `cnt` of size 26 is initialized to store the frequency of each lowercase English letter.
    *   The code first iterates through the characters of string `s`, incrementing their respective counts in `cnt`. This `cnt` array now represents the total pool of characters available from `s`.
    *   Next, it iterates through the characters of string `target`, decrementing their counts in `cnt`. After this step, `cnt` effectively holds the counts of characters that are in `s` *minus* the characters that are in `target`. A negative count for a character `x` at this point would imply `s` does not contain enough `x`'s to even form `target`.

*   **2. Iterate from Right to Left (Finding the Pivot Point):**
    *   The main loop `for (int i = target.length() - 1; i >= 0; i--)` iterates from the last character of `target` backwards to the first character. This `i` represents the potential "pivot" index where we might change `target.charAt(i)` to a larger character.
    *   `int cur = target.charAt(i) - 'a';`: The numerical index (0-25) of the character at the current pivot position `i` in `target`.
    *   `cnt[cur]++;`: Before attempting to replace `target.charAt(i)`, we "release" this character back into our available pool. This means we're considering building a string that matches `target.substring(0, i)` as a prefix, but then at index `i`, we'll place a character *different* from `target.charAt(i)`. The character `target.charAt(i)` itself is now available to be used later in the string.
    *   **Validity Check (`ok`):** A flag `ok` is used to check if, with the current character pool (`cnt`), it's still possible to form the string. If any `cnt[x]` is negative, it means that `s` does not contain enough instances of character `x` to cover the characters needed for `target` (excluding `target.charAt(i)` and its suffix). If `ok` is `false`, this `i` cannot be a valid pivot, and we `continue` to the next `i` (moving left).

*   **3. Find the Smallest Replacement Character:**
    *   `int next = -1; for (int c = cur + 1; c < 26; c++) { if (cnt[c] > 0) { next = c; break; } }`: The code searches for the smallest character `next` (lexicographically, starting from `target.charAt(i) + 1`) that is currently available in our `cnt` pool. This `next` character will be placed at position `i`. We choose the smallest possible character `> target.charAt(i)` to ensure the overall resulting string is lexicographically minimal.
    *   If no such `next` character is found (`next == -1`), it means we cannot make the string greater than `target` at this position `i` by changing `target.charAt(i)` to a larger character. Thus, we `continue` to the next `i` (moving left).

*   **4. Construct the Result String:**
    *   If a suitable `next` character is found:
        *   `cnt[next]--;`: Decrement the count for `next` as it's now used at position `i`.
        *   `StringBuilder ans = new StringBuilder(target.substring(0, i));`: A `StringBuilder` is initialized with the prefix of `target` that remains unchanged (from index 0 to `i-1`).
        *   `ans.append((char) ('a' + next));`: The chosen replacement character `next` is appended at position `i`.
        *   `for (int c = 0; c < 26; c++) { while (cnt[c]-- > 0) { ans.append((char) ('a' + c)); } }`: All remaining characters in the `cnt` pool (which include `target.charAt(i)` if it wasn't equal to `next`, plus all other characters from `s` not used in the prefix) are appended to `ans` in lexicographical order. This ensures the suffix of the string is the smallest possible.
        *   `return ans.toString();`: The first valid string constructed this way (due to iterating `i` from right to left) will be the lexicographically smallest permutation of `s` that is greater than `target`.

*   **5. No Solution Found:**
    *   If the loop completes without returning a string, it means no such permutation could be found (all permutations of `s` are less than or equal to `target`). In this case, an empty string `""` is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(M * (N + M))
    *   The initial character counting (`s.toCharArray()` and `target.toCharArray()`) takes O(N + M) time, where `N` is `s.length()` and `M` is `target.length()`.
    *   The main loop iterates `M` times (from `target.length() - 1` down to `0`).
    *   Inside the loop:
        *   Operations on the `cnt` array (incrementing, checking `ok`, finding `next`) are constant time, O(26) = O(1), as the alphabet size is fixed.
        *   `target.substring(0, i)` creates a new string of length `i`, which takes O(i) time.
        *   Initializing `StringBuilder` with this substring takes another O(i) time to copy the characters.
        *   Appending the remaining `N - i - 1` characters (from the `cnt` array) to the `StringBuilder` takes O(N - i - 1) time in total.
    *   Therefore, each iteration of the main loop takes approximately O(i + N) time.
    *   Summing over all `M` iterations: `Sum_{i=0}^{M-1} (O(i) + O(N)) = O(M(M-1)/2 + M*N)`.
    *   This simplifies to a dominant time complexity of `O(M^2 + MN)`, or more generally, `O(M * (N + M))`.

-   **Space:** O(N + M)
    *   The `cnt` array uses O(26) space, which is constant O(1).
    *   The `StringBuilder ans` can store up to `N` characters (the length of `s`), leading to O(N) space.
    *   The `target.substring(0, i)` call creates temporary string objects, potentially taking up to O(M) space.
    *   Therefore, the total space complexity is O(N + M) to account for the result string and temporary string operations.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 2 ms |
| Memory | 44.7 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/)
- [View My Submission](https://leetcode.com/submissions/detail/2121830570/)
