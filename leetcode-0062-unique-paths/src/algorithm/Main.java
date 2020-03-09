package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int m = 7;
    int n = 3;

    System.out.println("m is " + m + ", n is " + n);

    System.out.println(
        "using dfs and backtracking, result is " + main.uniquePathsUsingDFSAndBacktracking(m, n));

    System.out.println(
        "using memoization search, result is " + main.uniquePathsUsingMemoizationSearch(m, n));

    System.out.println("using dynamic programming, result is " + main.uniquePathsUsingDP(m, n));
  }

  public int uniquePathsUsingDP(int m, int n) {
    int[] dp = new int[n];

    for (int row = m - 1; row >= 0; row--) {
      for (int col = n - 1; col >= 0; col--) {
        if (row == m - 1 && col != n - 1) {
          dp[col] = dp[col + 1];
        } else if (col == n - 1 && row != m - 1) {
          dp[col] = dp[col];
        } else if (row != m - 1 && col != n - 1) {
          dp[col] = dp[col] + dp[col + 1];
        } else {
          dp[col] = 1;
        }
      }
    }

    return dp[0];
  }

  public int uniquePathsUsingMemoizationSearch(int m, int n) {
    int[][] memo = new int[m][n];
    return dfsHelper(0, 0, m, n, memo);
  }

  private int dfsHelper(int row, int col, int m, int n, int[][] memo) {
    if (row == m - 1 && col == n - 1) {
      return 1;
    }

    if (memo[row][col] != 0) {
      return memo[row][col];
    }

    if (row == m - 1 && col != n - 1) {
      memo[row][col] = dfsHelper(row, col + 1, m, n, memo);
    } else if (col == n - 1 && row != m - 1) {
      memo[row][col] = dfsHelper(row + 1, col, m, n, memo);
    } else {
      memo[row][col] = dfsHelper(row + 1, col, m, n, memo) + dfsHelper(row, col + 1, m, n, memo);
    }

    return memo[row][col];
  }

  public int uniquePathsUsingDFSAndBacktracking(int m, int n) {
    return dfsHelper(0, 0, m, n);
  }

  private int dfsHelper(int row, int col, int m, int n) {
    if (row == m - 1 && col == n - 1) {
      return 1;
    }

    if (row == m - 1 && col != n - 1) {
      return dfsHelper(row, col + 1, m, n);
    } else if (col == n - 1 && row != m - 1) {
      return dfsHelper(row + 1, col, m, n);
    } else {
      return dfsHelper(row + 1, col, m, n) + dfsHelper(row, col + 1, m, n);
    }
  }
}
