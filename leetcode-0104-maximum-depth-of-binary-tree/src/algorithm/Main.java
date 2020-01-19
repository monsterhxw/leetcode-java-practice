package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = main.createBinaryTree();
        System.out.println("using DFS : " + main.maxDepthUsingDFS(root));
    }

    public int maxDepthUsingDFS(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepthUsingDFS(root.left), maxDepthUsingDFS(root.right));
    }

    private TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(4);
        return root;
    }
}
