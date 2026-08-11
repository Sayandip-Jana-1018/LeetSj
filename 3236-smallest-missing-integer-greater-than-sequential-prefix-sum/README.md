# 3236. Smallest Missing Integer Greater Than Sequential Prefix Sum

🟢 **Easy** · `Array` `Hash Table` `Sorting`

## Problem Summary
This problem involves finding the smallest missing integer greater than the sequential prefix sum of an array. The sequential prefix sum is calculated by summing consecutive integers in the array that form a sequence of incrementing numbers, starting from the first element. The goal is to identify the smallest integer that is greater than this sum and not present in the array. See the [full problem on LeetCode](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/).

## Approach & Implementation
The provided solution utilizes a combination of iterative sum calculation and a hash set to efficiently find the smallest missing integer. The core pattern can be described as a "Sequential Sum Calculation with Hash Set Lookup". The main steps are:
* Initialize a hash set `seen` to store unique elements from the input array `A`, allowing for constant-time lookups.
* Calculate the sequential prefix sum `sum` by iterating through the array and adding elements to the sum as long as they form a sequence of consecutive integers.
* Use a `while` loop to increment the `sum` until it finds a value that is not present in the `seen` hash set, indicating the smallest missing integer greater than the sequential prefix sum.
* The solution iterates through the array once to populate the hash set and calculate the initial sum, and then potentially increments the sum until it finds the missing integer, resulting in a relatively efficient solution.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear because the solution involves a single pass through the input array to populate the hash set and calculate the initial sum. The subsequent `while` loop increments the sum until it finds the missing integer, but in the worst-case scenario, this loop runs for a number of iterations proportional to the range of values in the input array, which can be bounded by the length of the array `n`.
- **Space:** O(n) - The space complexity is linear because the hash set `seen` stores at most `n` unique elements from the input array, where `n` is the length of the array.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 2 ms |
| Memory | 44.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/)
- [View My Submission](https://leetcode.com/submissions/detail/2102909865/)
