import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        
        // Remove redundant shifts
        k = k % total; 
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // 1. Find the 1D index of our CURRENT position in the new grid
                int newPos = i * n + j;
                
                // 2. Find the 1D index of where this element originally came from
                int oldPos = (newPos - k + total) % total;
                
                // 3. Convert that old 1D index back to 2D coordinates and fetch the value
                int oldR = oldPos / n;
                int oldC = oldPos % n;
                row.add(grid[oldR][oldC]);
            }
            result.add(row);
        }
        
        return result;
    }
}