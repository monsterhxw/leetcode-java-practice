package algorithm;

/** @author monstervivi */
public class Main {

  boolean[][] rows = new boolean[9][9];
  boolean[][] cols = new boolean[9][9];
  boolean[][] boxes = new boolean[9][9];

  public static void main(String[] args) {
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
    (new Main()).solveSudoku(board);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void solveSudoku(char[][] board) {
    if (board.length == 0 || board == null) {
      return;
    }

    // 初始化
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        // num 为二维数组 row, col, block 的列下标，所以这里处理为 - 49
        int num = board[i][j] - 49;
        int boxesIndex = (i / 3) * 3 + (j / 3);
        rows[i][num] = true;
        cols[j][num] = true;
        boxes[boxesIndex][num] = true;
      }
    }
    solver(board, 0, 0);
  }

  private boolean solver(char[][] board, int row, int col) {
    if (col == board[row].length) {
      col = 0;
      row++;
      if (row == board.length) {
        return true;
      }
    }

    // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
    if (board[row][col] == '.') {
      // 尝试填充 1 ~ 9
      int boxesIndex = (row / 3) * 3 + col / 3;
      for (char c = '1'; c <= '9'; c++) {
        if (!rows[row][c - 49] && !cols[col][c - 49] && !boxes[boxesIndex][c - 49]) {
          board[row][col] = c;
          rows[row][c - 49] = true;
          cols[col][c - 49] = true;
          boxes[boxesIndex][c - 49] = true;
          if (solver(board, row, col + 1)) {
            return true;
          }
          // 剪枝
          board[row][col] = '.';
          rows[row][c - 49] = false;
          cols[col][c - 49] = false;
          boxes[boxesIndex][c - 49] = false;
        }
      }
    } else {
      return solver(board, row, col + 1);
    }
    return false;
  }
}
