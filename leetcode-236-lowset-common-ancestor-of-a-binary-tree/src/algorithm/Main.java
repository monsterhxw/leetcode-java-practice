package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = main.createBinaryTree();
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        TreeNode lowestCommonAncestor = main.lowestCommonAncestor(root, p, q);
        System.out.println(
            "The lowest common ancestor of p (" + p.val + ") and q (" + q.val + ") is " + lowestCommonAncestor.val
                + ", using recursive solution.\n");
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode findPOrQInLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findPOrQInRight = lowestCommonAncestor(root.right, p, q);
        if (findPOrQInLeft == null) {
            return findPOrQInRight;
        }
        if (findPOrQInRight == null) {
            return findPOrQInLeft;
        }
        return root;
    }

    private TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        return root;
    }
}
