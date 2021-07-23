package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-23
 */
public class TestCases {
  public static void main(String[] args) {
    int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println("height is: " + Arrays.toString(height));

    testBruteForceSolution(height);
  }

  private static void testBruteForceSolution(int[] height) {
    System.out.println("----------testBruteForceSolution----------");
    BruteForceSolution solution = new BruteForceSolution();
    System.out.println(
        "In this case, [" + solution.trap(height) + "] units of rain water are being trapped.");
  }
}
