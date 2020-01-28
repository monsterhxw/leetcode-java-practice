package algorithm;

/** @author monstervivi */
public class Main {

  int countUsingBit = 0;
  int countUsingArray = 0;

  public static void main(String[] args) {
    Main main = new Main();
    int n = 8;
    System.out.println("using dfs and arrays : " + main.totalNQueensUsingDFSAndArrays(n));
    System.out.println("using dfs and bit : " + main.totalNQueensUsingDFSAndBit(n));
  }

  public int totalNQueensUsingDFSAndBit(int n) {
    backTrackUsingBit(0, 0, 0, 0, n);
    return countUsingBit;
  }

  public void backTrackUsingBit(int row, int col, int pie, int na, int n) {
    if (row >= n) {
      countUsingBit++;
      return;
    }

    int bits = (~(col | na | pie)) & ((1 << n) - 1);

    while (bits > 0) {
      int lowBit = bits & (-bits);
      backTrackUsingBit(row + 1, col | lowBit, (pie | lowBit) << 1, (na | lowBit) >> 1, n);
      bits = bits & (bits - 1);
    }
  }

  public int totalNQueensUsingDFSAndArrays(int n) {
    if (n < 1) {
      return 0;
    }
    int[] col = new int[n];
    int[] diff = new int[2 * n - 1];
    int[] sum = new int[2 * n - 1];
    backTrack(0, n, col, diff, sum);
    return countUsingArray;
  }

  private void backTrack(int dept, int n, int[] col, int[] diff, int[] sum) {
    // recursion terminator
    if (dept == n) {
      countUsingArray++;
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

      backTrack(dept + 1, n, col, diff, sum);

      // remove the flags
      col[i] = 0;
      diff[dept - i + n - 1] = 0;
      sum[dept + i] = 0;
    }
  }
}
