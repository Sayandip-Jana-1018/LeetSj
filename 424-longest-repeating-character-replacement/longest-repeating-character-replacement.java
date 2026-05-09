class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0; // Frequency of the most frequent character in the current window
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the frequency map
            count[s.charAt(right) - 'A']++;
            
            // Update maxCount with the highest frequency found so far in the window
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // If (window size - maxCount) > k, we have too many replacements to make
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the global maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}  