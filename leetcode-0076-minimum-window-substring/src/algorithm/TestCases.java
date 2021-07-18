package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-18
 */
public class TestCases {
  public static void main(String[] args) {
    String s = "DBADBECCODEBANCC";
    System.out.println("string s is: \"" + s + "\"");
    String t = "ABCC";
    System.out.println("string t is: \"" + t + "\"");

    testSlidingWindowWithDistanceIncreasingSolution(s, t);
  }

  private static void testSlidingWindowWithDistanceIncreasingSolution(String s, String t) {
    System.out.println("----------testSlidingWindowWithDistanceIncreasingSolution----------");
    SlidingWindowWithDistanceIncreasingSolution solution =
        new SlidingWindowWithDistanceIncreasingSolution();
    System.out.println("min window result is: " + "\"" + solution.minWindow(s, t) + "\"");
  }
}
