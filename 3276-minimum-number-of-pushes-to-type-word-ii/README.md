# 3276. Minimum Number of Pushes to Type Word II

🟡 **Medium** · `Hash Table` `String` `Greedy` `Sorting` `Counting`

## Problem Summary
This problem involves calculating the minimum number of pushes required to type a given word on a specific keyboard layout, where each push can type a sequence of characters. The goal is to find an efficient way to determine the minimum pushes needed, considering the frequency of characters in the word. See the [full problem on LeetCode](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/).

## Approach & Implementation
The provided code uses a combination of the **Greedy** and **Counting** techniques to solve this problem. Here's a step-by-step breakdown of the approach:
* First, it creates a frequency array `freq` of size 26 to store the frequency of each character in the word. This is done by iterating through each character in the word and incrementing the corresponding index in the `freq` array.
* Next, it sorts the `freq` array in ascending order using the `Arrays.sort()` method. This is done to prioritize the characters with the lowest frequencies.
* Then, it initializes a variable `ans` to store the minimum number of pushes required.
* The code then iterates through the sorted `freq` array from the end (i.e., from the most frequent characters to the least frequent). For each character, it calculates the minimum number of pushes required to type all occurrences of that character. This is done by multiplying the frequency of the character by the number of pushes required to type a single sequence of characters containing that character. The number of pushes is calculated as `((25 - i) / 8 + 1)`, where `i` is the index of the character in the sorted `freq` array. This formula is based on the assumption that each push can type a sequence of 8 characters.
* Finally, the code returns the total minimum number of pushes required to type the entire word.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n log n) - This is because the code sorts the `freq` array of size 26, which takes O(n log n) time. The iteration through the word to calculate the frequency of characters takes O(n) time, but this is dominated by the sorting step.
- **Space:** O(1) - The space complexity is constant because the size of the `freq` array is fixed (26) and does not depend on the input size. The space required to store the input word and the output result is also constant.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 9 ms |
| Memory | 48.3 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2089172491/)
