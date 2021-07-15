package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class Test {
  public static void main(String[] args) {
    int[] nums1 = new int[] {3, 2, 1, 5, 6, 4};
    int k1 = 2;
    testMaxHeapSolution(nums1, k1);

    int[] nums2 = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k2 = 4;
    testMaxHeapSolution(nums2, k2);
  }

  private static void testMaxHeapSolution(int[] nums, int k) {
    System.out.println("----------testMaxHeapSolution----------");
    print(nums, k);
    MaxHeapSolution solution = new MaxHeapSolution();
    System.out.println(
        "the k(" + k + ") th largest element is: " + solution.findKthLargest(nums, k));
    System.out.println(Arrays.toString(nums));
  }

  private static void print(int[] nums, int k) {
    System.out.println("nums is: " + Arrays.toString(nums));
    System.out.println("k is: " + k);
  }
}
