package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    char[][] board =
        new char[][] {
          {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    System.out.println(main.isValidSudoku(board));
    System.out.println(
        "using bitwise operation solution : " + main.isValidSudokuUsingBitwiseOperation(board));
  }

  public boolean isValidSudoku(char[][] board) {
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    // 记录 3 * 3 宫格
    // block_row_index = (board_row / 3) * 3 + board_col / 3;
    // block_col_index 为对应遍历 board 的数字值
    boolean[][] block = new boolean[9][9];
    // 遍历矩阵的每一个值
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        // num 为二维数组 row, col, block 的列下标，所以这里处理为 - '1'
        int num = board[i][j] - '1';
        // blockRowIndex 为二维数组 block 的行的下标
        int blockRowIndex = (i / 3) * 3 + j / 3;
        // 判断数独的规则是否满足
        if (row[i][num] || col[j][num] || block[blockRowIndex][num]) {
          return false;
        } else {
          row[i][num] = true;
          col[j][num] = true;
          block[blockRowIndex][num] = true;
        }
      }
    }
    return true;
  }

  public boolean isValidSudokuUsingBitwiseOperation(char[][] board) {
    int[] row = new int[9];
    int[] col = new int[9];
    int[] block = new int[9];
    // 遍历矩阵的每一个值
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        // 当前字符是 '.' 则跳过, 直接进入下一轮循环
        if (board[i][j] == '.') {
          continue;
        }
        int num = board[i][j] - 48;
        int blockIndex = (i / 3) * 3 + j / 3;
        // 验证行，列，3 * 3 宫格
        if (!valid(row, i, num) || !valid(col, j, num) || !valid(block, blockIndex, num)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean valid(int[] arr, int index, int num) {
    // num 出现过, 返回false
    if (((arr[index] >> num) & 1) == 1) {
      return false;
    }
    // num 没出现过, 标记为出现过
    arr[index] = arr[index] | 1 << num;
    return true;
  }
}
