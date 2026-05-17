class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // Points to where the next non-zero element should go
        
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not zero, swap it with the element at insertPos
            if (nums[i] != 0) {
                // Perform the swap
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                
                // Move the insert position forward
                insertPos++;
            }
        }
    }
}