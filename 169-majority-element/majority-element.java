class Solution {
    public int majorityElement(int[] nums) {
        int votes = 1;
        int candidate = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(votes == 0) {
                votes++;
                candidate = nums[i];
            } else if(candidate == nums[i]) votes++;
            else votes--;
        }
        return candidate;
    }
}