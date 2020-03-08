package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int n = 10;

    System.out.println("Integer n is : " + n);

    System.out.println("using bf searching, result is : " + main.integerBreakUsingBF(n));

    System.out.println(
        "using memoization search, result is : " + main.integerBreakUsingMemoizationSearch(n));

    System.out.println("using dynamic programming, result is : " + main.integerBreakUsingDP(n));
  }

  public int integerBreakUsingDP(int n) {
    // 状态转移方程
    // dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j))
    // 其中，(i - j) * j 是说只将整数 n 拆分成 2 个数考虑
    // 而 dp[i - j] * j 是考虑将整数 n 不断拆分，取两者的最大值。
    int[] dp = new int[n + 1];
    dp[2] = 1;

    for (int i = 3; i <= n; i++) {
      for (int j = 1; j < i; j++) {
        // j * (i - j) 表示只分割两部分的情况 j 和 (i - j)
        // j * dp[i - j] 表示分割两部分以上的情况
        dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
      }
    }

    return dp[n];
  }

  public int integerBreakUsingMemoizationSearch(int n) {
    int[] memo = new int[n + 1];
    return memoSearchHelper(n, memo);
  }

  private int memoSearchHelper(int n, int[] memo) {
    if (n == 2) {
      return 1;
    }

    if (memo[n] != 0) {
      return memo[n];
    }

    int result = -1;

    for (int i = 1; i < n; i++) {
      result = Math.max(result, Math.max(i * (n - i), i * memoSearchHelper(n - i, memo)));
    }

    memo[n] = result;

    return result;
  }

  public int integerBreakUsingBF(int n) {
    if (n == 2) {
      return 1;
    }

    int result = -1;

    for (int i = 1; i < n; i++) {
      result = Math.max(result, Math.max(i * (n - i), i * integerBreakUsingBF(n - i)));
    }

    return result;
  }
}
