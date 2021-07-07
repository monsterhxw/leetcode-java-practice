package algorithm;

import java.util.Stack;

/**
 * @author XueweiHuang
 * @created 2021-07-07
 */
public class StackSolution {
  /** Time Complexity: O(n); Space Complexity: O(n) */
  public boolean isValid(String s) {
    if (s.length() == 0 || s.length() % 2 == 1) {
      return false;
    } else {
      Stack<Character> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch == '(') {
          stack.push(')');
        } else if (ch == '[') {
          stack.push(']');
        } else if (ch == '{') {
          stack.push('}');
        } else if (stack.empty() || ch != stack.pop()) {
          return false;
        }
      }
      return stack.empty();
    }
  }
}
