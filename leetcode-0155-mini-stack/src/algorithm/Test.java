package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-08
 */
public class Test {
  public static void main(String[] args) {
    testTwoStackSolution();
  }

  private static void testMiniStack(MiniStack miniStack) {
    System.out.println("caller class name is: " + miniStack.getClass().getSimpleName());
    miniStack.push(-2);
    System.out.println("call push(-2)");
    miniStack.push(0);
    System.out.println("call push(0)");
    miniStack.push(-3);
    System.out.println("call push(-3)");
    int min = miniStack.getMin();
    System.out.println("call getMin(): result is: " + min);
    miniStack.pop();
    System.out.println("call pop()");
    int top = miniStack.top();
    System.out.println("call top(): result is: " + top);
    min = miniStack.getMin();
    System.out.println("call getMin(): result is: " + min);
  }

  private static void testTwoStackSolution() {
    System.out.println("----------testTwoStackSolution----------");
    MiniStack miniStack = new TwoStackSolution();
    testMiniStack(miniStack);
  }
}
