package algorithm;

/** @author monstervivi */
public class TreeNode {

  int val;

  TreeNode left;

  TreeNode right;

  TreeNode() {}

  TreeNode(int val) {
    this(val, null, null);
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
