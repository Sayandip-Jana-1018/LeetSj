class MyQueue {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        helperStack();
        return outputStack.pop();
    }
    
    public int peek() {
        helperStack();
        return outputStack.peek();
    }
    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public void helperStack() {
        if(outputStack.isEmpty()) {
            while(!inputStack.isEmpty()) outputStack.push(inputStack.pop());
        }
    }
}
