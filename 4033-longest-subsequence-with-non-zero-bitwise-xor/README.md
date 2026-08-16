# 4033. Longest Subsequence With Non-Zero Bitwise XOR

🟡 **Medium** · `Array` `Bit Manipulation`

## Problem Summary
The problem involves finding the length of the longest subsequence in an array where the bitwise XOR of all elements in the subsequence is non-zero. The goal is to determine the maximum length of such a subsequence. The array may contain a mix of positive and non-positive integers, which affects the overall calculation. See the [full problem on LeetCode](https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/).

## Approach & Implementation
The approach used in the provided code is based on a simple iterative scan of the array, utilizing bitwise operations to track the XOR of all elements encountered so far. The core pattern here can be considered as a variant of the "Prefix XOR" technique, often used in problems involving bitwise operations. Here's a step-by-step breakdown:
* Initialize variables to track the total XOR (`tot`) and a flag (`nonZero`) to check if any non-zero element is present in the array.
* Iterate through each element `x` in the array:
  + Update the `nonZero` flag by performing a bitwise OR operation with the condition `x > 0`. This ensures that if any element in the array is greater than zero, `nonZero` will be set to `true`.
  + Update `tot` by performing a bitwise XOR operation with the current element `x`. This effectively calculates the XOR of all elements encountered so far.
* After iterating through all elements, check the value of `nonZero`. If it's `false`, it means all elements in the array are zero, so return 0 because there's no subsequence with a non-zero XOR.
* Finally, check the value of `tot`. If `tot` is 0, it means the XOR of all elements in the array is zero. In this case, the longest subsequence with a non-zero XOR would be the entire array minus one element (since including all elements would result in a zero XOR), so return `n - 1`. If `tot` is not zero, it means the XOR of all elements is already non-zero, so the longest subsequence is the entire array itself, and return `n`.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The algorithm iterates through the array once, where n is the number of elements in the array. Each operation within the loop (bitwise XOR and checking for non-zero elements) takes constant time.
- **Space:** O(1) - The space used does not grow with the size of the input array, as only a constant amount of space is used to store the variables `tot`, `n`, and `nonZero`, regardless of the array's size.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 2 ms |
| Memory | 133.8 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/)
- [View My Submission](https://leetcode.com/submissions/detail/2107452747/)
