package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-30
 */
public class MemoizationSolution {

  public int climbStairs(int n) {
    int[] memo = new int[n + 1];
    return dfs(n, memo);
  }

  private int dfs(int n, int[] memo) {
    if (n <= 2) {
      return n;
    }

    if (memo[n] == 0) {
      memo[n] = dfs(n - 1, memo) + dfs(n - 2, memo);
    }

    return memo[n];
  }
}
