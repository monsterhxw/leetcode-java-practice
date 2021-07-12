package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XueweiHuang
 * @created 2021-07-12
 */
public class MonotonicStackSolution {
  /** Sentinel & Monotonic Stack; Time Complexity: O(n); Space Complexity: O(n); */
  public int largestRectangleArea(int[] heights) {
    int largestArea = 0;
    // sentinel: two 0 heights
    int[] sentinels = new int[heights.length + 2];
    sentinels[0] = 0;
    System.arraycopy(heights, 0, sentinels, 1, heights.length);
    sentinels[sentinels.length - 1] = 0;
    // monotonic stack
    Deque<Integer> stack = new ArrayDeque<>();
    // iterate sentinels array
    for (int right = 0; right < sentinels.length; right++) {
      while (!stack.isEmpty() && sentinels[right] < sentinels[stack.peek()]) {
        int height = sentinels[stack.pop()];
        int left = stack.peek();
        int width = right - (left + 1);
        int area = height * width;
        largestArea = area > largestArea ? area : largestArea;
      }
      stack.push(right);
    }
    return largestArea;
  }
}
