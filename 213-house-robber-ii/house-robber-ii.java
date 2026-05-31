class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];

        int[] skipFirst = new int[nums.length - 1];
        int[] skipLast = new int[nums.length - 1];

        for(int i=0; i<nums.length - 1; i++) {
            skipFirst[i] = nums[i+1];
            skipLast[i] = nums[i];
        }

        return Math.max(HouseRobber1(skipFirst), HouseRobber1(skipLast));
    }

    private int HouseRobber1(int[] rob) {
        int[] dp = new int[rob.length];

        if(rob.length < 2) return rob[0];
        
        dp[0] = rob[0];
        dp[1] = Math.max(rob[0], rob[1]);

        for(int i=2; i<rob.length; i++) {
            dp[i] = Math.max(dp[i - 2] + rob[i], dp[i - 1]);
        }
        return dp[rob.length - 1];
    }
}