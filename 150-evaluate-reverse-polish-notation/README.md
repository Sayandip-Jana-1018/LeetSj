# 150. Evaluate Reverse Polish Notation

🟡 **Medium** · `Array` `Math` `Stack`

## Problem Summary
The problem asks to evaluate the value of an arithmetic expression given in Reverse Polish Notation (RPN), where operators follow their operands. The goal is to write a function that takes an array of strings representing the RPN expression and returns the result of the evaluated expression. See the [full problem on LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/).

## Approach & Implementation
The approach used in the provided code is based on the Stack data structure pattern. Here are the main steps:
* Initialize an empty stack to store the operands.
* Iterate through each token in the input array:
  + If the token is an operator (+, -, \*, /), pop the required number of operands from the stack, perform the operation, and push the result back onto the stack.
  + If the token is an operand, parse it to an integer and push it onto the stack.
* After iterating through all tokens, the stack should contain a single element, which is the result of the evaluated expression.
The code uses a simple and efficient approach to evaluate the RPN expression by leveraging the LIFO (Last-In-First-Out) nature of the stack. The key insight is that in RPN, operators always follow their operands, so when an operator is encountered, the required operands are already on the stack.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear because the code iterates through the input array once, where n is the number of tokens in the input array. Each operation (push, pop, and arithmetic operations) takes constant time.
- **Space:** O(n) - The space complexity is also linear because in the worst case, the stack can grow up to the size of the input array, which occurs when the input array contains only operands.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 6 ms |
| Memory | 45.3 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
- [View My Submission](https://leetcode.com/submissions/detail/2098906169/)
