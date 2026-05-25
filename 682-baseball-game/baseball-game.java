class Solution {
    public int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int index = 0; 
        
        for (String op : operations) {
            if (op.equals("+")) {
                stack[index] = stack[index - 1] + stack[index - 2];
                index++;
            } else if (op.equals("D")) {
                stack[index] = stack[index - 1] * 2;
                index++;
            } else if (op.equals("C")) {
                index--;
            } else {
                stack[index] = Integer.parseInt(op);
                index++;
            }
        }
        int totalSum = 0;
        for (int i = 0; i < index; i++) {
            totalSum += stack[i];
        }
        
        return totalSum;
    }
}