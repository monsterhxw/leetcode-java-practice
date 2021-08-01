package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-08-01
 */
public class TestCases {
  public static void main(String[] args) {
    String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
    System.out.println(Arrays.toString(strs));

    testSortSolution(strs);

    testCounterSolution(strs);
  }

  private static void testSortSolution(String[] strs) {
    System.out.println("----------testSortSolution----------");
    SortSolution solution = new SortSolution();
    System.out.println("Output: " + solution.groupAnagrams(strs).toString());
  }

  private static void testCounterSolution(String[] strs) {
    System.out.println("----------testCounterSolution----------");
    CounterSolution solution = new CounterSolution();
    System.out.println("Output: " + solution.groupAnagrams(strs).toString());
  }
}
