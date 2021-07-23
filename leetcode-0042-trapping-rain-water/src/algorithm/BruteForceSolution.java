package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-23
 */
public class BruteForceSolution {
  /** Time Complexity: O(n^2); Space Complexity: O(1); */
  public int trap(int[] height) {
    int totalTrappingRainWater = 0;
    for (int mid = 0; mid < height.length; mid++) {
      int left = mid;
      int right = mid;
      int maxLeftHeight = 0;
      int maxRightHeight = 0;
      while (left >= 0) {
        maxLeftHeight = height[left] > maxLeftHeight ? height[left] : maxLeftHeight;
        left--;
      }
      while (right < height.length) {
        maxRightHeight = height[right] > maxRightHeight ? height[right] : maxRightHeight;
        right++;
      }
      int minHeight = maxLeftHeight < maxRightHeight ? maxLeftHeight : maxRightHeight;
      totalTrappingRainWater += minHeight - height[mid];
    }
    return totalTrappingRainWater;
  }
}
