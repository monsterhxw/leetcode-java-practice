package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-29
 */
public class DynamicProgrammingSolution {

  /**
   * 每次爬楼梯是 「1」或者「2」个台阶
   * 所以爬到楼顶 n 的方法是由 「n - 1」台阶的方法加上「n - 2」台阶的方法
   * 所以问题是可以分为多个子问题来解决
   *
   * 递推公式为 dp[n] = dp[n - 1] + dp[n - 2];
   * 其中 dp[0] = 1 和 dp[1] = 1;
   *
   * Time Complexity 为 O(n)
   */
  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}
