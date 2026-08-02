# 113. Path Sum II

🟡 **Medium** · `Backtracking` `Tree` `Depth-First Search` `Binary Tree`

## Problem Summary
This problem involves finding all possible paths in a binary tree where the sum of the node values equals a given target sum. The goal is to return a list of lists, each representing a path from the root to a leaf node with the desired sum. See the [full problem on LeetCode](https://leetcode.com/problems/path-sum-ii/).

## Approach & Implementation
The provided code utilizes a Depth-First Search (DFS) approach with backtracking to solve this problem. The core pattern employed here is recursive exploration of the binary tree, where each node's value is added to the current path and checked if it matches the target sum when reaching a leaf node. Here's a step-by-step breakdown:

* The solution starts by initializing two key data structures: `allPaths` to store all valid paths and `currentPath` to keep track of the nodes visited in the current path.
* The `findPath` method is a recursive function that explores the tree. It first checks if the current node (`root`) is `null`, in which case it returns without adding anything to the paths.
* If the current node is not `null`, its value is added to `currentPath`. Then, it checks if the current node is a leaf node (`root.left == null && root.right == null`) and if its value equals the remaining `targetSum`. If both conditions are true, it adds a copy of `currentPath` to `allPaths`.
* If the current node is not a leaf node or its value does not match the `targetSum`, the function recursively calls itself on the left and right child nodes, subtracting the current node's value from `targetSum` to update the sum for the next level.
* After exploring both child nodes, the current node's value is removed from `currentPath` to backtrack and explore other branches. This ensures that `currentPath` only contains nodes relevant to the current path being explored.
* The main `pathSum` method initiates the DFS by calling `findPath` with the root node, the initial target sum, and the empty current path. It then returns `allPaths`, which contains all valid paths where the sum of node values equals the target sum.

## Complexity
> ⚠️ *These are AI-inferred estimates — verify independently.*
- **Time:** O(N^2) - This estimate arises because in the worst case, the algorithm might need to traverse every node in the tree (N nodes), and for each node, it might need to copy the current path to add it to `allPaths`, which takes O(N) time in the worst case (when the tree is highly unbalanced or essentially a linked list).
- **Space:** O(N) - The space complexity is primarily due to the recursive call stack and the storage needed for `allPaths` and `currentPath`. In the worst case, the recursive call stack can go as deep as N (the height of the tree), and `allPaths` can store up to N paths, each potentially of length N in an unbalanced tree. However, `currentPath` will only store a path of length up to N.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 45.3 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/path-sum-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2091511500/)
