package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-09
 */
public class BruteForceSolution {
  /** Time Complexity: O(n^2); Space Complexity: O(1); */
  public int minSubArrayLen(int target, int[] nums) {
    // corner case
    if (nums.length == 0) {
      return 0;
    }
    int minSize = nums.length + 1;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      // skip
      if (sum < target) {
        for (int j = i; j < nums.length; j++) {
          sum += nums[j];
          if (sum >= target) {
            int size = j - i + 1;
            minSize = size < minSize ? size : minSize;
          }
        }
      }
    }
    return minSize == nums.length + 1 ? 0 : minSize;
  }
}
