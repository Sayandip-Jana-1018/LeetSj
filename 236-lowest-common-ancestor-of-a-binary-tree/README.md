# 236. Lowest Common Ancestor of a Binary Tree

🟡 **Medium** · `Tree` `Depth-First Search` `Binary Tree`

## Problem Summary
This problem involves finding the lowest common ancestor of two nodes in a binary tree, which is the node farthest from the root that is an ancestor of both nodes. The goal is to design an algorithm that efficiently traverses the tree to identify this common ancestor. See the [full problem on LeetCode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/).

## Approach & Implementation
The approach used in the provided code employs a recursive Depth-First Search (DFS) technique to traverse the binary tree. The core pattern here is the use of recursion to explore all paths in the tree. Here's a step-by-step breakdown of how the code works:
* The function starts by checking if the `root` is `null`. If so, it returns `null` because there are no more nodes to explore.
* It then checks if the `root` node is either of the target nodes `p` or `q`. If it is, the function returns the `root` because it is the common ancestor for the current branch.
* The function recursively calls itself for the `left` and `right` subtrees of the `root` node, storing the results in `leftFlare` and `rightFlare`, respectively.
* If both `leftFlare` and `rightFlare` are not `null`, it means that `p` and `q` are located in different subtrees of the `root`. In this case, the `root` is the lowest common ancestor, so the function returns it.
* If only one of `leftFlare` or `rightFlare` is not `null`, it means that both `p` and `q` are located in the same subtree. The function returns the non-`null` value, which represents the subtree containing both `p` and `q`. This recursive process continues until it finds the lowest common ancestor.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(n) - The time complexity is linear because in the worst-case scenario, the algorithm visits each node in the binary tree once. This happens when the tree is skewed to one side, essentially becoming a linked list.
- **Space:** O(h) - The space complexity is related to the height of the tree because of the recursive call stack. In the worst case (a skewed tree), the height `h` equals the number of nodes `n`, making the space complexity O(n). However, for a balanced binary tree, `h = log(n)`, resulting in a space complexity of O(log n).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 15 ms |
| Memory | 69.7 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [View My Submission](https://leetcode.com/submissions/detail/2091705369/)
