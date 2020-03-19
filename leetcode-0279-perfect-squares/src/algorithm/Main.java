package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int n = 1;
    System.out.println("n is : " + n);

    System.out.println("using bfs, result is : " + main.numSquaresUsingBFS(n));

    System.out.println("using dynamic programming, result is : " + main.numSquaresUsingDP(n));

    System.out.println("using dfs, result is : " + main.numSquaresUsingDFS(n));

    System.out.println(
        "using memoization search, result is : " + main.numSquaresUsingMemoizationSearch(n));
  }

  // 12
  // 1, 4, 9
  //
  // 1 + minSquares(12 - 1)
  // ...
  //
  // 4 + minSquares(12 - 4)
  //    4 + 1 + minSquares(8 - 1)
  //        4 + 1 + 1 + minSquares(7 - 1)
  //        4 + 1 + 4 + minSquares(7 - 4)
  //        ....
  //    4 + 4 + minSquares(8 - 4)
  //        4 + 4 + 1 + min(4 - 1)
  //        4 + 4 + 4 + min(4 - 4)
  //        ...
  // 9 + minSquares(12 - 9)
  //    9 + 1 + minSquares(3 - 1)
  //    ...
  //
  public int numSquaresUsingDP(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    return dp[n];
  }

  public int numSquaresUsingMemoizationSearch(int n) {
    if (n <= 1) {
      return n;
    }

    Integer[] memo = new Integer[n + 1];

    return memoHelper(n, memo);
  }

  private int memoHelper(int n, Integer[] memo) {
    if (n == 0) {
      return 0;
    }

    if (memo[n] != null) {
      return memo[n];
    }

    int result = n;

    for (int i = 1; i * i <= n; i++) {
      result = Math.min(result, memoHelper(n - i * i, memo) + 1);
    }

    memo[n] = result;

    return memo[n];
  }

  public int numSquaresUsingDFS(int n) {
    if (n <= 1) {
      return n;
    }

    return dfsHelper(n);
  }

  private int dfsHelper(int n) {
    if (n == 0) {
      return 0;
    }

    int result = n;

    for (int i = 1; i * i <= n; i++) {
      result = Math.min(result, dfsHelper(n - i * i) + 1);
    }

    return result;
  }

  public int numSquaresUsingBFS(int n) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    Set<Integer> visited = new HashSet<>();
    visited.add(0);

    int distance = 0;

    while (!queue.isEmpty()) {
      distance++;

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int curr = queue.poll();
        for (int j = 1; j * j + curr <= n; j++) {
          int next = j * j + curr;
          if (next == n) {
            return distance;
          }
          if (next < n && !visited.contains(next)) {
            queue.add(next);
            visited.add(next);
          }
        }
      }
    }

    return distance;
  }
}
