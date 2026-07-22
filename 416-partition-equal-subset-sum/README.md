# 416. Partition Equal Subset Sum

🟡 **Medium** · `Array` `Dynamic Programming`

## Problem Summary
The problem asks us to determine if a given array of positive integers can be partitioned into two subsets such that the sum of elements in both subsets is equal. If such a partition is possible, we should return `true`; otherwise, `false`.

For example, if the input is `[1, 5, 11, 5]`, it can be partitioned into `[1, 5, 5]` (sum 11) and `[11]` (sum 11), so the answer is `true`.
A key insight is that if two subsets have equal sums, then each subset's sum must be exactly half of the total sum of all elements in the original array. Thus, the problem boils down to checking if there exists a subset whose elements sum up to exactly half of the total sum.

See the [full problem on LeetCode](https://leetcode.com/problems/partition-equal-subset-sum/).

## Approach & Implementation
The problem can be elegantly solved using dynamic programming, specifically a variation of the **Subset Sum Problem** or 0/1 Knapsack problem. We are looking for whether a specific `target` sum (which is `total_sum / 2`) can be achieved using a subset of the given numbers, where each number can be used at most once.

Here's a step-by-step breakdown of the provided code:

1.  **Calculate Total Sum and Handle Edge Case**:
    *   First, the code calculates the `sum` of all numbers in the input array `nums`.
    *   `for(int num : nums) sum += num;`
    *   If the `sum` is odd (`sum % 2 != 0`), it's impossible to partition it into two subsets with equal integer sums. In this case, the function immediately returns `false`.
    *   `if(sum % 2 != 0) return false;`

2.  **Determine Target Sum**:
    *   If the `sum` is even, the `target` sum for each subset is `sum / 2`. The problem now transforms into: "Can we find a subset of `nums` that sums exactly to `target`?"
    *   `target = sum / 2;`

3.  **Initialize DP Array**:
    *   A boolean array `dp` of size `target + 1` is created.
    *   `boolean[] dp = new boolean[target + 1];`
    *   `dp[i]` will store `true` if a sum `i` can be formed using a subset of numbers considered so far, and `false` otherwise.
    *   `dp[0]` is initialized to `true`. This is because a sum of `0` can always be formed by choosing no elements. This serves as our base case for building up larger sums.
    *   `dp[0] = true;`

4.  **Populate DP Array (Iterate through numbers and possible sums)**:
    *   The code iterates through each `num` in the `nums` array. This outer loop considers each number as a potential item to include in our subset.
    *   `for(int num : nums)`:
        *   For each `num`, an inner loop iterates *backwards* from `target` down to `num`.
        *   `for(int i=target; i>=num; i--)`:
            *   The backward iteration is crucial. It ensures that each number (`num`) is used at most once for forming any particular sum `i` within the current iteration of the outer loop. If we iterated forward, `dp[i - num]` might already have been updated using the *current* `num`, effectively allowing `num` to be used multiple times.
            *   The core dynamic programming transition is `dp[i] = dp[i] || dp[i - num];`. This line updates `dp[i]` based on two possibilities:
                *   `dp[i]` (on the right side): Represents whether a sum `i` could *already* be formed using numbers processed *before* the current `num`, or using previous combinations including the current `num` but resulting in `i`.
                *   `dp[i - num]`: Represents whether a sum `i - num` could be formed using numbers processed *before* the current `num`. If `dp[i - num]` is `true`, it means we can form the sum `i` by taking the current `num` and adding it to the subset that forms `i - num`.
                *   The `||` (OR) operator means `dp[i]` becomes `true` if *either* it was already possible to form sum `i` (without using the current `num` to directly contribute to this particular `i` in this step), *OR* it becomes possible by including the current `num` in a subset that previously summed to `i - num`.

5.  **Return Result**:
    *   After processing all numbers, `dp[target]` will contain `true` if a subset summing to `target` can be formed, and `false` otherwise. This value is returned as the final answer.
    *   `return dp[target];`

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N * Sum)
    *   Where `N` is the number of elements in the `nums` array, and `Sum` is the total sum of all elements in `nums`.
    *   The outer loop runs `N` times (once for each number).
    *   The inner loop runs `target` times in the worst case (from `target` down to `num`), and `target` is `Sum / 2`.
    *   Therefore, the total time complexity is roughly `N * (Sum / 2)`, which simplifies to O(N * Sum).
-   **Space:** O(Sum)
    *   The primary space consumption is the `dp` array, which has a size of `target + 1`.
    *   Since `target` is `Sum / 2`, the space complexity is O(Sum).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 31 ms |
| Memory | 43.7 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/partition-equal-subset-sum/)
- [View My Submission](https://leetcode.com/submissions/detail/2076719022/)
