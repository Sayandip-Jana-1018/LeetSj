class Solution {
    public int rob(int[] nums) {
        int[] totalLoot = new int[nums.length + 1];
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        totalLoot[0] = nums[0];
        totalLoot[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++) {
            totalLoot[i] = Math.max(totalLoot[i-1], totalLoot[i-2] + nums[i]);
        }
        return totalLoot[nums.length - 1];
    }
}