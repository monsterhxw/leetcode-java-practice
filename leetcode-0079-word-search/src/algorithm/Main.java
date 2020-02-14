package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {}

  public boolean exist(char[][] board, String word) {
    if (board == null
        || board.length < 1
        || word.length() < 1
        || board.length * board[0].length < word.length()) {
      return false;
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfsBacktrace(board, i, j, word, 0)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  private boolean dfsBacktrace(char[][] board, int row, int col, String word, int curIndex) {
    if (curIndex == word.length()) {
      return true;
    }

    if (row < 0
        || col < 0
        || row >= board.length
        || col >= board[0].length
        || board[row][col] != word.charAt(curIndex)) {
      return false;
    }

    board[row][col] = '.';

    boolean res =
        dfsBacktrace(board, row - 1, col, word, curIndex + 1)
            || dfsBacktrace(board, row + 1, col, word, curIndex + 1)
            || dfsBacktrace(board, row, col - 1, word, curIndex + 1)
            || dfsBacktrace(board, row, col + 1, word, curIndex + 1);

    board[row][col] = word.charAt(curIndex);

    return res;
  }
}
