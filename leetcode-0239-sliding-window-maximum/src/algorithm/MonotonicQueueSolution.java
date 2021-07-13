package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author XueweiHuang
 * @created 2021-07-13
 */
public class MonotonicQueueSolution {
  /** Monotonic Queue (Deque) Solution; Time Complexity: O(n); Space Complexity: O(n); */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] maxNums = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>(nums.length);
    // initial deque
    for (int i = 0; i < k; i++) {
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }
    // initial maxNums[0]
    maxNums[0] = nums[deque.peekFirst()];
    // sliding window
    int left = 1;
    int right = k;
    while (right < nums.length) {
      while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
        deque.pollLast();
      }
      deque.offerLast(right);
      while (deque.peekFirst() < left) {
        deque.pollFirst();
      }
      maxNums[left] = nums[deque.peekFirst()];
      right++;
      left++;
    }
    return maxNums;
  }
}
