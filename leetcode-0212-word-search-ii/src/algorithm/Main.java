package algorithm;

import java.util.ArrayList;
import java.util.List;

/** @author monstervivi */
public class Main {

  private List<String> results = new ArrayList<>();

  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'o', 'a', 'a', 'n'},
          {'e', 't', 'a', 'e'},
          {'i', 'h', 'k', 'r'},
          {'i', 'f', 'l', 'v'}
        };
    String[] words = new String[] {"oath", "pea", "eat", "rain"};

    System.out.println((new Main()).findWords(board, words));
  }

  public List<String> findWords(char[][] board, String[] words) {
    if (board == null
        || words == null
        || board.length == 0
        || board[0].length == 0
        || words.length == 0) {
      return results;
    }

    Trie trie = new Trie();

    for (String word : words) {
      trie.insert(word);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfsBacktracking(board, i, j, "", trie);
      }
    }

    return results;
  }

  private void dfsBacktracking(char[][] board, int row, int col, String subStr, Trie trie) {
    if (row < 0
        || col < 0
        || row >= board.length
        || col >= board[0].length
        || board[row][col] == '.') {
      return;
    }

    char dummy = board[row][col];

    subStr += dummy;

    if (!trie.startsWith(subStr)) {
      return;
    }

    if (trie.search(subStr)) {
      if (!results.contains(subStr)) {
        results.add(subStr);
      }
    }

    board[row][col] = '.';

    dfsBacktracking(board, row - 1, col, subStr, trie);
    dfsBacktracking(board, row + 1, col, subStr, trie);
    dfsBacktracking(board, row, col - 1, subStr, trie);
    dfsBacktracking(board, row, col + 1, subStr, trie);

    board[row][col] = dummy;
  }
}
