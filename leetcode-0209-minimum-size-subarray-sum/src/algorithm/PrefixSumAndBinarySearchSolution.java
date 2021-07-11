package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-11
 */
public class PrefixSumAndBinarySearchSolution {
  /** Time Complexity: O(nlogn); Space Complexity: O(n); */
  public int minSubArrayLen(int target, int[] nums) {
    // corner case
    if (nums.length == 0) {
      return 0;
    }
    // prefix sum
    int[] prefixSums = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      prefixSums[i + 1] = prefixSums[i] + nums[i];
    }
    int minLen = nums.length + 1;
    // iterate prefix sum and binary search
    for (int i = 0; i < nums.length; i++) {
      int low = i;
      int high = nums.length - 1;
      while (low < high) {
        int mid = low + (high - low) / 2;
        int sum = prefixSums[mid + 1] - prefixSums[i];
        if (sum < target) {
          low = mid + 1;
        } else {
          // nums[mid] >= target
          high = mid;
        }
      }
      if (prefixSums[high + 1] - prefixSums[i] >= target) {
        int len = high - i + 1;
        minLen = len < minLen ? len : minLen;
      }
    }
    return minLen == nums.length + 1 ? 0 : minLen;
  }
}
