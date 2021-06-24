package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author XueweiHuang
 * @created 2021-06-24
 */
public class IterationSolution {

  public List<Integer> preorderTraversal(TreeNode root) {

    List<Integer> res = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    TreeNode dummy =  root;

    while (dummy != null || !stack.isEmpty()){
      while (dummy != null) {
        res.add(dummy.val);
        stack.push(dummy);
        dummy = dummy.left;
      }
      dummy = stack.pop();
      dummy = dummy.right;
    }

    return res;
  }
}
