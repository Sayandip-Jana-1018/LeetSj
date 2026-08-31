# 2182. Find the Minimum and Maximum Number of Nodes Between Critical Points

🟡 **Medium** · `Linked List`

## Problem Summary
The problem asks us to traverse a given singly linked list and identify "critical points". A critical point is defined as a node whose value is strictly greater than both its immediate previous and immediate next nodes (a local maximum or "peak"), or strictly less than both its immediate previous and immediate next nodes (a local minimum or "valley"). Importantly, critical points can only exist for nodes that are not the first or last node in the list, as they require both a preceding and a succeeding node.

After finding all critical points, we need to calculate two values:
1.  The *minimum distance* between any two *adjacent* critical points.
2.  The *maximum distance* between the *first* and *last* critical points found.

If fewer than two critical points are found, it's impossible to form a pair, so we should return `[-1, -1]`.

See the [full problem on LeetCode](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/).

## Approach & Implementation

The core idea behind the provided solution is a **single-pass linked list traversal** using three pointers to efficiently identify critical points and track their positions. As critical points are found, the algorithm updates the minimum distance between *consecutive* critical points and implicitly prepares to calculate the maximum distance between the first and last.

Here's a step-by-step breakdown of the code:

1.  **Initialization**:
    *   `min = 100000`: This variable stores the minimum distance found between any two *adjacent* critical points. It's initialized to a large value, ensuring the first valid distance will always be smaller. The problem constraints indicate the list length can be up to `10^5`, so `100000` is a safe upper bound for `min`.
    *   `i = 1`: This variable keeps track of the 1-based index of the current node being examined. Node indexing often starts from 1 in competitive programming contexts.
    *   `first = 0`: This variable will store the index of the *first* critical point encountered. It's initialized to `0` to signify that no critical point has been found yet.
    *   `last = 0`: This variable will store the index of the *most recently found* critical point. It's also initialized to `0`.
    *   `ListNode prev = head, curr = head.next, nxt = head.next.next;`: Three pointers are initialized.
        *   `prev` points to the node `i-1`.
        *   `curr` points to the node `i`. This is the node we check if it's a critical point.
        *   `nxt` points to the node `i+1`.
        This setup ensures that when `curr` is examined, we always have access to its predecessor (`prev`) and successor (`nxt`), which are necessary to determine if `curr` is a critical point. The loop will naturally start checking from the second node (`curr` initialized to `head.next`), as the first and last nodes cannot be critical points.

2.  **`while (nxt != null)` Loop - Traversing and Finding Critical Points**:
    *   The loop continues as long as `nxt` is not `null`. This condition ensures `curr` always has a valid `nxt` node to compare with, and `prev` always has a valid `curr` node. Thus, `curr` will traverse from the second node up to the second-to-last node.
    *   **`if (isCrit(prev, curr, nxt))`**: Inside the loop, the `isCrit` helper function is called to check if the `curr` node is a critical point.
        *   **`isCrit(ListNode a, ListNode b, ListNode c)` Helper Function**:
            *   This function takes three `ListNode` arguments: `a` (previous), `b` (current), and `c` (next).
            *   It returns `true` if `b` is a local extremum:
                *   `(a.val < b.val && b.val > c.val)`: `b` is a peak (local maximum).
                *   `||` (OR)
                *   `(a.val > b.val && b.val < c.val)`: `b` is a valley (local minimum).
            *   Otherwise, it returns `false`.

    *   **Processing a Critical Point**: If `isCrit` returns `true`:
        *   **`if (first == 0) first = i;`**: If `first` is still `0`, it means this is the very first critical point found. We record its index in `first`.
        *   **`else min = Math.min(min, i - last);`**: If `first` is not `0`, it means we've already found at least one critical point before. We calculate the distance between the *current* critical point (`i`) and the `last` critical point found, and update `min` if this new distance is smaller. This correctly tracks the minimum distance between *adjacent* critical points.
        *   **`last = i;`**: Regardless of whether it's the first critical point or not, the current critical point's index (`i`) becomes the new `last` critical point index.

    *   **Advancing Pointers**: After checking `curr` and processing if it's a critical point:
        *   `prev = curr;`: The current node becomes the previous node for the next iteration.
        *   `curr = nxt;`: The next node becomes the current node for the next iteration.
        *   `nxt = nxt.next;`: The next node advances one step further.
        *   `i++;`: The node index is incremented.

3.  **After the Loop - Final Result Calculation**:
    *   **`if (first == last) return new int[]{-1, -1};`**: After the loop finishes, we check if `first` and `last` are equal. This condition covers two scenarios:
        *   No critical points were found (`first` and `last` both remain `0`).
        *   Only one critical point was found (`first` and `last` both hold that single critical point's index).
        In both cases, it's impossible to have two critical points to measure a distance between, so `[-1, -1]` is returned as per the problem statement.
    *   **`return new int[]{min, last - first};`**: If we have at least two critical points (`first != last`), we return an array containing:
        *   `min`: The minimum distance found between any two *adjacent* critical points.
        *   `last - first`: The maximum distance, which is simply the distance between the *first* critical point encountered and the *last* critical point encountered.

This approach efficiently finds all critical points in a single pass while simultaneously calculating the required minimum and maximum distances.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N) - The algorithm traverses the linked list exactly once. Each node (except the first two and last) is visited by the `curr` pointer, and for each such node, a constant amount of work (pointer updates, value comparisons, arithmetic operations) is performed. `N` is the number of nodes in the linked list.
-   **Space:** O(1) - The algorithm uses a fixed number of variables (`min`, `i`, `first`, `last`, `prev`, `curr`, `nxt`) regardless of the input list's size. No auxiliary data structures that scale with `N` are used.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 6 ms |
| Memory | 106.1 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/)
- [View My Submission](https://leetcode.com/submissions/detail/2125813345/)
