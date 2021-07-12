package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-13
 */
public class Test {
  public static void main(String[] args) {
    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    System.out.println("nums is: " + Arrays.toString(nums));
    System.out.println("k is: " + k);

    testPriorityQueueSolution(nums, k);
  }

  private static void testPriorityQueueSolution(int[] nums, int k) {
    System.out.println("----------testPriorityQueueSolution----------");
    PriorityQueueSolution solution = new PriorityQueueSolution();
    System.out.println(
        "max sliding window result is: " + Arrays.toString(solution.maxSlidingWindow(nums, k)));
  }
}
