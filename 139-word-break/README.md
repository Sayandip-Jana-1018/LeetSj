# 139. Word Break

🟡 **Medium** · `Array` `Hash Table` `String` `Dynamic Programming` `Trie` `Memoization`

## Problem Summary

The "Word Break" problem asks us to determine if a given non-empty string `s` can be segmented into a space-separated sequence of one or more words from a provided dictionary `wordDict`. Words in the dictionary can be reused multiple times in the segmentation. For example, if `s = "leetcode"` and `wordDict = ["leet", "code"]`, the answer is `true` because "leetcode" can be segmented as "leet code".

See the [full problem on LeetCode](https://leetcode.com/problems/word-break/).

## Approach & Implementation

The provided solution utilizes a Dynamic Programming (DP) approach. The core idea is to build up the solution for the string `s` by checking if its prefixes can be segmented.

Here's a detailed breakdown:

1.  **Optimization Setup (Partial):**
    *   `Set<String> wordSet = new HashSet<>(wordDict);`
        *   The first step is to convert the `wordDict` list into a `HashSet`. This is a crucial optimization for dictionary lookups. While `List.contains()` can take `O(M)` time (where `M` is the number of words in the dictionary) in the worst case, `HashSet.contains()` provides average `O(1)` time complexity (or `O(L)` where `L` is the length of the string being hashed, for string operations).
        *   **Important Note:** Although `wordSet` is created, the provided code unfortunately still uses `wordDict.contains()` within the main loops. For optimal performance, `wordSet.contains()` should have been used instead of `wordDict.contains()`. We will analyze the complexity based on the code as written, and then mention the improvement.

2.  **Dynamic Programming Array Initialization:**
    *   `boolean[] dp = new boolean[s.length() + 1];`
        *   A boolean array `dp` is created. `dp[i]` will store `true` if the prefix of `s` of length `i` (i.e., `s.substring(0, i)`) can be segmented into words from the dictionary, and `false` otherwise.
    *   `dp[0] = true;`
        *   The base case: `dp[0]` is set to `true`. This signifies that an empty string (a prefix of length 0) can always be "segmented" (it requires no words). This base case is essential for the subsequent calculations to correctly determine segmentations for non-empty prefixes.

3.  **Iterating Through String Prefixes:**
    *   `for(int i=0; i<=s.length(); i++) { ... }`
        *   This outer loop iterates from `i = 0` to `s.length()`. `i` represents the current length of the prefix of `s` that we are trying to segment. For `dp[i]`, we are checking if the substring `s[0...i-1]` can be broken into dictionary words.

4.  **Checking All Possible Segmentation Points:**
    *   `for(int j=0; j<i; j++) { ... }`
        *   Inside the outer loop, this inner loop iterates from `j = 0` to `i-1`. `j` represents a potential "split point" for the current prefix `s[0...i-1]`.
        *   We are trying to find if `s[0...i-1]` can be segmented such that `s[0...j-1]` is a valid segmentation, and the remaining part `s[j...i-1]` is a valid dictionary word.

5.  **Core Dynamic Programming Logic:**
    *   `if(dp[j] && wordDict.contains(s.substring(j,i))) { ... }`
        *   This is the heart of the DP algorithm:
            *   `dp[j]`: Checks if the prefix `s[0...j-1]` (the part before the potential current word) is already known to be segmentable.
            *   `s.substring(j,i)`: Extracts the substring from index `j` (inclusive) to `i` (exclusive). This represents the potential "last word" of the `s[0...i-1]` prefix.
            *   `wordDict.contains(...)`: Checks if this extracted substring is present in the `wordDict`.
        *   If both `dp[j]` is `true` (meaning the prefix `s[0...j-1]` is segmentable) AND `s.substring(j,i)` is a valid word from the dictionary, then it means the prefix `s[0...i-1]` can also be segmented.

6.  **Updating DP Array and Optimization:**
    *   `dp[i] = true;`
        *   If a valid segmentation is found for the prefix of length `i`, we mark `dp[i]` as `true`.
    *   `break;`
        *   Once we find at least one way to segment the prefix `s[0...i-1]`, we don't need to check other `j` values for this `i`. We can `break` from the inner loop and move to the next `i`.

7.  **Final Result:**
    *   `return dp[s.length()];`
        *   After iterating through all prefixes, `dp[s.length()]` will hold `true` if the entire string `s` can be segmented, and `false` otherwise. This value is returned as the final answer.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

*   **Time:** O(N^3 * M)
    *   Let `N` be the length of the input string `s`.
    *   Let `M` be the number of words in `wordDict`.
    *   Let `L_avg` be the average length of a word in `wordDict`.
    *   The creation of `wordSet` takes `O(M * L_avg)` time.
    *   The outer loop runs `N` times (for `i`).
    *   The inner loop runs up to `N` times (for `j`).
    *   Inside the inner loop:
        *   `s.substring(j,i)` creates a new substring. The length of this substring can be up to `N`. This operation takes `O(substring_length)`, so up to `O(N)`.
        *   `wordDict.contains(...)`: Since `wordDict` is a `List`, `contains()` iterates through its `M` elements. For each element, it performs a string comparison which takes `O(substring_length)`. Therefore, this operation takes `O(M * substring_length)`, which can be up to `O(M * N)`.
    *   Combining these: `N (outer) * N (inner) * (N (substring creation) + M*N (List.contains))` results in `O(N^2 * (N + M*N)) = O(N^3 + N^3 * M)`. Since `M` can be large, this simplifies to **O(N^3 * M)**.

    *   **Improvement Note:** If `wordSet.contains()` were used instead of `wordDict.contains()`, the `contains` operation would take `O(substring_length)` on average (due to hashing and comparing the string). In that case, the complexity would be `O(M * L_avg + N^2 * (N + N)) = O(M * L_avg + N^3)`. This is the standard expected complexity for the DP solution to Word Break.

*   **Space:** O(N + M * L_avg)
    *   `dp` array: `O(N)` space for the boolean array of size `s.length() + 1`.
    *   `wordSet`: Stores all words from `wordDict`. In the worst case, this takes `O(M * L_avg)` space (number of words * average length).
    *   `s.substring(j,i)`: While temporary substrings are created, they don't add to the persistent space complexity beyond what's handled by garbage collection.
    *   Thus, the total space complexity is dominated by the `dp` array and the `wordSet`, resulting in **O(N + M * L_avg)**.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 10 ms |
| Memory | 46.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/word-break/)
- [View My Submission](https://leetcode.com/submissions/detail/2075241814/)
