class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstColZero = false;

        // Step 1: Scan the matrix and mark the ledger (row 0 and col 0)
        for (int r = 0; r < m; r++) {
            // Check if the first column natively has a zero
            if (matrix[r][0] == 0) {
                firstColZero = true;
            }

            // Check the rest of the columns in row r
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0; // Mark this row in col 0
                    matrix[0][c] = 0; // Mark this col in row 0
                }
            }
        }

        // Step 2: Update the inner matrix (from 1 to m-1, 1 to n-1)
        // using the marks in row 0 and col 0
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Step 3: Zero out the first row if matrix[0][0] was marked
        if (matrix[0][0] == 0) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }

        // Step 4: Zero out the first column if firstColZero was flagged
        if (firstColZero) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}