# 45. Jump Game II

🟡 **Medium** · `Array` `Dynamic Programming` `Greedy`

## Problem Summary
This problem asks for the minimum number of jumps required to reach the last index of a given array, starting from the first index. Each element in the array represents the maximum jump length from that position. It's guaranteed that the last index can always be reached. See the [full problem on LeetCode](https://leetcode.com/problems/jump-game-ii/).

## Approach
The solution employs a **Greedy** strategy. It iteratively determines the furthest possible reach from all positions within the current jump's range (`maxReach`). When the current index `i` reaches the end of the current jump's range (`currEnd`), a jump is counted, and `currEnd` is updated to the newly discovered `maxReach` to define the next jump's range. This ensures that each jump extends as far as possible towards the target.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n)
- **Space:** O(1)

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 47.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/jump-game-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2074220962/)
