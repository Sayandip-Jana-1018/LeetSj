# 1320. Remove All Adjacent Duplicates in String II

🟡 **Medium** · `String` `Stack`

## Problem Summary
The problem involves removing all adjacent duplicates in a string, but with a twist: only sequences of exactly k identical characters are considered duplicates and should be removed. The goal is to return the resulting string after all such duplicates have been removed. See the [full problem on LeetCode](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/).

## Approach & Implementation
The approach used in the provided code employs a Stack data structure to keep track of characters and their counts. This can be conceptualized as a variant of the "Stack" pattern, where we push and pop elements based on specific conditions. Here's a step-by-step breakdown of how the code works:
* We initialize an empty stack to store arrays of integers, where each array represents a character and its count.
* We iterate through each character in the input string:
  + If the stack is not empty and the top of the stack contains the current character, we increment the count of that character in the stack.
  + If the count reaches k, we remove the top element from the stack (effectively removing k adjacent duplicates).
  + If the stack is empty or the top of the stack does not contain the current character, we push a new array onto the stack with the current character and a count of 1.
* After iterating through all characters, we use a StringBuilder to construct the resulting string:
  + We iterate through each array in the stack, appending the character to the StringBuilder a number of times equal to its count.
* The final string, with all adjacent duplicates of length k removed, is then returned.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear because we make a single pass through the input string, performing constant-time operations for each character (pushing and popping from the stack, and appending to the StringBuilder).
- **Space:** O(n) - The space complexity is also linear because, in the worst case, we might need to store every character from the input string in the stack (if no duplicates of length k are found), and then again in the StringBuilder when constructing the output string.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 27 ms |
| Memory | 47.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2100321290/)
