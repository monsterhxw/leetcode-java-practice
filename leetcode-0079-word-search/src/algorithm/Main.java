package algorithm;

import java.util.Arrays;
import java.util.List;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'A', 'B', 'C', 'E'},
          {'S', 'F', 'C', 'S'},
          {'A', 'D', 'E', 'E'}
        };

    Main main = new Main();

    List<String> words = Arrays.asList("ABCCED", "SEE", "ABCB");

    for (String word : words) {
      System.out.println("word is : " + word + ", result : " + main.exist(board, word));
    }
  }

  public boolean exist(char[][] board, String word) {
    if (board == null
        || board.length == 0
        || word == null
        || word.length() == 0
        || board.length * board[0].length < word.length()) {
      return false;
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfsBacktracking(board, i, j, word, 0)) {
            return true;
          }
        }
      }
    }

    return false;
  }

  private boolean dfsBacktracking(char[][] board, int row, int col, String word, int curIndex) {
    if (curIndex == word.length()) {
      return true;
    }

    if (row < 0
        || col < 0
        || row >= board.length
        || col >= board[row].length
        || board[row][col] != word.charAt(curIndex)) {
      return false;
    }

    board[row][col] = '.';

    boolean res =
        dfsBacktracking(board, row - 1, col, word, curIndex + 1)
            || dfsBacktracking(board, row + 1, col, word, curIndex + 1)
            || dfsBacktracking(board, row, col - 1, word, curIndex + 1)
            || dfsBacktracking(board, row, col + 1, word, curIndex + 1);

    board[row][col] = word.charAt(curIndex);

    return res;
  }
}
