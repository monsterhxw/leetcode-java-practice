package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    int[][] grid =
        new int[][] {
          {1, 3, 1},
          {1, 7, 1},
          {4, 2, 1}
        };

    Main main = new Main();

    System.out.println("grid is");
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println("using dfs and backtracking : result is " + main.minPathSumUsingDFS(grid));

    System.out.println(
        "using memoization search : result is " + main.minPathSumUsingMemoizationSearch(grid));

    System.out.println(
        "using dynamic programming and 2d array : result is "
            + main.minPathSumUsingDPAnd2DArray(grid));

    System.out.println(
        "using dynamic programming and 1d array : result is "
            + main.minPathSumUsingDPAnd1DArray(grid));
  }

  public int minPathSumUsingDPAnd1DArray(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int rowSize = grid.length;
    int colSize = grid[0].length;
    int[] dp = new int[grid[0].length];

    for (int row = rowSize - 1; row >= 0; row--) {
      for (int col = colSize - 1; col >= 0; col--) {
        if (row == rowSize - 1 && col != colSize - 1) {
          dp[col] = dp[col + 1] + grid[row][col];
        } else if (col == colSize - 1 && row != rowSize - 1) {
          dp[col] = dp[col] + grid[row][col];
        } else if (row != rowSize - 1 && col != colSize - 1) {
          dp[col] = Math.min(dp[col], dp[col + 1]) + grid[row][col];
        } else {
          dp[col] = grid[row][col];
        }
      }
    }

    return dp[0];
  }

  public int minPathSumUsingDPAnd2DArray(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int[][] dp = new int[grid.length][grid[0].length];

    for (int row = grid.length - 1; row >= 0; row--) {
      for (int col = grid[0].length - 1; col >= 0; col--) {
        if (row == grid.length - 1 && col != grid[0].length - 1) {
          dp[row][col] = dp[row][col + 1] + grid[row][col];
        } else if (col == grid[0].length - 1 && row != grid.length - 1) {
          dp[row][col] = dp[row + 1][col] + grid[row][col];
        } else if (row != grid.length - 1 && col != grid[0].length - 1) {
          dp[row][col] = Math.min(dp[row + 1][col], dp[row][col + 1]) + grid[row][col];
        } else {
          dp[row][col] = grid[row][col];
        }
      }
    }

    return dp[0][0];
  }

  public int minPathSumUsingMemoizationSearch(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    Integer[][] memo = new Integer[grid.length][grid[0].length];

    return helper(0, 0, grid, memo);
  }

  private int helper(int level, int col, int[][] grid, Integer[][] memo) {
    if (level == grid.length - 1 && col == grid[0].length - 1) {
      return grid[level][col];
    }

    if (memo[level][col] == null) {
      if (level == grid.length - 1) {
        memo[level][col] = helper(level, col + 1, grid, memo) + grid[level][col];
      } else if (col == grid[0].length - 1) {
        memo[level][col] = helper(level + 1, col, grid, memo) + grid[level][col];
      } else {
        int down = helper(level + 1, col, grid, memo);
        int right = helper(level, col + 1, grid, memo);
        memo[level][col] = Math.min(down, right) + grid[level][col];
      }
    }

    return memo[level][col];
  }

  public int minPathSumUsingDFS(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    return dfsHelper(0, 0, grid);
  }

  private int dfsHelper(int level, int col, int[][] grid) {
    if (level == grid.length - 1 && col == grid[0].length - 1) {
      return grid[level][col];
    }

    if (level == grid.length - 1) {
      return dfsHelper(level, col + 1, grid) + grid[level][col];
    } else if (col == grid[0].length - 1) {
      return dfsHelper(level + 1, col, grid) + grid[level][col];
    }

    int down = dfsHelper(level + 1, col, grid);
    int right = dfsHelper(level, col + 1, grid);

    return Math.min(down, right) + grid[level][col];
  }
}
