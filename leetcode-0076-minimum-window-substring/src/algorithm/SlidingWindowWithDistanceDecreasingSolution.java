package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-19
 */
public class SlidingWindowWithDistanceDecreasingSolution {
  /** Time Complexity: O(|S|+|T|); Space Complexity: O(|S|+|T|); */
  public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
      return "";
    }

    int minWinLen = s.length() + 1;
    int begin = 0;

    char[] sArr = s.toCharArray();
    char[] tArr = t.toCharArray();

    int[] tFreq = new int[128];
    // 窗口内部覆盖 T 还需要的各个字符的个数
    for (int i = 0; i < tArr.length; i++) {
      tFreq[tArr[i]]++;
    }
    // sliding window 内部还差多少 T 中的字符，对应字符频数超过不重复计算
    int distance = tArr.length;

    int left = 0;
    int right = 0;
    // [left, right)
    while (right < sArr.length) {
      char r = sArr[right];
      if (tFreq[r] > 0) {
        distance--;
      }
      tFreq[r]--;
      right++;
      while (distance == 0) {
        if (right - left < minWinLen) {
          minWinLen = right - left;
          begin = left;
        }
        char l = sArr[left];
        if (tFreq[l] == 0) {
          distance++;
        }
        tFreq[l]++;
        left++;
      }
    }

    return minWinLen == s.length() + 1 ? "" : s.substring(begin, begin + minWinLen);
  }
}
