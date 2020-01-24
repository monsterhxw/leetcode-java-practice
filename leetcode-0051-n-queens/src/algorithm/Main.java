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
    List<List<String>> lists = main.solveNQueens(n);
    System.out.println(lists);
  }

  public List<List<String>> solveNQueens(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }

    int[] col = new int[n];
    int[] sum = new int[2 * n - 1];
    int[] diff = new int[2 * n - 1];
    List<String> board = new ArrayList<>();

    backTrack(0, n, col, diff, sum, board);

    return result;
  }

  private void backTrack(int dept, int n, int[] col, int[] diff, int[] sum, List<String> board) {
    // recursion terminator
    if (dept == n) {
      result.add(new ArrayList<>(board));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (col[i] == 1 || diff[dept - i + n - 1] == 1 || sum[dept + i] == 1) {
        // go die;
        continue;
      }
      // update the flags
      col[i] = 1;
      diff[dept - i + n - 1] = 1;
      sum[dept + i] = 1;

      char[] s = new char[n];
      Arrays.fill(s, '.');
      s[i] = 'Q';
      board.add(new String(s));

      backTrack(dept + 1, n, col, diff, sum, board);

      board.remove(board.size() - 1);

      // remove the flags
      col[i] = 0;
      diff[dept - i + n - 1] = 0;
      sum[dept + i] = 0;
    }
  }
}
