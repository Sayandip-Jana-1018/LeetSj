# 3275. Minimum Number of Pushes to Type Word I

🟢 **Easy** · `Math` `String` `Greedy`

## Problem Summary
The problem involves finding the minimum number of pushes required to type a given word on a specific device, considering the device's keyboard layout and the word's length. The goal is to determine the most efficient way to enter the word, taking into account the device's constraints. See the [full problem on LeetCode](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/).

## Approach & Implementation
The provided code uses a mathematical approach, leveraging bitwise operations to calculate the minimum number of pushes required. The core pattern employed in this solution is a greedy strategy, where the code aims to minimize the number of pushes by optimizing the use of the device's keyboard layout. Here's a step-by-step breakdown of the code:
* The code first calculates the quotient `q` by performing a right shift operation (`A.length() >> 3`) on the length of the input string `A`. This effectively divides the length by 8, as the right shift operation is equivalent to dividing by 2 raised to the power of the shift amount.
* Next, it calculates the remainder `r` by performing a bitwise AND operation (`A.length() & 7`) on the length of the input string `A`. This gives the remaining characters that are not accounted for by the quotient `q`.
* The code then returns the result of the expression `((q << 2) + r) * (q + 1)`, which represents the minimum number of pushes required. The left shift operation (`q << 2`) is equivalent to multiplying `q` by 4, and the addition of `r` accounts for the remaining characters.
* The multiplication by `(q + 1)` scales the result to account for the device's keyboard layout and the word's length.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(1) - The time complexity is constant because the code only performs a fixed number of bitwise operations and arithmetic calculations, regardless of the input size.
- **Space:** O(1) - The space complexity is constant because the code only uses a fixed amount of space to store the input string and the calculated variables, regardless of the input size.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 43 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/)
- [View My Submission](https://leetcode.com/submissions/detail/2087310244/)
