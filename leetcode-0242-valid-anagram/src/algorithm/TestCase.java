package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-27
 */
public class TestCase {
  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    System.out.println("Input s = \"" + s + "\", t = \"" + t + "\"");

    testHashtableSolution(s, t);
  }

  private static void testHashtableSolution(String s, String t) {
    System.out.println("----------testHashtableSolution----------");
    HashtableSolution solution = new HashtableSolution();
    System.out.println("Result is: " + solution.isAnagram(s, t));
  }
}
