# 107. Binary Tree Level Order Traversal II

🟡 **Medium** · `Tree` `Breadth-First Search` `Binary Tree`

## Problem Summary
The problem "Binary Tree Level Order Traversal II" asks us to traverse a given binary tree and return its node values grouped by level. However, unlike standard level order traversal, the output should list the levels in reverse order: the leaf nodes' level should come first, followed by the parent level, and so on, with the root node's level appearing last.

See the [full problem on LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/).

## Approach & Implementation
The core algorithm used here is **Breadth-First Search (BFS)**, which is ideal for traversing a tree level by level. The key modification for "Level Order Traversal II" (bottom-up) is how the levels are added to the final result list.

Here's a step-by-step breakdown of the implementation:

*   **Initialization:**
    *   `List<List<Integer>> list = new ArrayList<>();`: This `list` will store the final result, where each inner list represents a level of the tree.
    *   `if (root == null) { return list; }`: Handles the edge case where the input tree is empty. An empty list is returned.
    *   `Queue<TreeNode> q = new LinkedList<>();`: A `Queue` (specifically a `LinkedList` acting as a queue) is initialized. This is fundamental for BFS, as it ensures nodes are processed in a "first-in, first-out" manner, maintaining level order.
    *   `q.offer(root);`: The root node is added to the queue to kick-start the traversal.

*   **BFS Traversal Loop:**
    *   `while (!q.isEmpty())`: The main loop continues as long as there are nodes in the queue to process. Each iteration of this outer loop processes exactly one full level of the tree.
    *   `int size = q.size();`: Before processing the current level, its size is captured. This is crucial because new nodes (children of the current level's nodes) will be added to the queue during this iteration, and we only want to process the nodes that *were originally* in the queue for the current level.
    *   `List<Integer> temp = new ArrayList<>();`: A temporary list `temp` is created to hold the integer values of all nodes belonging to the current level being processed.

*   **Processing Current Level:**
    *   `for (int i = 0; i < size; i++)`: This inner loop iterates `size` times, effectively dequeuing and processing all nodes of the current level.
    *   `TreeNode curr = q.poll();`: The next node from the queue (which belongs to the current level) is retrieved and removed.
    *   `temp.add(curr.val);`: The value of the current node (`curr.val`) is added to the `temp` list.
    *   `if(curr.left != null){ q.offer(curr.left); }`: If the current node has a left child, that child is added to the queue. It will be processed in the *next* level.
    *   `if(curr.right != null){ q.offer(curr.right); }`: Similarly, if there's a right child, it's added to the queue for the next level.

*   **Adding Level to Result (Bottom-Up Logic):**
    *   `list.addFirst(temp);`: This is the key step for achieving the bottom-up order. Instead of `list.add(temp)` (which would append the current level to the end of the `list`, resulting in top-down order), `addFirst(temp)` inserts the `temp` list (representing the current level) at the *beginning* of the `list` of results.
        *   **Note:** In standard Java, `java.util.ArrayList` (which `list` is initialized as) does not have an `addFirst()` method. This method is part of `java.util.Deque` and is implemented by `java.util.LinkedList`. If this code compiled and ran as is, it implies that `list` was either intended to be a `LinkedList` from the start, or `list.add(0, temp)` was the intended operation for an `ArrayList` (which achieves the same front insertion conceptually, but with different performance characteristics for `ArrayList`).

*   **Return Value:**
    *   `return list;`: After all nodes have been processed and all levels have been added in reverse order, the final `list` is returned.

## Complexity (AI Estimate)
> ⚠️ *These are AI-inferred estimates — verify independently.*
-   **Time:** O(N)
    -   Each node in the tree is visited exactly once: it's enqueued and dequeued a single time. For each node, constant time operations are performed (adding its value to `temp`, checking for children, and enqueuing children).
    -   The operation `list.addFirst(temp)` is key. If `list` is (or behaves like) a `java.util.LinkedList`, `addFirst` takes O(1) time. If `list` were strictly an `ArrayList` and `add(0, temp)` was used, inserting at the beginning would require shifting all existing elements, leading to a worst-case O(H) cost per level insertion, where H is the current number of levels. Summing this up over all levels could lead to O(H^2) overall for the insertions. Given the code uses `addFirst` and successfully functions, we assume an efficient O(1) insertion at the front. Therefore, the dominant factor remains the traversal of all N nodes.
-   **Space:** O(N)
    -   **Queue:** In the worst case (e.g., a complete binary tree), the `Queue` can hold all nodes at the widest level, which is approximately N/2 nodes. This contributes O(N) to space complexity.
    -   **Result List:** The `list` stores all node values. This also contributes O(N) to space complexity, as it holds N integers in total.
    -   Combining these, the total space complexity is O(N).

## Performance (Measured on LeetCode)

| Metric | Result |
|--------|--------|
| Runtime | 1 ms |
| Memory | 44.4 MB |
| Language | java |

## Links

- [View Problem on LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
- [View My Submission](https://leetcode.com/submissions/detail/2110331041/)
