# 56. Merge Intervals

🟡 **Medium** · `Array` `Sorting`

## Problem Summary
This problem asks us to consolidate a given list of time intervals, merging any intervals that overlap with each other. The final output should be a new list containing only non-overlapping intervals, effectively simplifying the original set. See the [full problem on LeetCode](https://leetcode.com/problems/merge-intervals/).

## Approach
The solution employs a **greedy approach** by first sorting all intervals based on their start times. It then iterates through the sorted list, maintaining a `prev` interval that stores the currently merged range. If the current interval overlaps with `prev`, `prev`'s end time is extended to cover it; otherwise, `prev` is added to the result list, and the current interval becomes the new `prev`.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(N log N)
- **Space:** O(N)

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 7 ms |
| Memory | 49 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/merge-intervals/)
- [View My Submission](https://leetcode.com/submissions/detail/2074198704/)
