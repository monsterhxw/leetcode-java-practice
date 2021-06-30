package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-06-30
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {2, 7, 11, 15};
    System.out.print("nums is: ");
    Arrays.stream(nums).forEach(System.out::print);
    System.out.println();
    int target = 9;
    System.out.println("target is: " + target);

    testBruteForceSolution(nums, target);

    testHashTableSolution(nums, target);
  }

  private static void testBruteForceSolution(int[] nums, int target) {
    System.out.println("----------testBruteForceSolution----------");
    BruteForceSolution solution = new BruteForceSolution();
    int[] result = solution.twoSum(nums, target);
    System.out.println("result is: ");
    Arrays.stream(result).forEach(System.out::print);
    System.out.println();
  }

  private static void testHashTableSolution(int[] nums, int target) {
    System.out.println("----------testHashTableSolution----------");
    HashtableSolution solution = new HashtableSolution();
    int[] result = solution.twoSum(nums, target);
    System.out.println("result is: ");
    Arrays.stream(result).forEach(System.out::print);
    System.out.println();
  }
}
