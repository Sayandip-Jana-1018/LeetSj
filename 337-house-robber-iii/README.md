# 337. House Robber III

🟡 **Medium** · `Dynamic Programming` `Tree` `Depth-First Search` `Binary Tree`

## Problem Summary
Imagine a neighborhood where houses are arranged in a binary tree structure. Each house contains a certain amount of money. Your goal is to rob as many houses as possible to maximize the total money stolen, with one crucial restriction: you cannot rob any two directly connected houses. This means if you choose to rob a house, you cannot rob its immediate parent or its immediate children. You need to determine the maximum amount of money you can rob without triggering any alarms.

See the [full problem on LeetCode](https://leetcode.com/problems/house-robber-iii/).

## Approach & Implementation

This problem can be effectively solved using a recursive Depth-First Search (DFS) approach combined with Dynamic Programming (Tree DP). For each node in the tree, we need to decide whether to rob it or skip it, and these decisions affect its children. To avoid recomputing subproblems and to efficiently pass information up the tree, our recursive function will return two values for each subtree:
1.  The maximum money that can be robbed from this subtree if the current node **is skipped**.
2.  The maximum money that can be robbed from this subtree if the current node **is robbed**.

This "bottom-up" approach, where results from children are used to compute results for the parent, is a common pattern for Tree DP.

The core pattern used is **Dynamic Programming on a Tree / Depth-First Search**.

Here's a step-by-step breakdown of the code:

*   **`rob(TreeNode root)` function:**
    *   This is the main entry point. It calls the helper function `robTree` on the `root` of the binary tree.
    *   `robTree(root)` will return an `int[]` array containing two values: `[money_if_root_skipped, money_if_root_robbed]`.
    *   The final answer is the maximum of these two possibilities, as the root can either be robbed or skipped to achieve the overall maximum. `return Math.max(result[0], result[1]);`

*   **`robTree(TreeNode node)` helper function:**
    *   This function performs a post-order DFS traversal, computing the two required values for each node.
    *   **Base Case:** `if(node == null) return new int[]{0, 0};`
        *   If the current `node` is `null` (e.g., beyond a leaf node), there's no money to be gained or lost. So, we return `[0, 0]` meaning 0 money whether we "skip" or "rob" this non-existent node.
    *   **Recursive Calls:**
        *   `int[] leftChild = robTree(node.left);`
        *   `int[] rightChild = robTree(node.right);`
        *   These lines recursively call `robTree` for the left and right children. `leftChild` will store `[money_if_left_skipped, money_if_left_robbed]` and similarly for `rightChild`.
    *   **Calculate `skip` (Max money if current `node` is skipped):**
        *   If the current `node` is skipped, we don't add `node.val` to our sum.
        *   However, we are then free to rob its children (`node.left` and `node.right`) or skip them. To maximize, for each child, we pick the best option available for its subtree: `Math.max(leftChild[0], leftChild[1])` for the left child's subtree, and `Math.max(rightChild[0], rightChild[1])` for the right child's subtree.
        *   `int skip = Math.max(leftChild[0], leftChild[1]) + Math.max(rightChild[0], rightChild[1]);`
    *   **Calculate `rob` (Max money if current `node` is robbed):**
        *   If the current `node` is robbed, we add `node.val` to our sum.
        *   Due to the problem constraint, if we rob the current `node`, we **cannot** rob its immediate children (`node.left` and `node.right`).
        *   Therefore, we must take the maximum money from their subtrees *assuming their roots are skipped*. This means we take `leftChild[0]` (max money from left subtree if `node.left` is skipped) and `rightChild[0]` (max money from right subtree if `node.right` is skipped).
        *   `int rob = node.val + leftChild[0] + rightChild[0];`
    *   **Return Result:**
        *   `return new int[]{skip, rob};`
        *   The function returns an array containing these two calculated values (`skip` and `rob`), which will then be used by the parent node in its own calculations.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N) - Each node in the binary tree is visited exactly once during the depth-first traversal. At each node, a constant number of operations (array creation, additions, `Math.max`) are performed. Thus, the time complexity scales linearly with the number of nodes (N) in the tree.
-   **Space:** O(H) - The space complexity is determined by the maximum depth of the recursion stack. In the worst-case scenario (a skewed tree, resembling a linked list), the height (H) can be equal to the number of nodes (N), leading to O(N) space. In the best case (a balanced tree), the height is O(log N), resulting in O(log N) space.

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 0 ms |
| Memory | 46.5 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/house-robber-iii/)
- [View My Submission](https://leetcode.com/submissions/detail/2074657400/)
