package algorithm;

import java.util.Stack;

/**
 * push()&pop()&top()&getMin():Time Complexity: O(1); Space Complexity: O(n);
 *
 * @author XueweiHuang
 * @created 2021-07-08
 */
public class StackNodeSolution implements MinStack {

  private static class Node {
    private final int val;
    private final int min;

    Node(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }

  private Stack<Node> stack;

  public StackNodeSolution() {
    stack = new Stack<>();
  }

  @Override
  public void push(int val) {
    if (stack.empty()) {
      stack.push(new Node(val, val));
    } else {
      int min = val < stack.peek().min ? val : stack.peek().min;
      stack.push(new Node(val, min));
    }
  }

  @Override
  public void pop() {
    stack.pop();
  }

  @Override
  public int top() {
    return stack.peek().val;
  }

  @Override
  public int getMin() {
    return stack.peek().min;
  }
}
