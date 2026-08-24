# 49. Group Anagrams

🟡 **Medium** · `Array` `Hash Table` `String` `Sorting`

## Problem Summary
The problem asks us to group a given array of strings into sub-arrays where each sub-array contains strings that are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of another, using all the original letters exactly once. For example, "eat", "tea", and "ate" are anagrams and should be placed into the same group. The output should be a list of these groups. See the [full problem on LeetCode](https://leetcode.com/problems/group-anagrams/).

## Approach & Implementation

The core idea behind solving the Group Anagrams problem efficiently is to find a "canonical" representation for each string such that all anagrams share the same canonical form. A common and effective canonical form for anagrams is the string itself after its characters have been sorted alphabetically. For instance, "eat", "tea", and "ate" all become "aet" when their characters are sorted.

This approach leverages a **Hash Map for Grouping**, where the sorted string serves as the key, and the value is a list of all original strings that produce that sorted key.

Here's a detailed breakdown of the implementation:

*   **Initialization**:
    *   `Map<String, List<String>> ans = new HashMap<>();`
        *   A `HashMap` named `ans` is initialized. This map will store our results.
        *   The `key` of the map will be the *sorted* version of a string (e.g., "aet").
        *   The `value` associated with each key will be a `List<String>` containing all the original strings from the input array that are anagrams of each other (i.e., they produce the same sorted key).

*   **Iterating Through Strings**:
    *   `for (String s : strs)`: The code iterates through each string `s` in the input array `strs`.

*   **Generating the Canonical Key**:
    *   `char[] chars = s.toCharArray();`: The current string `s` is converted into a character array. This is necessary because strings in Java are immutable, and we need a mutable structure to sort its characters.
    *   `Arrays.sort(chars);`: The character array `chars` is sorted alphabetically. After this step, for strings like "eat", "tea", or "ate", `chars` will become `['a', 'e', 't']`. This sorted character array represents the canonical form for this group of anagrams.
    *   `String key = new String(chars);`: The sorted character array is then converted back into a `String`. This `key` ("aet" in our example) will uniquely identify an anagram group in our `HashMap`.

*   **Grouping Anagrams**:
    *   `if (!ans.containsKey(key))`: The code checks if the `HashMap` `ans` already contains the `key` (i.e., if we've encountered an anagram from this group before).
    *   `ans.put(key, new ArrayList<>());`: If the `key` is not yet in the map, it means this is the first time we've encountered an anagram from this particular group. A new empty `ArrayList<String>` is created and associated with this `key` in the map.
    *   `ans.get(key).add(s);`: Regardless of whether the `key` was newly added or already existed, the original string `s` (e.g., "eat") is added to the `List<String>` associated with its `key` ("aet"). This step effectively groups all anagrams together under their common sorted key.

*   **Final Result**:
    *   `return new ArrayList<>(ans.values());`: After iterating through all strings in the input array, the `ans` map will contain all the anagram groups. Each `value` in the map is a `List<String>` representing one such group. The `ans.values()` method returns a collection of all these lists. This collection is then converted into a new `ArrayList<List<String>>` to match the required return type.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

-   **Time:** O(N * K log K)
    *   `N` is the number of strings in the input array `strs`.
    *   `K` is the maximum length of a string in `strs`.
    *   The dominant operation within the loop is sorting the characters of each string, which takes O(K log K) for a string of length `K`. This operation is performed `N` times for each string.
    *   Other operations like converting to `char[]`, creating a new `String` from `char[]`, and `HashMap` operations (insertion, retrieval, `containsKey`) take O(K) in the average case (due to string hashing and comparison based on length) but can be O(K) in the worst-case for hashing.
    *   Thus, the total time complexity is dominated by the sorting step: N iterations * O(K log K) per iteration.

-   **Space:** O(N * K)
    *   `N` is the number of strings in `strs`.
    *   `K` is the maximum length of a string in `strs`.
    *   The `HashMap` `ans` stores up to `N` distinct keys (sorted strings), each of length up to `K`. This contributes O(N * K) space.
    *   The `HashMap` also stores all `N` original strings across its `List` values. In the worst case (e.g., all strings are unique and not anagrams), this also contributes O(N * K) space.
    *   Temporary `char[]` arrays take O(K) space at any given time, but this is less dominant than the overall map storage.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 6 ms |
| Memory | 49.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/group-anagrams/)
- [View My Submission](https://leetcode.com/submissions/detail/2118081183/)
