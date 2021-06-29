package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-29
 */
public class TailRecursionSolution {

  public int climbStairs(int n) {
    return climbStairs(n, 1, 0);
  }

  private int climbStairs(int n, int accumulator1, int accumulator2) {
    if (n == 0) {
      return accumulator1;
    } else {
      return climbStairs(n - 1, accumulator1 + accumulator2, accumulator1);
    }
  }
}
