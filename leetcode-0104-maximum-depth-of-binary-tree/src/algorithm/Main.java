package algorithm;

import com.sun.tools.hat.internal.model.Root;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = main.createBinaryTree();
        System.out.println("using DFS : " + main.maxDepthUsingDFS(root));
        System.out.println("using BFS : " + main.maxDepthUsingBFS(root));
    }

    public int maxDepthUsingDFS(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepthUsingDFS(root.left), maxDepthUsingDFS(root.right));
    }

    public int maxDepthUsingBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            depth++;
        }
        return depth;
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
