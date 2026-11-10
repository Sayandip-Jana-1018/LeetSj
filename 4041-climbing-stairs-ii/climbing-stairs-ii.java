class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0, b = 0, c = 0;
        for (int cost : costs) {
            int z = Math.min(Math.min(a + 9, b + 4), c + 1) + cost;
            a = b;
            b = c;
            c = z;
        }
        return c;
    }
}