# 3347. Distribute Elements Into Two Arrays I

🟢 **Easy** · `Array` `Simulation`

## Problem Summary
The problem asks us to distribute the elements of a given integer array `nums` into two new arrays, `arr1` and `arr2`, following specific rules. The first element of `nums` is always placed into `arr1`, and the second element into `arr2`. For all subsequent elements (starting from the third), the decision of which array to append to depends on a comparison: if the last element currently in `arr1` is strictly greater than the last element currently in `arr2`, the current element from `nums` is added to `arr1`; otherwise, it's added to `arr2`. Finally, the goal is to return a single array formed by concatenating all elements of `arr1` followed by all elements of `arr2`. See the [full problem on LeetCode](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/).

## Approach & Implementation
The approach taken by the provided code is a direct **simulation** of the distribution rules described in the problem. It iteratively builds the two arrays (`arr1` and `arr2`) by processing the input `nums` array element by element, following the given conditions.

Here's a detailed breakdown of the implementation:

*   **Initialization:**
    *   `int[] arr1 = new int[nums.length];` and `int[] arr2 = new int[nums.length];`
        *   Two integer arrays, `arr1` and `arr2`, are declared. They are initialized with a size equal to `nums.length`. This pre-allocates enough space to store all elements, ensuring no resizing is needed. While they might not be fully filled, this is an efficient way to manage capacity.
    *   `int size1 = 1;` and `int size2 = 1;`
        *   `size1` and `size2` are integer variables initialized to `1`. These act as logical "size" or "pointer" variables, tracking the number of elements currently stored in `arr1` and `arr2` respectively, and indicating the next available index for insertion.
    *   `arr1[0] = nums[0];`
    *   `arr2[0] = nums[1];`
        *   As per the problem's initial rules, the first element of `nums` (`nums[0]`) is placed into `arr1[0]`, and the second element (`nums[1]`) is placed into `arr2[0]`. `size1` and `size2` are already `1` to reflect that one element has been added to each.

*   **Distribution Loop:**
    *   `for (int i = 2; i < nums.length; i++) { ... }`
        *   A `for` loop iterates through the remaining elements of the `nums` array, starting from the third element (index `2`) up to the last element.
    *   `if (arr1[size1 - 1] > arr2[size2 - 1]) { ... } else { ... }`
        *   Inside the loop, this conditional statement implements the core distribution logic:
            *   It compares the *last* element currently present in `arr1` (`arr1[size1 - 1]`) with the *last* element currently present in `arr2` (`arr2[size2 - 1]`). Note that `size1 - 1` gives the index of the most recently added element.
            *   **If `arr1`'s last element is strictly greater:**
                *   `arr1[size1++] = nums[i];`
                *   The current element `nums[i]` is appended to `arr1` at the index indicated by `size1`. The `size1++` (post-increment) then updates `size1` to point to the next available slot, effectively increasing the count of elements in `arr1`.
            *   **Otherwise (if `arr1`'s last element is less than or equal to `arr2`'s last element):**
                *   `arr2[size2++] = nums[i];`
                *   The current element `nums[i]` is appended to `arr2`, and `size2` is similarly incremented.

*   **Constructing the Final Result:**
    *   `int[] result = new int[nums.length];`
        *   After the loop completes, all elements from `nums` have been distributed into `arr1` and `arr2`. A new `result` array of size `nums.length` is created to hold the final concatenated output.
    *   `System.arraycopy(arr1, 0, result, 0, size1);`
        *   This line efficiently copies all the elements from the *filled part* of `arr1` (from index `0` up to `size1 - 1`) into the `result` array, starting at `result[0]`. The `size1` argument ensures only the actual elements are copied, not the entire pre-allocated array.
    *   `System.arraycopy(arr2, 0, result, size1, size2);`
        *   This line then copies all the elements from the *filled part* of `arr2` (from index `0` up to `size2 - 1`) into the `result` array. The copying starts at `result[size1]`, effectively appending `arr2` immediately after the elements copied from `arr1`.
    *   `return result;`
        *   Finally, the `result` array, containing `arr1` concatenated with `arr2`, is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N)
    *   The primary operations involve iterating through the `nums` array once in a `for` loop, which takes O(N) time.
    *   The initial assignments and the final `System.arraycopy` operations also take linear time, proportional to the number of elements being processed or copied (which is at most N).
    *   All these steps are linearly dependent on the input size `N`, making the overall time complexity O(N).
-   **Space:** O(N)
    *   Two auxiliary arrays, `arr1` and `arr2`, are created, each with a potential capacity of N elements.
    *   A final `result` array of size N is also created.
    *   Therefore, the memory usage scales linearly with the input size `N`, resulting in an O(N) space complexity.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 46.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/distribute-elements-into-two-arrays-i/)
- [View My Submission](https://leetcode.com/submissions/detail/2113902496/)
