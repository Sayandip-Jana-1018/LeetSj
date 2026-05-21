import java.util.HashSet;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        
        // Step 1: Store all possible prefixes of numbers in arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10; // Mathematically strip the last digit to get the next prefix
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check prefixes of numbers in arr2 against the set
        for (int num : arr2) {
            while (num > 0) {
                // If we find a match, it's the longest for this 'num' because we check top-down
                if (prefixes.contains(num)) {
                    int currentLength = String.valueOf(num).length();
                    maxLength = Math.max(maxLength, currentLength);
                    break; // No need to check shorter prefixes for this number
                }
                num /= 10;
            }
        }
        
        return maxLength;
    }
}