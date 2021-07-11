package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-12
 */
public class BruteForceFixedWidthSolution {

  /** Time Complexity: O(n^2); Space Complexity: O(1); */
  public int largestRectangleArea(int[] heights) {
    int largestArea = 0;
    for (int left = 0; left < heights.length; left++) {
      int minHeight = heights[left];
      for (int right = left; right < heights.length; right++) {
        minHeight = heights[right] < minHeight ? heights[right] : minHeight;
        int width = right - left + 1;
        int area = minHeight * width;
        largestArea = area > largestArea ? area : largestArea;
      }
    }
    return largestArea;
  }
}
