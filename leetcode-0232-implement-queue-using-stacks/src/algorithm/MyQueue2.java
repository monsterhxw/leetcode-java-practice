package algorithm;

import java.util.Stack;

/**
 * @author monstervivi
 */
public class MyQueue2 {

    private Stack<Integer> stack;

    private Stack<Integer> tempStack;

    private int front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue2() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack.empty()) {
            front = x;
        }
        stack.push(x);
    }

    /**
     * Remove the element from in front of queue and returns that element.
     */
    public int pop() {
        if (tempStack.isEmpty()) {
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
        }
        return tempStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return tempStack.isEmpty() ? front : tempStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty() && tempStack.isEmpty();
    }
}
