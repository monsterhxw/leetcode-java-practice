package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-24
 */
public class TwoPointersSolution {
  /** Time Complexity: O(n); Space Complexity: O(1) */
  public int trap(int[] height) {
    int trapped = 0;
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] > leftMax) {
          leftMax = height[left];
        } else {
          trapped += leftMax - height[left];
        }
        left++;
      } else {
        if (height[right] > rightMax) {
          rightMax = height[right];
        } else {
          trapped += rightMax - height[right];
        }
        right--;
      }
    }
    return trapped;
  }
}
