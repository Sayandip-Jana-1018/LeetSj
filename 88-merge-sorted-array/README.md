# 88. Merge Sorted Array

🟢 **Easy** · `Array` `Two Pointers` `Sorting`

## Problem Summary
This problem asks us to merge two sorted integer arrays, `nums1` and `nums2`, into a single sorted array. The merged result must be stored back into `nums1`, which has enough pre-allocated space to accommodate all elements from both arrays. The initial `m` elements of `nums1` are valid, followed by `n` zeros (or empty space) where `nums2`'s elements should eventually reside. See the [full problem on LeetCode](https://leetcode.com/problems/merge-sorted-array/).

## Approach
This solution uses a straightforward "Copy and Sort" strategy. First, all elements from `nums2` are appended directly to the end of `nums1`, filling the available `n` empty slots. After this step, `nums1` contains all `m + n` elements from both original arrays, but they are not yet in sorted order. Finally, the entire `nums1` array is sorted using Java's built-in `Arrays.sort()` method, which efficiently arranges all elements into the desired merged and sorted sequence.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O((m+n) log(m+n)) - Dominated by the `Arrays.sort()` operation on `m+n` elements.
- **Space:** O(log(m+n)) - Due to the recursion stack used by Java's `Arrays.sort()` (Dual-Pivot Quicksort).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 4 ms |
| Memory | 43.6 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/merge-sorted-array/)
- [View My Submission](https://leetcode.com/submissions/detail/2072047632/)
