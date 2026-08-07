# 503. Next Greater Element II

🟡 **Medium** · `Array` `Stack` `Monotonic Stack`

## Problem Summary
The problem involves finding the next greater element for each element in a circular array, meaning that the array wraps around to the beginning after reaching the end. The goal is to identify the next element in the sequence that is greater than the current one, considering the array's circular nature. See the [full problem on LeetCode](https://leetcode.com/problems/next-greater-element-ii/).

## Approach & Implementation
The provided code utilizes a brute-force approach to solve the problem. The core pattern can be described as a modified version of the "Linear Search" technique, adapted for a circular array. Here's a step-by-step breakdown:
* Initialize an array `nge` of the same length as the input array `nums`, where `nge[i]` will store the next greater element for `nums[i]`. All elements in `nge` are initially set to -1.
* Iterate through each element `nums[i]` in the input array.
* For each `nums[i]`, perform a linear search in the circular array to find the next greater element:
  + Start from the next index `(i + 1) % n` and iterate up to `n` steps (wrapping around to the beginning of the array if necessary).
  + At each step, check if the current element `nums[idx]` is greater than `nums[i]`.
  + If a greater element is found, update `nge[i]` with the value of `nums[idx]` and break out of the inner loop.
* After checking all elements, return the `nge` array containing the next greater elements for each position in the input array.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n^2) - The time complexity is quadratic due to the nested loops: the outer loop iterates over each element in the array, and the inner loop performs a linear search in the circular array, resulting in a maximum of n iterations for each element.
- **Space:** O(n) - The space complexity is linear because the algorithm uses an additional array `nge` of the same length as the input array `nums` to store the next greater elements.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 92 ms |
| Memory | 47.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/next-greater-element-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2098002846/)
