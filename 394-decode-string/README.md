# 394. Decode String

🟡 **Medium** · `String` `Stack` `Recursion`

## Problem Summary
The problem involves decoding a given string that contains nested repetitions of substrings, where a substring can be repeated a specified number of times. The input string uses a specific syntax to denote repetitions, with numbers representing the repetition count and brackets enclosing the substring to be repeated. The task is to write a function that takes this encoded string as input and returns the fully decoded string. See the [full problem on LeetCode](https://leetcode.com/problems/decode-string/).

## Approach & Implementation
The approach used in the provided code employs a stack-based technique to handle the nested repetitions. The core pattern here can be identified as a "Stack-Based Parsing" mechanism. Here's a step-by-step breakdown of how it works:
* The algorithm uses two stacks: one for storing the repetition counts (`countStack`) and another for storing the intermediate strings (`stringStack`).
* It iterates through each character in the input string:
  + If the character is a digit, it accumulates the digit to form the repetition count `k`.
  + When it encounters an opening bracket `[`, it pushes the current repetition count onto `countStack` and the current string onto `stringStack`, then resets the repetition count `k` and the current string `current`.
  + When it encounters a closing bracket `]`, it pops the repetition count from `countStack` and the previous string from `stringStack`, repeats the current string `repeated` times, and appends it to the previous string, effectively decoding the substring.
  + If the character is a letter, it simply appends the character to the current string `current`.
* By using the stack to store and retrieve the necessary information (repetition counts and intermediate strings), the algorithm can efficiently handle nested repetitions and decode the input string correctly.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(N) - The algorithm iterates through the input string once, where N is the length of the input string. The operations within the loop (pushing and popping from stacks, appending to strings) take constant time, making the overall time complexity linear.
- **Space:** O(N) - In the worst-case scenario, the size of the stacks and the strings can grow up to the length of the input string. This happens when the input string consists of deeply nested repetitions or very long substrings, requiring the algorithm to store a significant amount of information on the stacks and in the strings.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 42.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/decode-string/)
- [View My Submission](https://leetcode.com/submissions/detail/2101227291/)
