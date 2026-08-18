# 3705. Find the Largest Almost Missing Integer

🟢 **Easy** · `Array` `Hash Table`

## Problem Summary

The problem asks us to find the "largest almost missing integer" within a given array of integers, `A`. An integer `x` from `A` is considered "almost missing" based on a specific set of rules involving its frequency in the array, its position, and an additional integer parameter `k`.

Specifically, an element `A[i]` is defined as "almost missing" if:
1.  The parameter `k` is equal to the total number of elements in the array `A`. In this special case, every single element in `A` is considered "almost missing."
2.  Otherwise (if `k` is not equal to `A.length`), `A[i]` must meet two criteria simultaneously:
    *   `A[i]` appears exactly once in the array `A` (i.e., it is a unique element).
    *   Additionally, one of the following must be true: `k` is equal to 1, OR `A[i]` is the very first element of the array (at index 0), OR `A[i]` is the very last element of the array (at index `A.length - 1`).

The ultimate goal is to return the maximum value among all elements in `A` that satisfy these "almost missing" conditions. If no such integer is found according to these rules, the function should return -1.

See the [full problem on LeetCode](https://leetcode.com/problems/find-the-largest-almost-missing-integer/).

## Approach & Implementation

The provided solution uses a straightforward **frequency counting** and **conditional filtering** approach. It first determines the frequency of each number present in the input array `A` and then iterates through the array again to apply the specific "almost missing" criteria to each element, keeping track of the largest qualifying integer found.

Here's a detailed breakdown of the implementation:

*   **Step 1: Frequency Counting**
    *   An integer array `f` of size 51 (`new int[51]`) is initialized. This array acts as a frequency map, where `f[x]` will store the count of occurrences of the number `x` in the input array `A`. The size 51 suggests that the problem constraints expect elements `A[i]` to be non-negative integers up to 50.
    *   The code iterates through each element `x` in the input array `A` using an enhanced for-loop (`for (int x : A)`).
    *   For each `x`, `f[x]` is incremented. After this loop completes, the `f` array accurately holds the frequency of every number found in `A`.

*   **Step 2: Initialize Result and Array Length**
    *   A variable `res` is declared and initialized to `-1`. This variable will store the largest integer found that satisfies the "almost missing" conditions. It's initialized to -1 to correctly handle cases where no such integer exists.
    *   The length of the input array `A` is stored in the variable `n` (`n = A.length`) for convenient access in subsequent loops.

*   **Step 3: Iterate and Filter for "Almost Missing" Integers**
    *   The code then enters a standard `for` loop, iterating through the input array `A` from index `i = 0` up to `n - 1`. For each element `A[i]`, it evaluates whether it qualifies as an "almost missing" integer based on the problem's rules:
        *   **Primary Condition Check (`k == n`)**:
            *   It first checks if the parameter `k` is equal to the total number of elements `n`. If `k == n`, this means *all* elements in `A` are considered "almost missing" (as per rule 1). In this scenario, `A[i]` automatically qualifies.
        *   **Alternative Condition Check (`(f[A[i]] == 1 && (k == 1 || i == 0 || i == n - 1))`)**:
            *   If the primary condition (`k == n`) is false, the code proceeds to evaluate this alternative condition (as per rule 2).
            *   It first verifies if `f[A[i]] == 1`. This checks if the current element `A[i]` appears exactly once in the array, making it unique.
            *   If `A[i]` is unique, it then checks a nested sub-condition: `(k == 1 || i == 0 || i == n - 1)`. This means `A[i]` further qualifies if:
                *   `k` is equal to 1, OR
                *   `A[i]` is located at the first index (`i == 0`), OR
                *   `A[i]` is located at the last index (`i == n - 1`).
    *   **Update Result:** If `A[i]` satisfies *either* the primary condition or the entire alternative condition, it is considered an "almost missing" integer. The `res` variable is then updated using `Math.max(res, A[i])`, ensuring that `res` always stores the largest qualifying integer encountered so far.

*   **Step 4: Return Final Result**
    *   After the loop has finished iterating through all elements of `A`, the final value stored in `res` is returned. This value will be the largest "almost missing" integer found, or -1 if no such integer met the criteria.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

-   **Time:** O(N) - Where N is the number of elements in the input array `A`.
    *   The first loop iterates through all N elements of `A` to populate the frequency array, taking O(N) time.
    *   The second loop also iterates through all N elements of `A` to apply the conditional logic and find the maximum, taking O(N) time.
    *   The operations inside the loops (array access, comparisons, `Math.max`) are constant time.
    *   Therefore, the total time complexity is O(N) + O(N) = O(N).

-   **Space:** O(1) - The space complexity is constant.
    *   A fixed-size integer array `f` of size 51 is used to store frequencies. Since 51 is a constant, this auxiliary space does not grow with the input size N.
    *   Other variables (`res`, `n`, `i`, `x`) also use constant space.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 44.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/find-the-largest-almost-missing-integer/)
- [View My Submission](https://leetcode.com/submissions/detail/2111162030/)
