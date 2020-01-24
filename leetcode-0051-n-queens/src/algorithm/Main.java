package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author monstervivi
 */
public class Main {

  private List<List<String>> result = new ArrayList<>();

  public static void main(String[] args) {
    Main main = new Main();
    int n = 4;
    System.out.println("using dfs and arrays : ");
    main.solveNQueensUsingDFSANDArrays(n).forEach(System.out::println);
  }

  public List<List<String>> solveNQueensUsingDFSANDArrays(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }

    int[] col = new int[n];
    int[] sum = new int[2 * n - 1];
    int[] diff = new int[2 * n - 1];

    List<String> board = new ArrayList<>(n);

    backTrackUsingDFSAndArrays(0, n, col, sum, diff, board);

    return result;
  }

  private void backTrackUsingDFSAndArrays(int depth, int n, int[] col, int[] sum, int[] diff, List<String> board) {
    if (depth == n) {
      result.add(new ArrayList<>(board));
      return;
    }

    for (int column = 0; column < n; column++) {
      if (col[column] == 0 && sum[depth + column] == 0 && diff[depth - column + n - 1] == 0) {
        col[column] = 1;
        sum[depth + column] = 1;
        diff[depth - column + n - 1] = 1;

        char[] row = new char[n];
        Arrays.fill(row, '.');
        row[column] = 'Q';
        board.add(new String(row));

        backTrackUsingDFSAndArrays(depth + 1, n, col, sum, diff, board);

        board.remove(board.size() - 1);

        col[column] = 0;
        sum[depth + column] = 0;
        diff[depth - column + n - 1] = 0;
      }
    }
  }
}
