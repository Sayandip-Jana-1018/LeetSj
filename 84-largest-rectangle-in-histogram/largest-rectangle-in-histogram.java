import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        // Stack stores indices of the heights array
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        // Iterate up to n (inclusive) to handle remaining elements in the stack
        for (int i = 0; i <= n; i++) {
            // Use a dummy height of 0 at the end to flush out the stack
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // While stack is not empty and current height is less than the height at stack top
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // The bar at stack top is the bottleneck (minimum height for our current calculation)
                int h = heights[stack.pop()];
                
                // Calculate the width
                // Left boundary is the new top of the stack; Right boundary is the current index 'i'
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                // Update maxArea
                maxArea = Math.max(maxArea, h * w);
            }
            
            // Push the current index into the stack
            stack.push(i);
        }
        
        return maxArea;
    }
}