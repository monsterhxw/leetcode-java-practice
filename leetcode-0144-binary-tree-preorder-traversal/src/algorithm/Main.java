package algorithm;

import java.util.ArrayList;
import java.util.List;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {

  }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    dfsHelper(root, res);

    return res;
  }

  private void dfsHelper(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }

    res.add(root.val);

    dfsHelper(root.left, res);
    dfsHelper(root.right, res);
  }
}
