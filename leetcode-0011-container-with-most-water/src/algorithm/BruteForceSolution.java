package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-29
 */
public class BruteForceSolution {

  public int maxArea(int[] height) {
    int maxArea = 0;
    for (int i = 0; i < height.length - 1; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int area = height[i] <= height[j] ? height[i] * (j - i) : height[j] * (j - i);
        maxArea = area > maxArea ? area : maxArea;
      }
    }
    return maxArea;
  }
}
