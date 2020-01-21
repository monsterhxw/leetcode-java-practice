package algorithm;

import java.util.ArrayList;
import java.util.List;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int n = 3;
    System.out.println("using dfs recursion: " + main.generateParenthesisUsingDFS(n));
  }

  public List<String> generateParenthesisUsingDFS(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    dfsHelper(n, n, "", result);
    return result;
  }

  /**
   * 回溯算法 DFS
   *
   * @param left 左括号可用数量
   * @param right 右括号可用数量
   * @param subStr 当前递归的结果
   * @param result 结果集
   */
  //                      (
  //             /                  \
  //          ((                     ()
  //       /     \                  /
  //    (((       (()              ()(
  //     |      /     \          /      \
  //  ((()))  (()(   (())     ()((      ()()
  //            |      |        |         |
  //         (()())  (())()   ()(())    ()()()
  private void dfsHelper(int left, int right, String subStr, List<String> result) {
    // 如果左括号可用数量为 0 而且右括号可用数量也为 0，那么就是找出有效的括号
    if (left == 0 && right == 0) {
      result.add(subStr);
      return;
    }
    // 若做左括号可用数量大于 0，填入左括号
    if (left > 0) {
      dfsHelper(left - 1, right, subStr + "(", result);
    }
    // 只有当右括号可用数量大于左括号可用数量的时候，才能填入右括号
    // 如 ()_ 就不能填入 )，否则 ()) 就是一个错误的括号
    if (right > left) {
      dfsHelper(left, right - 1, subStr + ")", result);
    }
  }
}
