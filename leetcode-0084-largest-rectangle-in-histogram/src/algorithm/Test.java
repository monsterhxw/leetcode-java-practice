package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-12
 */
public class Test {

  public static void main(String[] args) {
    int[] heights = new int[] {2, 1, 5, 6, 2, 3};
    System.out.println("heights is: " + Arrays.toString(heights));

    testBruteForceFixedWidthSolution(heights);

    testBruteForceFixedHeightSolution(heights);
  }

  private static void testBruteForceFixedWidthSolution(int[] heights) {
    System.out.println("----------testBruteForceFixedWidthSolution----------");
    BruteForceFixedWidthSolution solution = new BruteForceFixedWidthSolution();
    System.out.println("largest rectangle area is: " + solution.largestRectangleArea(heights));
  }

  private static void testBruteForceFixedHeightSolution(int[] heights) {
    System.out.println("----------testBruteForceFixedHeightSolution----------");
    BruteForceFixedHeightSolution solution = new BruteForceFixedHeightSolution();
    System.out.println("largest rectangle area is: " + solution.largestRectangleArea(heights));
  }
}
