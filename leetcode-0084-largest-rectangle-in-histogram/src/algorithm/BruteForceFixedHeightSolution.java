package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-12
 */
public class BruteForceFixedHeightSolution {
  /** Time Complexity: O(n^2); Space Complexity: O(1); */
  public int largestRectangleArea(int[] heights) {
    int largestArea = 0;
    for (int mid = 0; mid < heights.length; mid++) {
      // fixed height
      int height = heights[mid];
      int left = mid;
      int right = mid;
      // 确定左右边界
      while (left - 1 >= 0 && heights[left - 1] >= height) {
        left--;
      }
      while (right + 1 < heights.length && heights[right + 1] >= height) {
        right++;
      }
      int width = right - left + 1;
      int area = height * width;
      largestArea = area > largestArea ? area : largestArea;
    }
    return largestArea;
  }
}
