class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid : asteroids) {
            boolean survived = true;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if(stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                }
                else if (stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                    survived = false;
                }
                else survived = false;
                break;
            }
            if(survived) stack.push(asteroid);
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1; i>=0; i--)
            result[i] = stack.pop();
        return result;
    }
}