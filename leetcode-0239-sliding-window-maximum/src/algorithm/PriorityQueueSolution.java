package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author XueweiHuang
 * @created 2021-07-13
 */
public class PriorityQueueSolution {
  /** Time Complexity: O(nlogn); Space Complexity: O(n); */
  public int[] maxSlidingWindow(int[] nums, int k) {
    // pair[0] = num; pair[1] = index;
    PriorityQueue<int[]> maxHeap =
        new PriorityQueue<>(
            new Comparator<int[]>() {
              @Override
              public int compare(int[] pair1, int[] pair2) {
                // 值大排最前面，两者值相同，index 大的排前面;
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
              }
            });
    // 有 nums.length - k + 1 个
    int[] maxNums = new int[nums.length - k + 1];
    // 初始化前 K 的元素到堆中
    for (int i = 0; i < k; i++) {
      maxHeap.offer(new int[] {nums[i], i});
    }
    // 将第一个窗口最大值放入 maxNums 数组中
    maxNums[0] = maxHeap.peek()[0];
    // sliding window
    int right = k;
    int left = 1;
    while (right < nums.length) {
      maxHeap.offer(new int[] {nums[right], right});
      while (maxHeap.peek()[1] < left) {
        maxHeap.poll();
      }
      maxNums[left] = maxHeap.peek()[0];
      right++;
      left++;
    }
    return maxNums;
  }
}
