package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-07
 */
public class BruteForceSolution {
  /** Time Complexity: O(n); Space Complexity: O(1); */
  public boolean isValid(String s) {
    if (s.length() == 0 || s.length() % 2 == 1) {
      return false;
    }
    while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
      s = s.replace("()", "");
      s = s.replace("[]", "");
      s = s.replace("{}", "");
    }
    return s.length() == 0;
  }
}
