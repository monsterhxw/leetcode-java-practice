package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int n = 34;

    System.out.println(
        "using dynamic programming : n is " + n + ", result is " + main.climbStairsUsingDP(n));

    System.out.println(
        "using memoization search : n is "
            + n
            + ", result is "
            + main.climbStairsUsingMemoizationSearch(n));
  }

  public int climbStairsUsingDPOptimization(int n) {
    if (n == 1) {
      return 1;
    }

    int first = 1;
    int second = 2;

    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }

    return second;
  }

  public int climbStairsUsingDP(int n) {
    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; ++i) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  public int climbStairsUsingMemoizationSearch(int n) {
    int[] memo = new int[n + 1];

    return calculateWay(n, memo);
  }

  private int calculateWay(int i, int[] memo) {
    if (i == 0 || i == 1) {
      return 1;
    }

    if (memo[i] == 0) {
      memo[i] = calculateWay(i - 1, memo) + calculateWay(i - 2, memo);
    }

    return memo[i];
  }
}
