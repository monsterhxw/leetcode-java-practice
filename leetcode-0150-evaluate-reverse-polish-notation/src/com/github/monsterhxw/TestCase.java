package com.github.monsterhxw;

/**
 * @author Xuewei Huang
 * @created 2022-04-28
 */
public class TestCase {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] tokens = new String[] {"2", "1", "+", "3", "*"};
    System.out.println("Expect result is 9. Actually result is " + solution.evalRPN(tokens));
    tokens = new String[] {"4", "13", "5", "/", "+"};
    System.out.println("Expect result is 6. Actually result is " + solution.evalRPN(tokens));
    tokens = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println("Expect result is 22. Actually result is " + solution.evalRPN(tokens));
  }
}
