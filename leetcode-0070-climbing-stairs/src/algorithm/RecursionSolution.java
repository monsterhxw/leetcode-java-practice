package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-29
 */
public class RecursionSolution {

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    } else {
      return climbStairs(n - 1) + climbStairs(n - 2);
    }
  }
}
