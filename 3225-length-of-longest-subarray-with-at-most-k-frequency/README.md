# 3225. Length of Longest Subarray With at Most K Frequency

🟡 **Medium** · `Array` `Hash Table` `Sliding Window`

## Problem Summary
This problem involves finding the maximum length of a subarray within a given array, with the constraint that no element in the subarray can appear more than a specified number of times. The goal is to identify the longest subarray that meets this frequency condition. See the [full problem on LeetCode](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/).

## Approach & Implementation
The approach used in the provided code employs the "Sliding Window" technique, a common pattern for solving array-based problems. The core idea is to maintain a window of elements and slide it over the array, adjusting the window boundaries based on certain conditions. Here's a step-by-step breakdown:
* Initialize a `HashMap` (freqMap) to store the frequency of each element within the current window.
* Use two pointers, `left` and `right`, to represent the boundaries of the sliding window. Initially, both pointers are at the start of the array.
* Iterate over the array using the `right` pointer. For each element, increment its frequency in the freqMap.
* Check if the frequency of the current element exceeds the specified limit `k`. If it does, enter a loop where you decrement the frequency of the element at the `left` pointer and move the `left` pointer to the right. This effectively shrinks the window from the left until the frequency condition is met.
* Update the maximum length of the subarray (`maxLen`) whenever the current window size (`right - left + 1`) exceeds the previous maximum.
* Repeat the process until the `right` pointer reaches the end of the array.

The logic behind this approach is to maintain a window where the frequency of each element does not exceed `k`. When this condition is violated, the window is adjusted by removing elements from the left, ensuring that the frequency constraint is always satisfied.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear because each element in the array is visited at most twice: once by the `right` pointer and once by the `left` pointer.
- **Space:** O(n) - The space complexity is also linear due to the use of a `HashMap` to store the frequency of elements. In the worst-case scenario, if all elements are unique, the size of the `HashMap` can grow up to the size of the input array.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 66 ms |
| Memory | 88.9 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/)
- [View My Submission](https://leetcode.com/submissions/detail/2103684262/)
