package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-09
 */
public class Test {
  public static void main(String[] args) {
    int[] nums = new int[] {2, 3, 1, 2, 4, 3};
    int target = 7;
    System.out.println("Array is: " + Arrays.toString(nums));
    System.out.println("Target is: " + target);

    testBruteForceSolution(target, nums);

    testSlidingWindowSolution(target, nums);

    testPrefixSumAndBinarySearchSolution(target, nums);
  }

  private static void testBruteForceSolution(int target, int[] nums) {
    System.out.println("----------testBruteForceSolution----------");
    BruteForceSolution solution = new BruteForceSolution();
    System.out.println("min sub-array length is: " + solution.minSubArrayLen(target, nums));
  }

  private static void testSlidingWindowSolution(int target, int[] nums) {
    System.out.println("----------testSlidingWindowSolution----------");
    SlidingWindowSolution solution = new SlidingWindowSolution();
    System.out.println("min sub-array length is: " + solution.minSubArrayLen(target, nums));
  }

  private static void testPrefixSumAndBinarySearchSolution(int target, int[] nums) {
    System.out.println("----------testPrefixSumAndBinarySearchSolution----------");
    PrefixSumAndBinarySearchSolution solution = new PrefixSumAndBinarySearchSolution();
    System.out.println("min sub-array length is: " + solution.minSubArrayLen(target, nums));
  }
}
