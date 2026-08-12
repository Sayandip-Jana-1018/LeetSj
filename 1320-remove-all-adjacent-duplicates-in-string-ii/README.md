# 1320. Remove All Adjacent Duplicates in String II

🟡 **Medium** · `String` `Stack`

## Problem Summary
This problem involves removing adjacent duplicates from a given string, with the condition that only sequences of a certain length are considered for removal. The goal is to process the input string and return the resulting string after all such duplicate sequences have been removed. See the [full problem on LeetCode](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/).

## Approach & Implementation
The approach used in the provided code employs a Stack data structure to keep track of characters and their counts. This can be broadly categorized under the "Stack-Based" pattern, leveraging the Last-In-First-Out (LIFO) principle to efficiently manage sequences of characters. Here's a step-by-step breakdown of how the code works:
* The code initializes an empty Stack to store arrays of integers, where each array contains two values: the ASCII value of a character and its count.
* It then iterates over each character in the input string. For each character:
  + If the Stack is not empty and the top of the Stack contains the current character, it increments the count of that character in the Stack.
  + If the count reaches the specified threshold (`k`), it removes the top element from the Stack, effectively removing the sequence of `k` identical characters.
  + If the Stack is empty or the top of the Stack does not contain the current character, it pushes a new array onto the Stack with the current character and a count of 1.
* After processing all characters, it constructs the resulting string by popping elements from the Stack and appending each character a number of times equal to its count.
* The final resulting string is returned as the output.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear because each character in the input string is processed exactly once. The Stack operations (push and pop) take constant time, and the iteration over the Stack to construct the result string takes time proportional to the number of elements in the Stack, which is at most n.
- **Space:** O(n) - The space complexity is also linear because in the worst-case scenario, every character in the input string could be pushed onto the Stack, requiring space proportional to n. The space used by the resulting string is also considered, which can be up to n characters.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 28 ms |
| Memory | 47 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2103708142/)
