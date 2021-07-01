package algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @author XueweiHuang
 * @created 2021-06-30
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
    System.out.println("nums is: " + Arrays.toString(nums));

    testBruteForceSolution(nums);

    testTwoPointersSolution(nums);
  }

  private static void testBruteForceSolution(int[] nums) {
    System.out.println("----------testBruteForceSolution----------");
    BruteForceSolution solution = new BruteForceSolution();
    List<List<Integer>> result = solution.threeSum(nums);
    System.out.println(result);
  }

  private static void testTwoPointersSolution(int[] nums) {
    System.out.println("----------testTwoPointersSolution----------");
    TwoPointersSolution solution = new TwoPointersSolution();
    List<List<Integer>> result = solution.threeSum(nums);
    System.out.println(result);
  }
}
