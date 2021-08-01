package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author XueweiHuang
 * @created 2021-08-01
 */
public class SortSolution {
  /** Time Complexity: O(nklogk); Space Complexity: O(nk); */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chs = str.toCharArray();
      Arrays.sort(chs);
      String key = new String(chs);
      List<String> values;
      if (map.containsKey(key)) {
        values = map.get(key);
      } else {
        values = new ArrayList<>();
      }
      values.add(str);
      map.put(key, values);
    }
    return new ArrayList<>(map.values());
  }
}
