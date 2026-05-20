class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        if (n == 0) return result;

        result[0] = 0; // Binary of 0 has 0 1s

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) { // If the number is ODD
                result[i] = result[i / 2] + 1;
            } else {          // If the number is EVEN
                result[i] = result[i / 2]; 
            }
        }
        return result;
    }
}