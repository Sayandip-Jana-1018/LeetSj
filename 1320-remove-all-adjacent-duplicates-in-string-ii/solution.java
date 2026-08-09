class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<int[]> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;

                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } 
            else {
                stack.push(new int[]{ch, 1});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] pair : stack) {
            char ch = (char) pair[0];
            int count = pair[1];

            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}