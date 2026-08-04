# 114. Flatten Binary Tree to Linked List

🟡 **Medium** · `Linked List` `Stack` `Tree` `Depth-First Search` `Binary Tree`

## Problem Summary
The task involves transforming a binary tree into a linked list in-place, where the right child of each node becomes the next node in the sequence, effectively "flattening" the tree. This is achieved by rearranging the tree nodes while preserving the original values, resulting in a right-linked list. See the [full problem on LeetCode](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/).

## Approach & Implementation
The provided code utilizes a recursive approach, specifically a post-order traversal (right-root-left) to flatten the binary tree. This technique can be categorized under Depth-First Search (DFS), as it explores the tree depth-wise before backtracking. Here's a breakdown of the implementation:
* The solution starts by checking if the current node (`root`) is `null`. If so, it returns immediately, serving as the base case for the recursion.
* The function then recursively calls itself on the `right` child of the current node, followed by the `left` child. This post-order traversal ensures that the entire right subtree and left subtree are processed before the current node.
* After the recursive calls, the code sets the `right` child of the current node to the previously processed node (`prev`), effectively linking the current node to the previously visited node.
* It then sets the `left` child of the current node to `null`, removing the original left subtree link.
* Finally, the current node (`root`) is assigned to the `prev` variable, keeping track of the last visited node to establish the linked list connection.
This recursive process continues until all nodes in the tree have been visited and rearranged, resulting in a flattened linked list.

## Complexity
> ⚠️ *These are AI-inferenced estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear, where n represents the number of nodes in the binary tree. This is because each node is visited exactly once during the recursive post-order traversal.
- **Space:** O(n) - The space complexity is also linear due to the recursive call stack. In the worst-case scenario, the tree is completely unbalanced (essentially a linked list), and the recursive call stack can grow up to n levels deep. However, for a balanced tree, the space complexity would be O(log n) due to the reduced recursion depth.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 44.1 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
- [View My Submission](https://leetcode.com/submissions/detail/2092059217/)
