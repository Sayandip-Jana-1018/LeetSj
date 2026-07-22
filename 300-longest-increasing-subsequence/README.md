# 300. Longest Increasing Subsequence

🟡 **Medium** · `Array` `Binary Search` `Dynamic Programming`

## Problem Summary
The "Longest Increasing Subsequence" problem challenges us to find the length of the longest possible subsequence from a given array of integers, such that all elements within that subsequence are arranged in strictly increasing order. A subsequence is formed by deleting zero or more elements from the original array without altering the relative order of the remaining elements.
See the [full problem on LeetCode](https://leetcode.com/problems/longest-increasing-subsequence/).

## Approach & Implementation
The provided solution utilizes a highly optimized **Dynamic Programming with Binary Search** technique, achieving an `O(N log N)` time complexity. This method doesn't explicitly construct the LIS itself but rather focuses on maintaining an array that helps determine its length efficiently.

The core idea relies on a greedy strategy: we maintain a `tails` array, where `tails[i]` stores the smallest ending element among all increasing subsequences of length `i+1` found so far.

Here's a detailed breakdown of the implementation:

*   **Initialization**:
    *   `int[] tails = new int[nums.length];`: An array named `tails` is created. This array will store the smallest tail values for increasing subsequences of various lengths. For example, `tails[0]` would store the smallest tail of an IS of length 1, `tails[1]` for length 2, and so on. Its maximum capacity is the length of the input array `nums`.
    *   `int size = 0;`: This variable keeps track of the current length of the longest increasing subsequence discovered. It also represents the number of valid elements currently stored in the `tails` array (i.e., `tails` is effectively of size `size`).

*   **Iterating Through Numbers**:
    *   `for(int x : nums)`: The algorithm processes each number `x` from the input array `nums` one by one. For each `x`, it determines where it fits into the `tails` array.

*   **Binary Search for Placement**:
    *   `int left = 0; int right = size;`: `left` and `right` pointers are initialized to define the search space for the binary search within the *effective* part of the `tails` array (from index `0` up to, but not including, `size`).
    *   `while(left < right)`: This loop performs a standard binary search. Its goal is to find the smallest element in `tails` that is greater than or equal to `x`. This is often referred to as finding the "insertion point" or "lower bound".
    *   `int mid = left + (right - left) / 2;`: Calculates the middle index to prevent potential integer overflow.
    *   `if(tails[mid] < x) left = mid + 1;`: If the element at `tails[mid]` is smaller than `x`, it means `x` can extend an increasing subsequence that ends at `tails[mid]`. To find the correct placement for `x`, we need to look in the right half of the current search space, hence `left` is moved to `mid + 1`.
    *   `else right = mid;`: If `tails[mid]` is greater than or equal to `x`, it means `x` could potentially replace `tails[mid]` (or an element to its left) to form an increasing subsequence of the same length but with a smaller or equal ending value. A smaller ending value is always more desirable as it allows more numbers to extend the subsequence later. So, we narrow the search space to the left half, including `mid`, by setting `right = mid`.

*   **Updating `tails` and `size`**:
    *   After the binary search loop terminates, `left` will point to the index where `x` should be placed. This `left` index signifies that `x` can be the new smallest ending element for an increasing subsequence of length `left + 1`.
    *   `tails[left] = x;`: The element `x` is placed at `tails[left]`.
        *   If `x` replaced an existing `tails[left]` (i.e., `left < size`), it means we found an increasing subsequence of length `left + 1` with a smaller (or equal) tail value (`x` instead of `tails[left]`), which is beneficial for future extensions. The overall `size` of the LIS remains unchanged.
        *   If `x` was placed at `tails[size]` (meaning `left == size`, indicating `x` was greater than all current tails), it means `x` successfully extended the longest increasing subsequence found so far, making it one element longer.
    *   `if(left == size) size++;`: If `x` was placed at the very end of the effective `tails` array (i.e., `left` was equal to the current `size`), it means we have found a new, longer increasing subsequence. Therefore, we increment `size`.

*   **Return Value**:
    *   `return size;`: Once all numbers in `nums` have been processed, the final value of `size` represents the length of the Longest Increasing Subsequence.

This approach guarantees that the `tails` array always remains sorted in increasing order, and `tails[i]` always holds the smallest ending value for an increasing subsequence of length `i+1`. This greedy choice (always picking the smallest possible tail) is optimal because it leaves more room for subsequent elements to extend the subsequence.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N log N) - The algorithm iterates through each of the `N` elements in the input array `nums`. For each element, a binary search is performed on the `tails` array. The `tails` array can grow up to a maximum size of `N`. A binary search operation on an array of size `K` takes `O(log K)` time. Thus, the total time complexity is `N` (for the loop) multiplied by `log N` (for the binary search), resulting in `O(N log N)`.
-   **Space:** O(N) - An auxiliary array `tails` is used to store the smallest tail elements. In the worst case, this array can store up to `N` elements (e.g., if the input array itself is sorted in increasing order). This leads to an `O(N)` space complexity.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 3 ms |
| Memory | 46.2 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/longest-increasing-subsequence/)
- [View My Submission](https://leetcode.com/submissions/detail/2076606449/)
