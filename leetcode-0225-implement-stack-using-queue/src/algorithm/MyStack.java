package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author monstervivi
 */
public class MyStack {

    private Queue<Integer> queue;

    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int oldTop = top;
        Queue<Integer> tempQueue = new LinkedList<>();
        while (queue.size() > 1) {
            top = queue.remove();
            tempQueue.add(top);
        }
        queue = tempQueue;
        return oldTop;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */