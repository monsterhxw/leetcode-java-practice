package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-06-28
 */
public class Test {

  public static void main(String[] args) {
    int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.print("Height Array is: ");
    Arrays.stream(height).forEach(System.out::print);
    System.out.println();
    testTwoPointersSolution(height);
    testBruteForceSolution(height);
  }

  public static void testTwoPointersSolution(int[] height) {
    System.out.println("----------test TwoPointersSolution----------");
    TwoPointersSolution solution = new TwoPointersSolution();
    int maxArea = solution.maxArea(height);
    System.out.println("Maximum Area is: " + maxArea);
    System.out.println();
  }

  public static void testBruteForceSolution(int[] height) {
    System.out.println("----------testBruteForceSolution----------");
    BruteForceSolution solution = new BruteForceSolution();
    int maxArea = solution.maxArea(height);
    System.out.println("Maximum Area is: " + maxArea);
    System.out.println();
  }
}
