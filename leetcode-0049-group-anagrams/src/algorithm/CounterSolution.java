package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author XueweiHuang
 * @created 2021-08-02
 */
public class CounterSolution {
  /** Counter CounterSolution;Time Complexity: O(n(k + 26); Space Complexity: O(n(k + 26)); */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    // time: O(n);
    for (String str : strs) {
      // space O(k);
      char[] chs = str.toCharArray();
      // space O(26);
      int[] freq = new int[26];
      // time: O(k);
      for (char ch : chs) {
        freq[ch - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      // time: O(26);
      for (int i = 0; i < freq.length; i++) {
        if (freq[i] > 0) {
          sb.append((char) (i + 'a'));
          sb.append(freq[i]);
        }
      }
      String key = sb.toString();
      List<String> values = map.getOrDefault(key, new ArrayList<>());
      values.add(str);
      map.put(key, values);
    }
    return new ArrayList<>(map.values());
  }
}
