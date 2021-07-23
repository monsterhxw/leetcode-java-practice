package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XueweiHuang
 * @created 2021-07-24
 */
public class MonotonicStackSolution {
  /** Time Complexity: O(n); Space Complexity: O(n) */
  public int trap(int[] height) {
    int totalTrapped = 0;
    Deque<Integer> stack = new ArrayDeque<>(height.length);
    for (int right = 0; right < height.length; right++) {
      while (!stack.isEmpty() && height[right] > height[stack.peek()]) {
        int mid = stack.pop();
        if (!stack.isEmpty()) {
          int left = stack.peek();
          int width = right - left - 1;
          int minHeight = height[left] < height[right] ? height[left] : height[right];
          int boundedHeight = minHeight - height[mid];
          totalTrapped += width * boundedHeight;
        }
      }
      stack.push(right);
    }
    return totalTrapped;
  }
}
