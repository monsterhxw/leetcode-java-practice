package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-18
 */
public class SlidingWindowWithDistanceIncreasingSolution {
  /** Time Complexity: O(|S|+|T|); Space Complexity: O(|S|+|T|); */
  public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
      return "";
    }
    int minWindowLen = s.length() + 1;
    int begin = 0;
    char[] chars = s.toCharArray();
    char[] chart = t.toCharArray();
    int[] winFreq = new int[128];
    int[] tFreq = new int[128];
    for (int i = 0; i < chart.length; i++) {
      tFreq[chart[i]]++;
    }
    // sliding window 内部包含多少 T 中的字符，对应字符频数超过不重复计算
    int distance = 0;
    int left = 0;
    int right = 0;
    // [left, right)
    while (right < chars.length) {
      if (tFreq[chars[right]] > 0 && winFreq[chars[right]] < tFreq[chars[right]]) {
        distance++;
      }
      winFreq[chars[right]]++;
      right++;
      while (distance == chart.length) {
        if (right - left < minWindowLen) {
          minWindowLen = right - left;
          begin = left;
        }
        if (tFreq[chars[left]] > 0 && winFreq[chars[left]] == tFreq[chars[left]]) {
          distance--;
        }
        winFreq[chars[left]]--;
        left++;
      }
    }
    return minWindowLen == s.length() + 1 ? "" : s.substring(begin, begin + minWindowLen);
  }
}
