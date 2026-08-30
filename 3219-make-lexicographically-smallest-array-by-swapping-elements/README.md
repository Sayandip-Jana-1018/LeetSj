# 3219. Make Lexicographically Smallest Array by Swapping Elements

🟡 **Medium** · `Array` `Union-Find` `Sorting`

Here's a detailed documentation of the provided LeetCode solution.

---

## Problem Summary
The problem asks us to transform a given array `A` into its lexicographically smallest possible configuration. We are allowed to swap any two elements `A[i]` and `A[j]` if the absolute difference between their values, `|A[i] - A[j]|`, is less than or equal to a given `limit`. This swap condition implies that if element `X` can be swapped with `Y`, and `Y` can be swapped with `Z`, then `X`, `Y`, and `Z` are effectively "connected" and can be rearranged among their original positions to achieve the lexicographically smallest order. The goal is to return the modified array. See the [full problem on LeetCode](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/).

## Approach & Implementation

The core idea behind this solution is to identify "swappable groups" of elements and then, for each original position in the array, place the smallest available element from its corresponding swappable group. This can be categorized as a **Greedy Grouping and Reconstruction** approach.

Here's a step-by-step breakdown of the implementation:

*   **Step 1: Sort a Copy of the Array to Identify Swappable Groups**
    *   `int[] srt = A.clone(); Arrays.sort(srt);`
        *   A copy of the input array `A` is created and stored in `srt`.
        *   `srt` is then sorted in ascending order. This sorted array is crucial because it allows us to easily identify elements that can form a "chain" of swappability. If `x` and `y` are two numbers, and `|x - y| <= limit`, they are directly swappable. If `x <-> y` and `y <-> z`, then `x`, `y`, and `z` are all part of the same connected component and can be freely exchanged amongst their original positions. By sorting, if `srt[i] - srt[i-1] <= limit`, it means `srt[i]` and `srt[i-1]` are part of the same potential swappable group.

*   **Step 2: Group Elements Based on the `limit` Condition**
    *   `List<List<Integer>> grps = new ArrayList<>();`
        *   This `List` of `List`s will store our identified swappable groups. Each inner `List` will contain elements that belong to the same group, and these inner lists will inherently be sorted because they are populated from `srt`.
    *   `Map<Integer, Integer> map = new HashMap<>();`
        *   This `Map` is used to quickly find which group an element (from the original array `A`) belongs to. The key will be the element's value, and the value will be its group ID (an index into `grps`).
    *   `int id = -1;`
        *   `id` serves as a counter for the current group ID.
    *   The code then iterates through the sorted array `srt`:
        *   `for (int i = 0; i < srt.length; i++) { ... }`
        *   `if (i == 0 || srt[i] - srt[i - 1] > limit)`: This is the critical condition for forming new groups.
            *   If it's the very first element (`i == 0`), a new group always starts.
            *   Otherwise, if the difference between the current sorted element `srt[i]` and the previous sorted element `srt[i-1]` is *greater than* `limit`, it means `srt[i]` cannot be directly swapped with `srt[i-1]`. This breaks the chain of swappability, indicating that `srt[i]` must belong to a *new* swappable group.
            *   When a new group is started, a new `ArrayList` is added to `grps`, and the `id` is incremented.
        *   `grps.get(id).add(srt[i]);`: The current sorted element `srt[i]` is added to the current group.
        *   `map.put(srt[i], id);`: The element `srt[i]` is mapped to its `id`. Note that if there are duplicate elements, the map will store the group ID for the last encountered instance. This is fine because all instances of a duplicate value will necessarily fall into the same swappable group.

*   **Step 3: Reconstruct the Array Greedily**
    *   `int[] idx = new int[grps.size()];`
        *   This array `idx` acts as a pointer for each group. `idx[k]` will store the index of the next smallest *unused* element in `grps.get(k)`. Since `grps.get(k)` is already sorted, `grps.get(k).get(idx[k])` will always yield the smallest available element from that group.
    *   `for (int i = 0; i < A.length; i++) { ... }`
        *   The code iterates through the *original* array `A`'s indices `i`.
        *   `int cur = map.get(A[i]);`: For the element `A[i]` (at its original position), we find out which swappable group it belongs to using the `map`. `cur` is the group ID.
        *   `A[i] = grps.get(cur).get(idx[cur]);`: We replace `A[i]` with the *smallest available* element from its group (`grps.get(cur)`). This is the greedy step: to make the array lexicographically smallest, the earliest possible positions should get the smallest possible values they are allowed to receive. Since `A[i]` originally held an element from `cur`'s group, this position `i` can now be filled by any element from `cur`'s group. We pick the smallest one.
        *   `idx[cur]++;`: We increment the pointer for `cur`'s group, marking that the element has been used.

*   **Step 4: Return the Modified Array**
    *   `return A;`
        *   The `A` array, now filled with elements in the lexicographically smallest configuration, is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

*   **Time:** O(N log N)
    *   Cloning the array `A` takes O(N).
    *   Sorting the cloned array `srt` takes O(N log N).
    *   The first loop to create `grps` and `map` iterates N times. Inside the loop, operations like `add`, `get`, `put` are typically O(1) on average for `ArrayList` and `HashMap`. So, this step takes O(N).
    *   The second loop to reconstruct array `A` also iterates N times. Operations inside are O(1) on average. So, this step takes O(N).
    *   The dominant operation is sorting, leading to an overall time complexity of O(N log N).

*   **Space:** O(N)
    *   `srt`: O(N) for storing the cloned and sorted array.
    *   `grps`: Stores all N elements of the array, distributed among various lists. The total space occupied by elements is O(N).
    *   `map`: Stores N entries (element value to group ID). In the worst case, all values are distinct, requiring O(N) space.
    *   `idx`: Stores `grps.size()` integers. In the worst case, each element forms its own group, so `grps.size()` can be N, requiring O(N) space.
    *   Overall, the space complexity is O(N).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 69 ms |
| Memory | 209.9 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/)
- [View My Submission](https://leetcode.com/submissions/detail/2123588455/)
