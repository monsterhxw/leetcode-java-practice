package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));

    Main main = new Main();

    System.out.println("triangle is : " + triangle);

    System.out.println("using recursion, result is : " + main.minimumTotalUsingRecursive(triangle));

    System.out.println(
        "using memoization search, result is : "
            + main.minimumTotalUsingMemoizationSearch(triangle));

    System.out.println(
        "using dynamic programming, result is : " + main.minimumTotalUsingDP(triangle));
  }

  public int minimumTotalUsingDP(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int level = triangle.size();
    int[] dp = new int[level + 1];

    for (int row = level - 1; row >= 0; row--) {
      for (int col = 0; col <= row; col++) {
        dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
      }
    }

    return dp[0];
  }

  public int minimumTotalUsingMemoizationSearch(List<List<Integer>> triangle) {
    Integer[][] memo = new Integer[triangle.size()][triangle.size()];
    return helper(0, 0, triangle, memo);
  }

  private int helper(int level, int col, List<List<Integer>> triangle, Integer[][] memo) {
    if (level >= triangle.size() - 1) {
      return triangle.get(level).get(col);
    }

    if (memo[level][col] == null) {
      memo[level][col] =
          Math.min(
              helper(level + 1, col, triangle, memo), helper(level + 1, col + 1, triangle, memo));
    }

    return memo[level][col] + triangle.get(level).get(col);
  }

  public int minimumTotalUsingRecursive(List<List<Integer>> triangle) {
    return helper(0, 0, triangle);
  }

  private int helper(int level, int col, List<List<Integer>> triangle) {
    if (level >= triangle.size() - 1) {
      return triangle.get(level).get(col);
    }

    int min = Math.min(helper(level + 1, col, triangle), helper(level + 1, col + 1, triangle));

    return min + triangle.get(level).get(col);
  }
}
