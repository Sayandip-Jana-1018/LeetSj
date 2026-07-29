class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) freq[ch - 'a']++;

        StringBuilder left = new StringBuilder();
        String mid = "";

        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                if(freq[i] % 2 != 0) 
                mid = String.valueOf((char)(i + 'a'));
                for(int j=0; j<freq[i]/2; j++)
                left.append((char)(i + 'a'));
            }
        }
        return left.toString() + mid + left.reverse().toString();
    }
}