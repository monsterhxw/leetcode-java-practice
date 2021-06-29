package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-29
 */
public class DynamicProgrammingOptimizationSolution {

  /** f(n) = f(n - 1) + f(n - 2); */
  public int climbStairs(int n) {
    int first = 0;
    int second = 0;
    int third = 1;
    for (int i = 1; i <= n; i++) {
      first = second;
      second = third;
      third = first + second;
    }
    return third;
  }
}
