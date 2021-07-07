package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-07
 */
public class Test {
  public static void main(String[] args) {
    String parentheses = "{{({[[()]]})}}";
    System.out.println("The Parentheses is \"" + parentheses + "\"");

    testHashtableAndStackSolution(parentheses);

    testStackSolution(parentheses);

    testBruteForceSolution(parentheses);
  }

  private static void testHashtableAndStackSolution(String parentheses) {
    System.out.println("----------testHashtableAndStackSolution----------");
    HashtableAndStackSolution solution = new HashtableAndStackSolution();
    System.out.println("is Valid? \"" + solution.isValid(parentheses) + "\"");
  }

  private static void testStackSolution(String parentheses) {
    System.out.println("----------testStackSolution----------");
    StackSolution solution = new StackSolution();
    System.out.println("is Valid? \"" + solution.isValid(parentheses) + "\"");
  }

  private static void testBruteForceSolution(String parentheses) {
    System.out.println("----------testBruteForceSolution----------");
    BruteForceSolution solution = new BruteForceSolution();
    System.out.println("is Valid? \"" + solution.isValid(parentheses) + "\"");
  }
}
