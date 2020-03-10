package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int[][] obstacleGrid = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

    System.out.println("obstacle grid is ");
    for (int i = 0; i < obstacleGrid.length; i++) {
      for (int j = 0; j < obstacleGrid[i].length; j++) {
        System.out.print(obstacleGrid[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println(
        "using dfs and backtracking, result is "
            + main.uniquePathsWithObstaclesUsingDFSAndBacktracking(obstacleGrid));
  }

  public int uniquePathsWithObstaclesUsingDFSAndBacktracking(int[][] obstacleGrid) {
    if (obstacleGrid == null
        || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
      return 0;
    }

    if (obstacleGrid.length == 0 && obstacleGrid[0].length == 0) {
      return 1;
    }

    return dfsHelper(0, 0, obstacleGrid);
  }

  private int dfsHelper(int row, int col, int[][] obstacleGrid) {
    if (row >= obstacleGrid.length
        || col >= obstacleGrid[0].length
        || obstacleGrid[row][col] == 1) {
      return 0;
    }

    if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
      return 1;
    }

    return dfsHelper(row + 1, col, obstacleGrid) + dfsHelper(row, col + 1, obstacleGrid);
  }
}
