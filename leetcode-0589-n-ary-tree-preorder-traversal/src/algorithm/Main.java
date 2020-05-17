package algorithm;

import java.util.ArrayList;
import java.util.List;

/** @author monstervivi */
public class Main {

  /** Definition for a Node. */
  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  static class Solution {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> preorderUsingRecursive(Node root) {
      dfsHelper(root);
      return res;
    }

    private void dfsHelper(Node root) {
      if (root == null) {
        return;
      }

      res.add(root.val);

      if (root.children == null) {
        return;
      }

      for (Node child : root.children) {
        dfsHelper(child);
      }
    }
  }

  public static void main(String[] args) {

  }
}
