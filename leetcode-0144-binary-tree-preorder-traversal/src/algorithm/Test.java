package algorithm;

import java.util.List;
import java.util.stream.Collectors;

/** @author monstervivi */
public class Test {

  public static void main(String[] args) {
    Integer[] values = new Integer[] {1, null, 2, null, null, 3};
    TreeNode root = generateBinaryTree(values);

    testRecursionSolution(root);

    testIterationSolution(root);
  }

  private static TreeNode generateBinaryTree(Integer[] values) {
    return BinaryTreeGenerator.generate(values);
  }

  private static void testRecursionSolution(TreeNode root) {
    RecursionSolution solution = new RecursionSolution();

    List<Integer> result = solution.preorderTraversal(root);

    print(result, "Recursive");
  }

  private static void testIterationSolution(TreeNode root) {
    IterationSolution solution = new IterationSolution();

    List<Integer> result = solution.preorderTraversal(root);

    print(result, "Iterative");
  }

  private static void print(List<Integer> result, String caller) {
    List<String> strResults = result.stream().map(Object::toString).collect(Collectors.toList());

    String resultStr = String.join(",", strResults);

    System.out.println("Using " + caller + " Pre-Order Traversal is: " + resultStr);
  }
}
