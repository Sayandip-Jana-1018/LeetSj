# 4107. Find Missing Elements

🟢 **Easy** · `Array` `Hash Table` `Sorting`

## Problem Summary
The problem asks to identify missing integers within a given range of numbers in an array. The task involves finding all the integers that are not present in the array but fall within the range defined by the minimum and maximum values in the array. See the [full problem on LeetCode](https://leetcode.com/problems/find-missing-elements/).

## Approach & Implementation
The provided code utilizes a Hash Table approach, leveraging a boolean array to track visited numbers. Here's a step-by-step breakdown:
* Initialize a boolean array `visited` of size 101, assuming the input array contains integers between 0 and 100.
* Initialize two variables, `min` and `max`, to keep track of the minimum and maximum values encountered in the array, initially set to `Integer.MAX_VALUE` and `Integer.MIN_VALUE`, respectively.
* Iterate through the input array, updating `min` and `max` whenever a smaller or larger number is encountered, and mark the corresponding index in the `visited` array as `true`.
* Once the entire array is traversed, iterate from `min` to `max` and check the `visited` array for each index. If an index is `false`, it means the corresponding number is missing from the input array, so add it to the `result` list.
* Finally, return the `result` list containing all the missing numbers.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n + k) - where n is the number of elements in the input array and k is the range of numbers from min to max. This is because the code iterates through the input array once and then iterates from min to max to find missing numbers.
- **Space:** O(1) - although the code uses a boolean array of fixed size 101, which does not grow with the input size, making it constant space complexity in this specific case. However, if the range of input numbers was not limited, the space complexity would be O(k), where k is the range of numbers.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 2 ms |
| Memory | 46.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/find-missing-elements/)
- [View My Submission](https://leetcode.com/submissions/detail/2093752283/)
