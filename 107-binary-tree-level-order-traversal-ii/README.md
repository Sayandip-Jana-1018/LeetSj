# 107. Binary Tree Level Order Traversal II

🟡 **Medium** · `Tree` `Breadth-First Search` `Binary Tree`

## Problem Summary

This problem asks us to perform a level-order traversal of a binary tree, but with a specific twist: the levels should be returned in reverse order, meaning the deepest level appears first, followed by the next deepest, and so on, until the root level appears last. For each level, the nodes should be listed from left to right. The output should be a list of lists of integers, where each inner list represents a single level's node values. See the [full problem on LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/).

## Approach & Implementation

The core algorithm used here is **Breadth-First Search (BFS)**. BFS is ideal for level-order traversals because it naturally explores the tree level by level. To achieve the "bottom-up" order, a slight modification is made to how each processed level is added to the final result list.

Here's a step-by-step breakdown of the implementation:

*   **Initialization:**
    *   `List<List<Integer>> list = new ArrayList<>();`: This `ArrayList` will store the final result, where each inner list will represent a level of the tree.
    *   `if (root == null) { return list; }`: Handles the edge case where the input tree is empty.
    *   `Queue<TreeNode> q = new LinkedList<>();`: A `Queue` is the fundamental data structure for BFS. It will hold tree nodes to be processed, ensuring that nodes at the same level are processed before any nodes at deeper levels.
    *   `q.offer(root);`: The root node is added to the queue to kickstart the BFS.

*   **Level-by-Level Traversal (BFS Loop):**
    *   `while (!q.isEmpty())`: The loop continues as long as there are nodes in the queue, meaning there are still levels to process.
    *   `int size = q.size();`: Before processing any nodes for the current level, we record the `size` of the queue. This is crucial because it tells us exactly how many nodes are at the *current* level. As we poll nodes and add their children, the queue's size will change, but `size` preserves the count for the current level.
    *   `List<Integer> temp = new ArrayList<>();`: A temporary `ArrayList` is created to store the values of all nodes belonging to the current level.

*   **Processing Current Level Nodes:**
    *   `for (int i = 0; i < size; i++)`: This loop iterates `size` times, processing each node that was initially in the queue at the start of the current level's processing.
        *   `TreeNode curr = q.poll();`: The node at the front of the queue is removed and stored as `curr`.
        *   `temp.add(curr.val);`: The value of the current node is added to the `temp` list for the current level.
        *   `if (curr.left != null) { q.offer(curr.left); }`: If the current node has a left child, it's added to the queue. This child will be processed in the *next* iteration of the main `while` loop (i.e., the next level).
        *   `if (curr.right != null) { q.offer(curr.right); }`: Similarly, if there's a right child, it's added to the queue for the next level's processing.

*   **Building the Bottom-Up Result:**
    *   `list.addFirst(temp);`: This is the key step that ensures the bottom-up order. Instead of adding `temp` to the end of `list` (which would result in top-down order), `addFirst()` prepends the current level's list (`temp`) to the beginning of the `list`. This means the first level processed (root) will be added last, and the last level processed (deepest) will be added first.
        *   *Note:* The `addFirst()` method for `ArrayList` was introduced in Java 21. If using an older Java version, one would typically use `list.add(0, temp)` (which has similar time complexity implications for `ArrayList`) or use a `LinkedList` for `list` instead of `ArrayList` to get `O(1)` `addFirst` performance. Given the provided code, it assumes a Java 21+ environment or a `LinkedList` implementation that supports `addFirst`.

*   **Return Result:**
    *   `return list;`: Once the `while` loop completes (meaning all nodes have been visited and all levels processed), the `list` containing all levels in bottom-up order is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*

-   **Time:** O(N + H^2)
    -   Where `N` is the total number of nodes in the binary tree and `H` is the height of the tree (number of levels).
    -   The BFS traversal itself visits each node exactly once, performing constant-time operations (enqueue, dequeue, adding to `temp` list). This contributes O(N) to the time complexity.
    -   The `list.addFirst(temp)` operation, when performed on a `java.util.ArrayList` (as declared), has a time complexity of O(k) where `k` is the current number of elements already in the `ArrayList`. This is because all existing elements need to be shifted to make space at the beginning. This operation is performed `H` times (once for each level). In the worst case, the sum of these shifts can be `1 + 2 + ... + (H-1)`, which simplifies to O(H^2).
    -   Therefore, the total time complexity is dominated by both the traversal and the list manipulation: O(N + H^2). In a skewed tree, `H` can be equal to `N`, making the worst-case time complexity O(N^2).
    -   *Alternative for O(N) time:* If `list` were a `LinkedList` (where `addFirst` is O(1)), or if all levels were added in normal order to an `ArrayList` and then `Collections.reverse(list)` was called once at the end (which takes O(H) time), the overall time complexity would be O(N).

-   **Space:** O(N)
    -   The `Queue` (`q`) can hold, in the worst case, all nodes at the widest level of the tree. For a complete binary tree, this is approximately N/2 nodes, leading to O(N) space.
    -   The `list` (`ArrayList` of `ArrayLists`) stores all node values from the tree. This also contributes O(N) space.
    -   Combining these, the total space complexity is O(N).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 44.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2110330548/)
