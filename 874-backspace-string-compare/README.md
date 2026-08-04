# 874. Backspace String Compare

🟢 **Easy** · `Two Pointers` `String` `Stack` `Simulation`

## Problem Summary
The problem involves comparing two strings that contain a special character representing a backspace operation. The goal is to determine if the resulting strings, after applying the backspace operations, are equal. This essentially means processing the strings to remove characters that are followed by a backspace. See the [full problem on LeetCode](https://leetcode.com/problems/backspace-string-compare/).

## Approach & Implementation
The approach taken in the provided code utilizes a stack data structure to simulate the backspace operation on each string. This can be identified as a "Stack Simulation" technique. Here's a step-by-step breakdown of how it works:
* The `buildString` method is used to process each input string (`s` and `t`) separately.
* A `Stack` of `Character` objects is created to store the characters of the string that are not deleted by the backspace operation.
* The code iterates over each character in the input string:
  + If the character is not a backspace (`'#'`), it is pushed onto the stack.
  + If the character is a backspace and the stack is not empty, the top character is popped from the stack, effectively deleting the last character that was added.
* After processing all characters in the string, the stack contains the characters of the string after all backspace operations have been applied.
* The `String.valueOf(stack)` expression converts the stack's elements into a string, which represents the final state of the string after backspace operations.
* The main `backspaceCompare` method simply compares the resulting strings from `s` and `t` using the `equals` method to determine if they are equal.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n + m) - Where n and m are the lengths of the two input strings, respectively. This is because each character in both strings is processed once during the iteration.
- **Space:** O(n + m) - This is because, in the worst-case scenario (no backspace operations), all characters from both strings could end up being stored in the stacks.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 2 ms |
| Memory | 43.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/backspace-string-compare/)
- [View My Submission](https://leetcode.com/submissions/detail/2094126845/)
