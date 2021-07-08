package algorithm;

import java.util.Stack;

/**
 * @author XueweiHuang
 * @created 2021-07-08
 */
public class TwoStackSolution implements MinStack {

  private Stack<Integer> stack;

  private Stack<Integer> miniStack;

  public TwoStackSolution() {
    stack = new Stack<>();
    miniStack = new Stack<>();
  }

  @Override
  public void push(int val) {
    stack.push(val);
    if (miniStack.empty()) {
      miniStack.push(val);
    } else {
      if (val <= miniStack.peek()) {
        miniStack.push(val);
      }
    }
  }

  @Override
  public void pop() {
    if (!stack.empty()) {
      int pop = stack.pop();
      if (!miniStack.empty() && pop == miniStack.peek()) {
        miniStack.pop();
      }
    }
  }

  @Override
  public int top() {
    return stack.peek();
  }

  @Override
  public int getMin() {
    return miniStack.peek();
  }
}
