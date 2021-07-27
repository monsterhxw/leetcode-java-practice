package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-27
 */
public class SortSolution {
  /** Time Complexity: O(nlogn); Space Complexity: O(n); */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    } else {
      char[] sCharArr = s.toCharArray();
      char[] tCharArr = t.toCharArray();
      Arrays.sort(sCharArr);
      Arrays.sort(tCharArr);
      return Arrays.equals(sCharArr, tCharArr);
    }
  }
}
