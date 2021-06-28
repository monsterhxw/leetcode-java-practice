package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-28
 */
public class TwoPointersSolution {

  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    while (left < right) {
      int area = 0;
      if (height[left] <= height[right]) {
       area = height[left] * (right - left);
       left++;
      } else {
        area = height[right] * (right - left);
        right--;
      }
      maxArea = area > maxArea ? area : maxArea;
    }
    return maxArea;
  }
}
