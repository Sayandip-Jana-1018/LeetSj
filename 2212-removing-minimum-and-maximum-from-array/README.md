# 2212. Removing Minimum and Maximum From Array

🟡 **Medium** · `Array` `Greedy`

## Problem Summary
The problem asks us to find the minimum number of deletions required to remove both the minimum and maximum elements from a given array. We can delete elements from either the front of the array, the back of the array, or a combination of both (some from the front, some from the back). Each deletion operation removes one element. The goal is to achieve this removal with the fewest possible operations.
See the [full problem on LeetCode](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/).

## Approach & Implementation
The core idea behind the provided solution is to first locate the positions of the minimum and maximum elements in the array. Once their indices are known, we can evaluate three distinct strategies for removing them and then choose the one that requires the minimum number of deletions. This approach can be categorized as **Case Analysis / Greedy**.

Here's a detailed breakdown of the implementation:

*   **Handle Base Cases:**
    *   `int n=nums.length;` gets the length of the array.
    *   `if(n<=2) return n;` handles arrays with 0, 1, or 2 elements.
        *   If `n=0`, no deletions needed (min and max are already gone, or array is empty). This isn't strictly covered by `n<=2` if `n=0` is possible, but usually constraints mean `n>=1`. For `n=1`, the single element is both min and max, so 1 deletion is needed. For `n=2`, both elements are distinct (or identical), so 2 deletions are needed. This base case correctly returns `n` for these small scenarios.

*   **Find Minimum and Maximum Indices:**
    *   `int maxval=Integer.MIN_VALUE;`, `int minval=Integer.MAX_VALUE;` initialize variables to track the actual minimum and maximum values found so far.
    *   `int minInd=-1;`, `int maxInd=-1;` initialize variables to store the indices of the minimum and maximum elements.
    *   A `for` loop `for(int i=0;i<n;i++)` iterates through the array:
        *   `if(nums[i]<minval)`: If a new minimum value is found, `minval` is updated, and its index `i` is stored in `minInd`.
        *   `if(nums[i]>maxval)`: Similarly, if a new maximum value is found, `maxval` is updated, and its index `i` is stored in `maxInd`.
        *   *Note:* If there are duplicate minimum or maximum values, this logic will store the index of the *first* occurrence. This is sufficient because any instance of the minimum/maximum value serves the purpose.

*   **Normalize Indices:**
    *   `int a=Math.min(minInd,maxInd);` finds the index of the element that is *leftmost* on the array (either the min or max).
    *   `int b =Math.max(minInd,maxInd);` finds the index of the element that is *rightmost* on the array.
    *   These `a` and `b` variables simplify subsequent calculations by abstracting whether `minInd` or `maxInd` was smaller. `a` is always `min(minInd, maxInd)` and `b` is always `max(minInd, maxInd)`.

*   **Evaluate Three Deletion Strategies:**
    The problem allows us to delete from the front, back, or both. The code calculates the cost for these three options:

    1.  **Delete only from the front (`front`):**
        *   To remove both the element at index `a` and the element at index `b` by only deleting from the front, we must delete all elements from index 0 up to and including the element at index `b`.
        *   The number of deletions required is `b + 1`. (e.g., if `b=0`, 1 deletion; if `b=n-1`, `n` deletions).
        *   `int front=b+1;`

    2.  **Delete only from the back (`back`):**
        *   To remove both elements by only deleting from the back, we must delete all elements from index `a` up to and including the element at index `n-1`.
        *   The number of deletions required is `n - a`. (e.g., if `a=n-1`, 1 deletion; if `a=0`, `n` deletions).
        *   `int back=n-a;`

    3.  **Delete from both front and back (`both`):**
        *   To remove the leftmost target element (at index `a`) from the front and the rightmost target element (at index `b`) from the back, we would:
            *   Delete `a + 1` elements from the front (from index 0 up to `a`).
            *   Delete `n - b` elements from the back (from index `b` up to `n-1`).
        *   The total number of deletions is `(a + 1) + (n - b)`.
        *   `int both=(a+1)+(n-b);`

*   **Return Minimum Deletions:**
    *   `return Math.min(front,Math.min(back,both));` compares the costs of the three strategies and returns the smallest one.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N)
    *   The dominant operation is the single loop that iterates through the array `nums` once to find the minimum and maximum elements and their indices. This takes O(N) time, where N is the length of the array. All other operations (variable initializations, `Math.min`/`Math.max` calls) are constant time.
-   **Space:** O(1)
    *   The solution uses a fixed number of variables (`n`, `maxval`, `minval`, `minInd`, `maxInd`, `a`, `b`, `front`, `back`, `both`) regardless of the input array size. No auxiliary data structures proportional to `N` are created.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 2 ms |
| Memory | 86.9 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/removing-minimum-and-maximum-from-array/)
- [View My Submission](https://leetcode.com/submissions/detail/2124857962/)
