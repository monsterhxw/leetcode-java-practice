package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-preorder-traversal/">Binary Tree
 *     Preorder Traversal</a>
 * @author XueweiHuang
 * @created 2021-06-24
 */
public class RecursionSolution {

  public static void main(String[] args) {
  }

  public List<Integer> preorderTraversal(TreeNode root) {

    List<Integer> resultList = new ArrayList<>();

    recursivePreorderTraversal(root, resultList);

    return resultList;
  }

  private void recursivePreorderTraversal(TreeNode root, List<Integer> resultList) {
    // recursion terminator
    if (null == root) {
      return;
    }

    // process logic in current level
    resultList.add(root.val);

    // drill down
    recursivePreorderTraversal(root.left, resultList);
    recursivePreorderTraversal(root.right, resultList);
  }
}