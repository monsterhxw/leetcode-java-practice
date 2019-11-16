package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author monstervivi
 */
public class MyStack3 {

    private Queue<Integer> queue;

    private int top;

    /** Initialize your data structure here. */
    public MyStack3() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        int tempSize = queue.size();
        while (tempSize > 1) {
            queue.add(queue.remove());
            tempSize--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
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