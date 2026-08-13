# 61. Rotate List

🟡 **Medium** · `Linked List` `Two Pointers`

## Problem Summary
This problem involves rotating a singly-linked list to the right by a specified number of steps, essentially moving the last few nodes to the front of the list. The rotation should be performed in a way that handles cases where the number of steps is greater than the length of the list. See the [full problem on LeetCode](https://leetcode.com/problems/rotate-list/).

## Approach & Implementation
The solution employs a two-pointer technique along with a temporary circularization of the linked list to achieve the rotation efficiently. The main steps are:
* **Step 1: Find the length and tail of the list**
  + Traverse the linked list to find its length (`n`) and the last node (`tail`).
* **Step 2: Reduce the number of steps (`k`)**
  + Calculate the effective number of steps by taking the modulus of `k` with the length `n`, to handle cases where `k` is greater than `n`.
  + If the result is 0, return the original list as no rotation is needed.
* **Step 3: Make the list circular**
  + Set the `next` pointer of the `tail` node to the `head`, creating a circular linked list.
* **Step 4: Find the new tail**
  + Determine the new tail by moving `n - k` steps from the `head` in the circular list.
* **Step 5: Break the circle and find the new head**
  + The new head is the node after the new tail.
  + Break the circular list by setting the `next` pointer of the new tail to `null`.
The core pattern here is the use of two pointers (implicitly, as we're using the `head` and `tail` as references) in a circularized list to efficiently rotate the list without needing to move every node individually.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The solution iterates through the list once to find its length and tail, and then again to find the new tail after circularization. The number of steps (`k`) reduced by modulus operation ensures that the rotation does not exceed the list length, maintaining linear time complexity.
- **Space:** O(1) - The solution only uses a constant amount of space to store the references to the `head`, `tail`, `newTail`, and `newHead`, regardless of the input size. The circularization is done in-place without allocating additional space that scales with input size.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 43.9 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/rotate-list/)
- [View My Submission](https://leetcode.com/submissions/detail/2105298146/)
