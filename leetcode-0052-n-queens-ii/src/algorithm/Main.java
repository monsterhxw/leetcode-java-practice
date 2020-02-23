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

    // 得到当前所有的空位
    // (col | pie(/ sum) | na(\ diff)) 可以得到所有被占的空位，取反之后将有效空位置为 1
    // 与上 (1 << n) - 1，是设定考虑范围，比如 8 皇后，那么只用考虑低 8 位即可
    int bits = (~(col | na | pie)) & ((1 << n) - 1);

    // bit > 0 表示有空位
    while (bits > 0) {
      // 取到最低位的 1
      // -bits 将 bits 取反加 1
      int lowBit = bits & (-bits);

      // col | lowBit 是将 col 中当前选择的这一列置为 1，也就是无效
      // (pie | lowBit) << 1 是设置之前行和当前行对左下的影响
      // (na | lowBit) >> 1 是设置之前行和当前行对右下的影响
      backTrackUsingBit(row + 1, col | lowBit, (pie | lowBit) << 1, (na | lowBit) >> 1, n);
      // 去掉最低位的 1
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
