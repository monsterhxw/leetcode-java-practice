package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-08
 */
public class Test {
  public static void main(String[] args) {
    testTwoStackSolution();

    testStackNodeSolution();

    testCustomStackSolution();
  }

  private static void testMiniStack(MinStack minStack) {
    System.out.println("caller class name is: " + minStack.getClass().getSimpleName());
    minStack.push(-2);
    System.out.println("call push(-2)");
    minStack.push(0);
    System.out.println("call push(0)");
    minStack.push(-3);
    System.out.println("call push(-3)");
    int min = minStack.getMin();
    System.out.println("call getMin(): result is: " + min);
    minStack.pop();
    System.out.println("call pop()");
    int top = minStack.top();
    System.out.println("call top(): result is: " + top);
    min = minStack.getMin();
    System.out.println("call getMin(): result is: " + min);
  }

  private static void testTwoStackSolution() {
    System.out.println("----------testTwoStackSolution----------");
    MinStack minStack = new TwoStackSolution();
    testMiniStack(minStack);
  }

  private static void testStackNodeSolution() {
    System.out.println("-----------testStackNodeSolution---------");
    MinStack minStack = new StackNodeSolution();
    testMiniStack(minStack);
  }

  private static void testCustomStackSolution() {
    System.out.println("-----------testCustomStackSolution---------");
    MinStack minStack = new CustomStackSolution();
    testMiniStack(minStack);
  }
}
