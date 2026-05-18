import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        // Base case: if the array has 1 or fewer elements, no jumps are needed.
        if (n <= 1) return 0;

        // Step 1: Map each value to a list of its indices (Teleportation network)
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: Initialize BFS Queue and Visited array
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        int steps = 0;

        // Step 3: BFS Traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all nodes at the current step level
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                // If we reached the end, return the number of steps taken
                if (curr == n - 1) return steps;

                // Check 1: Teleportation (Jump to same value)
                if (graph.containsKey(arr[curr])) {
                    for (int next : graph.get(arr[curr])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                    // CRUCIAL OPTIMIZATION: Clear the list so we don't process this value group again
                    graph.remove(arr[curr]);
                }

                // Check 2: Walk Forward (i + 1)
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Check 3: Walk Backward (i - 1)
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }
            // Increment steps after finishing a whole level of BFS
            steps++;
        }
        
        return -1; // Should not be reached based on problem constraints
    }
}