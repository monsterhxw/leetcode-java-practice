package com.github.monsterhxw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Xuewei Huang
 * @created 2022-04-28
 */
class Solution {

  /** Time complexity: O(n), Space Complexity: O(n) */
  public int evalRPN(String[] tokens) {
    Deque<Integer> operandStack = new LinkedList<>();
    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i];
      if (isNumber(token)) {
        operandStack.push(Integer.valueOf(token));
      } else {
        int operand2 = operandStack.pop();
        int operand1 = operandStack.pop();
        switch (token) {
          case "+":
            operandStack.push(operand1 + operand2);
            break;
          case "-":
            operandStack.push(operand1 - operand2);
            break;
          case "*":
            operandStack.push(operand1 * operand2);
            break;
          case "/":
            operandStack.push(operand1 / operand2);
            break;
          default:
        }
      }
    }
    return operandStack.pop();
  }

  private boolean isNumber(String token) {
    return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
  }
}
