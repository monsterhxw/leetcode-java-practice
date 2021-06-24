package algorithm;

import com.sun.tools.javac.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** @author monstervivi */
public class Test {

  public static void main(String[] args) {
    Integer[] values = new Integer[] {1, null, 2, null, null, 3};
    TreeNode root = generateBinaryTree(values);

    testRecursionSolution(root);
  }

  private static TreeNode generateBinaryTree(Integer[] values) {
    return BinaryTreeGenerator.generate(values);
  }

  private static void testRecursionSolution(TreeNode root) {
    RecursionSolution solution = new RecursionSolution();
    List<Integer> result = solution.preorderTraversal(root);

    List<String> strResults = result.stream().map(Object::toString).collect(Collectors.toList());
    String resultStr = String.join(",", strResults);

    System.out.println("Using Recursive Pre-Order Traversal is: " + resultStr);
  }
}
