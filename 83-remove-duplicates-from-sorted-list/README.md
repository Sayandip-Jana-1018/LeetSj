# 83. Remove Duplicates from Sorted List

🟢 **Easy** · `Linked List`

## Problem Summary
This problem asks us to take a given **sorted singly linked list** and remove all duplicate nodes. The goal is to ensure that each unique value appears only once in the list, and the list remains sorted after the duplicates are removed. For example, if the input is `1 -> 1 -> 2 -> 3 -> 3`, the output should be `1 -> 2 -> 3`.

See the [full problem on LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list/).

## Approach & Implementation
The core pattern used here is an **iterative single-pointer traversal** of the linked list. Since the list is sorted, duplicate values will always be adjacent. This allows us to compare a node with its immediate successor to identify and remove duplicates efficiently without needing to look ahead further.

Here's a step-by-step breakdown of the provided code:

*   **Initialization:**
    *   `ListNode res = head;`
        *   A `ListNode` variable `res` (short for result) is initialized with the `head` of the input list. This is crucial because the `head` pointer itself will be used to traverse and modify the list. `res` stores the original starting point of the list so that it can be returned at the end, even after `head` has moved to the end.

*   **Traversal and Duplication Check Loop:**
    *   `while (head != null && head.next != null)`:
        *   The main loop continues as long as `head` is not null (meaning there are nodes to process) AND `head.next` is not null (meaning there's at least one subsequent node to compare `head` with). If `head.next` is null, `head` is the last node, and it cannot have a duplicate following it.

*   **Conditional Logic for Duplicates:**
    *   `if (head.val == head.next.val)`:
        *   **Condition Met (Duplicate Found):** If the value of the current node (`head.val`) is equal to the value of the next node (`head.next.val`), it means we've found a duplicate.
        *   `head.next = head.next.next;`: To remove the duplicate `head.next` node, we simply "skip over" it. We redirect the `next` pointer of the current `head` node to point to `head.next.next` (the node *after* the duplicate). Effectively, the duplicate node `head.next` is now bypassed and is no longer part of the list.
        *   **Important Note:** The `head` pointer *does not* advance in this `if` block. This is because after removing `head.next`, the *new* `head.next` might still have the same value as the current `head.val` (e.g., `1 -> 1 -> 1 -> 2`). We need to re-check the current `head` with its *new* next node.

    *   `else`:
        *   **Condition Not Met (No Duplicate):** If `head.val` is not equal to `head.next.val`, it means the current `head` node's value is unique relative to its immediate successor.
        *   `head = head.next;`: In this case, the current `head` node is confirmed to be unique (at least compared to its current next node). So, we move the `head` pointer to the next node (`head.next`) to continue the process down the list.

*   **Return Result:**
    *   `return res;`: Once the loop finishes, all duplicates have been handled. The `res` pointer, which has been pointing to the original head of the list throughout the process, is returned, providing the modified list.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N) - The algorithm iterates through the linked list once. In the worst case, every node is visited by the `head` pointer. Even when duplicates are removed, `head` eventually moves to the next unique element or the end of the list. Operations within the loop (comparisons, pointer reassignments) are constant time. `N` is the number of nodes in the linked list.
-   **Space:** O(1) - The algorithm uses a constant amount of extra space regardless of the input list size. It only requires a few pointers (`res`, `head`) to traverse and modify the list in place, without allocating any new nodes or auxiliary data structures.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 45.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
- [View My Submission](https://leetcode.com/submissions/detail/2122681088/)
