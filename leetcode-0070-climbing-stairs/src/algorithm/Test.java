package algorithm;

/** @author monstervivi */
public class Test {

  public static void main(String[] args) {
    int n = 8;
    System.out.println("n is: " + n);

    testRecursionSolution(n);

    testTailRecursionSolution(n);

    testDynamicProgrammingSolution(n);

    testDynamicProgrammingOptimizationSolution(n);

    testMemoizationSolution(n);
  }

  private static void testRecursionSolution(int n) {
    System.out.println("----------testRecursionSolution----------");
    RecursionSolution solution = new RecursionSolution();
    System.out.println("There are {" + solution.climbStairs(n) + "} way to climb to the top!");
  }

  private static void testTailRecursionSolution(int n) {
    System.out.println("----------testTailRecursionSolution----------");
    TailRecursionSolution solution = new TailRecursionSolution();
    System.out.println("There are {" + solution.climbStairs(n) + "} way to climb to the top!");
  }

  private static void testDynamicProgrammingSolution(int n) {
    System.out.println("----------testDynamicProgrammingSolution----------");
    DynamicProgrammingSolution solution = new DynamicProgrammingSolution();
    System.out.println("There are {" + solution.climbStairs(n) + "} way to climb to the top!");
  }

  private static void testDynamicProgrammingOptimizationSolution(int n) {
    System.out.println("----------testDynamicProgrammingOptimizationSolution----------");
    DynamicProgrammingOptimizationSolution solution = new DynamicProgrammingOptimizationSolution();
    System.out.println("There are {" + solution.climbStairs(n) + "} way to climb to the top!");
  }

  private static void testMemoizationSolution(int n) {
    System.out.println("----------testMemoizationSolution----------");
    MemoizationSolution solution = new MemoizationSolution();
    System.out.println("There are {" + solution.climbStairs(n) + "} way to climb to the top!");
  }
}
