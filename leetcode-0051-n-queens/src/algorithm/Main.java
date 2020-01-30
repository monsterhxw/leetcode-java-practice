package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author monstervivi
 */
public class Main {

  private List<List<String>> resultUsingArrays = new ArrayList<>();
  private List<List<String>> resultsUsingBit = new ArrayList<>();
  private List<String> resultUsingBit = new ArrayList<>();

  public static void main(String[] args) {
    Main main = new Main();
    int n = 4;
    System.out.println("using dfs and arrays : ");
    main.solveNQueensUsingDFSAndArrays(n).forEach(System.out::println);
    System.out.println("\n");
    System.out.println("using dfs and bit : ");
    main.solveNQueensUsingDFSAndBit(n).forEach(System.out::println);
  }

  public List<List<String>> solveNQueensUsingDFSAndArrays(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }

    int[] col = new int[n];
    int[] sum = new int[2 * n - 1];
    int[] diff = new int[2 * n - 1];

    List<String> board = new ArrayList<>(n);

    backTrackUsingDFSAndArrays(0, n, col, sum, diff, board);

    return resultUsingArrays;
  }

  private void backTrackUsingDFSAndArrays(int depth, int n, int[] col, int[] sum, int[] diff,
      List<String> board) {
    if (depth == n) {
      resultUsingArrays.add(new ArrayList<>(board));
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

  public List<List<String>> solveNQueensUsingDFSAndBit(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }

    backTrackUsingDFSAndBit(n, 0, 0, 0);

    return resultsUsingBit;
  }

  private void backTrackUsingDFSAndBit(int n, int col, int pie, int na) {
    if (n == resultUsingBit.size()) {
      resultsUsingBit.add(new ArrayList<>(resultUsingBit));
      return;
    }

    // 获得所有的有效空位
    // (col | pie | na) 可以得到所有被占的空位，取反之后将有效空位置为 1
    // 与上 (1 << n) - 1，是设定考虑范围，比如 8 皇后，那么只用考虑低 8 位即可
    int bit = ((~(col | pie | na)) & ((1 << n) - 1));

    // bit > 0 表示有空位
    while (bit > 0) {
      // 选择最低位的一个空位
      int tmp = bit & (-bit);

      // 构建当前行的答案
      String str = constructString(tmp, n);
      resultUsingBit.add(str);

      // col | tmp 是将 col 中当前选择的这一列置为 1，也就是无效
      // (pie | tmp) << 1 是设置之前行和当前行对左下的影响
      // (na | tmp) >> 1 是设置之前行和当前行对右下的影响
      backTrackUsingDFSAndBit(n, col | tmp, (pie | tmp) << 1, (na | tmp) >> 1);

      resultUsingBit.remove(resultUsingBit.size() - 1);

      // 将当前选择的这个最低位置为 0
      bit &= bit - 1;
    }
  }

  private String constructString(int i, int n) {
    char[] row = new char[n];

    Arrays.fill(row, '.');
    int tmp = 1, index = 0;

    while (i != 0) {
      if ((tmp & i) != 0) {
        row[index] = 'Q';
      }

      i >>= 1;
      index++;
    }

    return new String(row);
  }
}
