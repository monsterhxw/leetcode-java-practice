package algorithm;

import java.util.Stack;

/**
 * @author monstervivi
 */
public class MyQueue {

    private Stack<Integer> stack;

    private Stack<Integer> tempStack;

    private int front;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
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
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        tempStack.push(x);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    /**
     * Remove the element from in front of queue and returns that element.
     */
    public int pop() {
        int element = stack.pop();
        if (!stack.isEmpty()) {
            front = stack.peek();
        }
        return element;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }


}
