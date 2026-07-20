# 784. Insert into a Binary Search Tree

🟡 **Medium** · `Tree` `Binary Search Tree` `Binary Tree`

## Problem Summary
This problem requires inserting a given integer value into an existing Binary Search Tree (BST) while preserving its structural properties. The new node must be placed as a leaf node in the correct position, maintaining the BST invariant where all values in the left subtree are less than the node's value, and all values in the right subtree are greater than or equal. The function should return the root of the modified tree. See the [full problem on LeetCode](https://leetcode.com/problems/insert-into-a-binary-search-tree/).

## Approach
This solution employs a **recursive tree traversal** pattern. It navigates down the BST, comparing the value to insert (`val`) with the current node's value. If `val` is smaller, it recursively tries to insert into the left subtree; otherwise, it tries the right subtree. The base case is reached when an empty spot (a `null` node) is found, at which point a new `TreeNode` is created and returned, linking it back into the tree.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(H), where H is the height of the BST. In the worst case (a skewed tree), H can be O(N) where N is the number of nodes. For a balanced tree, it is O(log N).
- **Space:** O(H), for the recursion call stack. Similar to time, this can be O(N) in the worst case or O(log N) for a balanced tree.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 46.9 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/insert-into-a-binary-search-tree/)
- [View My Submission](https://leetcode.com/submissions/detail/2072613471/)
