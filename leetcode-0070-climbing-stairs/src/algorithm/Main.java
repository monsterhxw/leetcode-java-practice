package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int n = 3;
    System.out.println("using dynamic programming : result is " + main.climbStairs(n));
  }

  public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; ++i) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public int climbStairsUsingBacktracking(int n) {
    int memo[] = new int[n + 1];
    return climbStairs(0, n, memo);
  }

  public int climbStairs(int i, int n, int memo[]) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (memo[i] > 0) {
      return memo[i];
    }
    memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo);
    return memo[i];
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
}
