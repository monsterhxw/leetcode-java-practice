package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-24
 */
public class DynamicProgrammingSolution {
  /** Time Complexity: O(n); Space Complexity: O(n); */
  public int trap(int[] height) {
    if (height.length <= 2) {
      return 0;
    }
    int total = 0;
    int[] leftMaxHeights = new int[height.length];
    int[] rightMaxHeights = new int[height.length];
    leftMaxHeights[0] = height[0];
    rightMaxHeights[height.length - 1] = height[height.length - 1];
    for (int left = 1; left < height.length; left++) {
      leftMaxHeights[left] =
          height[left] > leftMaxHeights[left - 1] ? height[left] : leftMaxHeights[left - 1];
    }
    for (int right = height.length - 2; right >= 0; right--) {
      rightMaxHeights[right] =
          height[right] > rightMaxHeights[right + 1] ? height[right] : rightMaxHeights[right + 1];
    }
    for (int mid = 0; mid < height.length; mid++) {
      int minHeight =
          leftMaxHeights[mid] < rightMaxHeights[mid] ? leftMaxHeights[mid] : rightMaxHeights[mid];
      total = total + minHeight - height[mid];
    }
    return total;
  }
}
