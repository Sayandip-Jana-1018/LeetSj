# 739. Daily Temperatures

🟡 **Medium** · `Array` `Stack` `Monotonic Stack`

## Problem Summary
This problem involves analyzing a sequence of daily temperatures to determine the number of days until a warmer temperature is recorded. The goal is to create an array where each element represents the number of days until a higher temperature occurs. See the [full problem on LeetCode](https://leetcode.com/problems/daily-temperatures/).

## Approach & Implementation
The provided code utilizes a monotonic stack to efficiently solve the problem. The core pattern here is the "Monotonic Stack" technique, which involves maintaining a stack of indices of the temperature array in a way that the stack always remains sorted in a specific order (in this case, non-decreasing order of temperatures).

Here's a step-by-step breakdown:
* We initialize an empty stack `stack` to store indices of the temperature array and an array `answer` of the same length as the temperature array to store the result.
* We iterate through the temperature array. For each temperature at index `i`, we check if the stack is not empty and the current temperature is greater than the temperature at the index stored at the top of the stack.
* If the condition is met, we pop the index from the stack (let's call it `coldIndex`), calculate the difference between the current index `i` and `coldIndex`, and store this difference in the `answer` array at `coldIndex`. This effectively gives us the number of days until a warmer temperature is recorded for the temperature at `coldIndex`.
* After processing all indices that have a warmer temperature at the current index `i`, we push the current index `i` onto the stack.
* We continue this process until we have iterated through all temperatures, resulting in the `answer` array being populated with the number of days until a warmer temperature is recorded for each temperature.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear because we are potentially pushing and popping each index once from the stack, where n is the number of temperatures.
- **Space:** O(n) - The space complexity is also linear because in the worst-case scenario (when the temperatures are strictly decreasing), the stack could contain n indices at some point.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 62 ms |
| Memory | 107.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/daily-temperatures/)
- [View My Submission](https://leetcode.com/submissions/detail/2094164555/)
