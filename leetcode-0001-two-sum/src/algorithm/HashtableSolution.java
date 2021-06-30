package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XueweiHuang
 * @created 2021-06-30
 */
public class HashtableSolution {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> hashtable = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (hashtable.containsKey(nums[i])) {
        return new int[] {hashtable.get(nums[i]), i};
      } else {
        hashtable.put(target - nums[i], i);
      }
    }
    return new int[0];
  }
}
