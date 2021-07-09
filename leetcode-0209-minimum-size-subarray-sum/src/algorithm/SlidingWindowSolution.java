package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-09
 */
public class SlidingWindowSolution {
  /** Time Complexity: O(n); Space Complexity: O(1); */
  public int minSubArrayLen(int target, int[] nums) {
    // corner case
    if (nums.length == 0) {
      return 0;
    } else {
      int minSize = nums.length + 1;
      int left = 0;
      int right = 0;
      int sum = 0;
      // [left, right)
      while (right < nums.length) {
        sum = sum + nums[right];
        right++;
        while (sum >= target) {
          int size = right - left;
          minSize = size < minSize ? size : minSize;
          sum = sum - nums[left];
          left++;
        }
      }
      return minSize == nums.length + 1 ? 0 : minSize;
    }
  }
}
