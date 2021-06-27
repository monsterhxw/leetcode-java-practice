package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-06-28
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {0, 1, 0, 3, 12, 0, 1, 1, 1};
    Arrays.stream(nums).forEach(System.out::print);
    System.out.println();
    testTwoPointersSolution(nums);
    Arrays.stream(nums).forEach(System.out::print);
    System.out.println();

    nums = new int[] {0, 1, 0, 3, 12, 0, 1, 1, 1};
    testTwoLoopSolution(nums);
    Arrays.stream(nums).forEach(System.out::print);
    System.out.println();
  }

  private static void testTwoPointersSolution(int[] nums) {
    System.out.println("----------------testTwoPointersSolution----------------");
    TwoPointersSolution solution = new TwoPointersSolution();
    solution.moveZeroes(nums);
  }

  private static void testTwoLoopSolution(int[] nums) {
    System.out.println("----------------testTwoLoopSolution----------------");
    TwoLoopSolution solution = new TwoLoopSolution();
    solution.moveZeroes(nums);
  }
}
