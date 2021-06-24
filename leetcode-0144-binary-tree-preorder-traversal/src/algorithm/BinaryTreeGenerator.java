package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-24
 */
public class BinaryTreeGenerator {

  public static TreeNode generate(Integer[] values) {
    return arrayToBinaryTree(values, null, 0);
  }

  private static TreeNode arrayToBinaryTree(Integer[] values, TreeNode root, int index) {

    if (index < values.length) {

      if (null == values[index]) {
        return null;
      }

      TreeNode dummy = new TreeNode(values[index]);
      root = dummy;

      root.left = arrayToBinaryTree(values, root.left, (2 * index) + 1);
      root.right = arrayToBinaryTree(values, root.right, (2 * index) + 2);
    }

    return root;
  }
}
