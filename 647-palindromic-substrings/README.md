# 647. Palindromic Substrings

🟡 **Medium** · `Two Pointers` `String` `Dynamic Programming`

## Problem Summary
This problem asks us to find and count all unique palindromic substrings within a given input string. A substring is a contiguous sequence of characters. A palindrome is a string that reads the same forwards and backwards (e.g., "racecar", "madam"). Importantly, single characters are considered palindromes. For example, in "abc", the palindromic substrings are "a", "b", "c" (count = 3). In "aaa", they are "a" (3 times), "aa" (2 times), "aaa" (1 time) (count = 6).

See the [full problem on LeetCode](https://leetcode.com/problems/palindromic-substrings/).

## Approach & Implementation

The core technique used here is the **"Expand From Center"** approach. The intuition is that every palindrome has a "center" from which it expands outwards. This center can either be a single character (for odd-length palindromes like "racecar", centered at 'e') or two adjacent characters (for even-length palindromes like "madam", centered between the two 'a's).

The algorithm systematically iterates through every possible character and every possible pair of adjacent characters in the string, treating each as a potential center, and then expands outwards to find all palindromes centered there.

Let's break down the implementation:

### `countSubstrings(String s)` method:

*   **Initialization:**
    *   `int count = 0;`: A variable `count` is initialized to zero. This will store the total number of palindromic substrings found.

*   **Iterating Through Potential Centers:**
    *   `for(int i=0; i<s.length(); i++)`: The main loop iterates through each character index `i` of the input string `s`. Each `i` represents a potential center for palindromes.
    *   **Handling Odd-Length Palindromes:**
        *   `count += expandFromCenter(s, i, i);`: For each index `i`, we consider it as the single center of an odd-length palindrome (e.g., `s[i-1]s[i]s[i+1]`). The `expandFromCenter` helper method is called with `left = i` and `right = i`. The number of palindromes found centered at `i` is added to the total `count`.
    *   **Handling Even-Length Palindromes:**
        *   `count += expandFromCenter(s, i, i+1);`: We also consider the pair of characters `s[i]` and `s[i+1]` as the center for an even-length palindrome (e.g., `s[i-1]s[i]s[i+1]s[i+2]`). The `expandFromCenter` helper method is called with `left = i` and `right = i+1`. The number of palindromes found centered between `i` and `i+1` is added to the total `count`.

*   **Returning the Result:**
    *   `return count;`: After iterating through all possible centers, the final `count` of all palindromic substrings is returned.

### `expandFromCenter(String s, int left, int right)` method:

*   **Purpose:** This private helper method takes the string `s` and two pointers, `left` and `right`, representing the initial "center" of a potential palindrome. It expands outwards from these pointers as long as the characters match and the pointers stay within string bounds, counting each valid palindrome it finds.

*   **Initialization:**
    *   `int count = 0;`: A local `count` is initialized to zero. This counts palindromes found *from this specific center*.

*   **Expanding Logic:**
    *   `while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))`: This `while` loop continues as long as three conditions are met:
        1.  `left >= 0`: The `left` pointer has not gone past the beginning of the string.
        2.  `right < s.length()`: The `right` pointer has not gone past the end of the string.
        3.  `s.charAt(left) == s.charAt(right)`: The characters at the current `left` and `right` positions are identical.
    *   **If Conditions Met:**
        *   `count++;`: If all conditions are true, it means `s.substring(left, right + 1)` is a valid palindrome. So, we increment the local `count`.
        *   `left--;`: Move the `left` pointer one step to the left (further outwards).
        *   `right++;`: Move the `right` pointer one step to the right (further outwards).
    *   The loop continues, checking if an even larger palindrome can be formed by expanding further.

*   **Returning Local Count:**
    *   `return count;`: Once the loop terminates (because a boundary was hit or characters didn't match), the method returns the number of palindromes found originating from the initial `left` and `right` center.

This "Expand From Center" approach ensures that every possible palindrome is identified exactly once.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

-   **Time:** O(N^2)
    -   The `countSubstrings` method has a loop that iterates `N` times, where `N` is the length of the string `s`.
    -   Inside this loop, the `expandFromCenter` method is called twice. In the worst case (e.g., a string like "aaaaa"), `expandFromCenter` might expand nearly `N/2` times in each direction, effectively performing `O(N)` character comparisons.
    -   Therefore, the total time complexity is `N * O(N)`, which simplifies to O(N^2).

-   **Space:** O(1)
    -   The algorithm only uses a few integer variables (`count`, `i`, `left`, `right`) to store its state. It does not use any additional data structures whose size grows with the input string length `N`.
    -   Hence, the space complexity is constant, O(1).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 5 ms |
| Memory | 43 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/palindromic-substrings/)
- [View My Submission](https://leetcode.com/submissions/detail/2076680820/)
