class Solution {
    public int minElement(int[] nums) {
        int min = 999999;
        for(int num : nums) {
            int sum = 0;
            while(num > 0) {
                int d = num % 10;
                sum += d;
                num /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}