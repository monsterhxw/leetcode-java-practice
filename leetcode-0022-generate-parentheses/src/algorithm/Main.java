package algorithm;

import java.util.ArrayList;
import java.util.List;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int n = 3;
    System.out.println(main.generateParenthesis(n));
  }

  //                      (
  //             /                  \
  //          ((                     ()
  //       /     \                  /
  //    (((       (()              ()(
  //     |      /     \          /      \
  //  ((()))  (()(   (())     ()((      ()()
  //            |      |        |         |
  //         (()())  (())()   ()(())    ()()()
  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    dfsHelper(n, n, "", result);
    return result;
  }

  private void dfsHelper(int left, int right, String subStr, List<String> result) {
    if (left == 0 && right == 0) {
      result.add(subStr);
      return;
    }
    if (left > 0) {
      dfsHelper(left - 1, right, subStr + "(", result);
    }
    if (right > left) {
      dfsHelper(left, right - 1, subStr + ")", result);
    }
  }
}
