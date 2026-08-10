# 22. Generate Parentheses

🟡 **Medium** · `String` `Dynamic Programming` `Backtracking` `Bracket Sequences`

## Problem Summary
The problem asks to generate all possible combinations of well-formed parentheses for a given number of pairs. The goal is to produce a list of strings, where each string represents a valid sequence of parentheses. This involves ensuring that each open parenthesis can be matched with a corresponding close parenthesis, without violating the rules of nesting. See the [full problem on LeetCode](https://leetcode.com/problems/generate-parentheses/).

## Approach & Implementation
The provided code utilizes a backtracking approach to solve the problem. Backtracking is a core pattern used for solving problems that involve recursion and exploring all possible solutions. Here are the main steps involved in the implementation:
* The `generateParenthesis` method initializes an empty list to store the result and calls the `backtrack` method with an empty string builder, and counters for open and close parentheses.
* The `backtrack` method checks if the current length of the string builder is equal to the maximum allowed length (i.e., `2 * n`). If so, it adds the current string to the result list.
* If the number of open parentheses is less than the maximum allowed, the method appends an open parenthesis to the string builder, increments the open counter, and recursively calls itself.
* After exploring all possibilities with the current open parenthesis, the method backtracks by removing the last character from the string builder.
* If the number of close parentheses is less than the number of open parentheses, the method appends a close parenthesis to the string builder, increments the close counter, and recursively calls itself.
* The recursion continues until all possible combinations of well-formed parentheses are explored, at which point the method returns the result list.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(4^n / n^(3/2)) - This is because the number of possible combinations of well-formed parentheses for `n` pairs is given by the `n`-th Catalan number, which has a time complexity of O(4^n / n^(3/2)).
- **Space:** O(4^n / n^(3/2)) - The space complexity is also O(4^n / n^(3/2)) due to the storage required for the result list, which contains all possible combinations of well-formed parentheses. The maximum depth of the recursion call stack is O(n), but this is dominated by the space required for the result list.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 44.2 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/generate-parentheses/)
- [View My Submission](https://leetcode.com/submissions/detail/2101199162/)
