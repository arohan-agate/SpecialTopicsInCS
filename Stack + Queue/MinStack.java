// Arohan Agate, Period 4

class MinStack {

    // instance variables
    Stack<Integer> stack;
    Stack<Integer> minStack;
    
    // constructor
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    // adds all ints to stack. adds first int to stack. if ints are smaller than the top value on minStack, add the int to minStack
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        }
        else if (val < minStack.peek()) {
            minStack.push(val);
        }
    }
    
    // checks to see if the top value in stack is equal to the top value in minStack. if so, remove the value from the minStack. regardless of the last step, remove the value from the main stack
    public void pop() {
        if (stack.peek() == minStack.peek()) {
            minStack.pop();
        }
        stack.pop();
        
    }
    
    // return the top value on the stack
    public int top() {
        return stack.peek();
    }
    
    // returns the top value from the minStack if it is NOT empty
    public int getMin() {
        if (minStack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
