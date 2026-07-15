class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        if(color == old) return image;
        dfs(image,sr,sc,old,color);
        return image;
    }
    public void dfs(int[][] image, int i, int j, int old, int color) {
        if(i<0 || j<0 || j>=image[0].length || i>=image.length || image[i][j] != old) 
            return;
        image[i][j] = color;
        dfs(image, i+1, j, old, color);
        dfs(image, i-1, j, old, color);
        dfs(image, i, j+1, old, color);
        dfs(image, i, j-1, old, color);
    }
}