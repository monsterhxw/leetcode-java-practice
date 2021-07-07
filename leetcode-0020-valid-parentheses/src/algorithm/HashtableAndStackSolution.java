package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author XueweiHuang
 * @created 2021-07-07
 */
public class HashtableAndStackSolution {
  /** Time Complexity: O(n); Space Complexity: O(n + 6); */
  public boolean isValid(String s) {
    if (s.length() == 0 || s.length() % 2 == 1) {
      return false;
    }
    Map<Character, Character> map =
        new HashMap<Character, Character>() {
          {
            put(')', '(');
            put(']', '[');
            put('}', '{');
          }
        };
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        if (stack.empty() || !stack.peek().equals(map.get(ch))) {
          return false;
        } else {
          stack.pop();
        }
      } else {
        stack.push(ch);
      }
    }
    return stack.empty();
  }
}
