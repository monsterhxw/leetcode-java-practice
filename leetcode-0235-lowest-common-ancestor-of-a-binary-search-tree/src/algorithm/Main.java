package algorithm;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        int[] elements = new int[]{6, 2, 8, 0, 4, 7, 9, 3, 5};
        Main main = new Main();
        TreeNode root = main.createBST(elements);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode ancestorUsingRecursive = main.lowestCommonAncestorUsingRecursive(root, p, q);
        System.out.println(
            "The lowest common ancestor of p (" + p.val + ") and q (" + q.val + ") is " + ancestorUsingRecursive.val
                + ", using recursive solution.\n");

        TreeNode ancestorUsingIterative = main.lowestCommonAncestorUsingIterative(root, p, q);
        System.out.println(
            "The lowest common ancestor of p (" + p.val + ") and q (" + q.val + ") is " + ancestorUsingIterative.val
                + ", using iterative solution.\n");
    }

    public TreeNode lowestCommonAncestorUsingRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorUsingRecursive(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorUsingRecursive(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestorUsingIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    public TreeNode createBST(int[] elements) {
        TreeNode root = null;
        for (int i = 0; i < elements.length; i++) {
            root = addRecursive(root, elements[i]);
        }
        return root;
    }

    private TreeNode addRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val >= val) {
            node.left = addRecursive(node.left, val);
        } else {
            node.right = addRecursive(node.right, val);
        }
        return node;
    }
}
