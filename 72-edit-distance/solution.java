class Solution {
    public int minDistance(String word1, String word2) {
        int row = word1.length();
        int col = word2.length();

        int[][] dp = new int[row+1][col+1];
        for(int r=0; r<=row; r++) {
            dp[r][0] = r;
        }
        for(int c=0; c<=col; c++) {
            dp[0][c] = c;
        }
        for(int r=1; r<=row; r++) {
            for(int c=1; c<=col; c++) {
                if(word1.charAt(r-1) == word2.charAt(c-1)) dp[r][c] = dp[r-1][c-1];
                else dp[r][c] = 1+Math.min(dp[r-1][c-1], Math.min(dp[r][c-1], dp[r-1][c]));
            }
        }
        return dp[row][col];
    }
}