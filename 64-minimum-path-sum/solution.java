class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int c = 1; c < cols; c++) {
            grid[0][c] += grid[0][c - 1];
        }
        
        for (int r = 1; r < rows; r++) {
            grid[r][0] += grid[r - 1][0];
        }
        
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
            }
        }
        
        return grid[rows - 1][cols - 1];
    }
}