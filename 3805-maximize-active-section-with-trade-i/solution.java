class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int initialOnes = 0;
        int maxGain = 0;
        int preZero = -1;
        
        int n = s.length();
        int i = 0;
        
        while (i < n) {
            int j = i;
            
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            int curLength = j - i;
            
            if (s.charAt(i) == '1') {
                initialOnes += curLength;
            } 
            else {
                if (preZero != -1) {
                    maxGain = Math.max(maxGain, preZero + curLength);
                }
                preZero = curLength; 
            }
            
            i = j;
        }
        
        return initialOnes + maxGain;
    }
}