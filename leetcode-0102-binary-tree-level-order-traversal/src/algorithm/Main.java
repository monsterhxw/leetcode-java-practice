package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = main.createBinaryTree();
        System.out.println("using BFS : " + main.levelOrderUsingBFS(root));
        System.out.println("using DFS : " + main.levelOrderUsingDFS(root));
    }

    public List<List<Integer>> levelOrderUsingDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsHelper(root, 0, result);
        return result;
    }

    private void dfsHelper(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(node.val);

        dfsHelper(node.left, level + 1, result);
        dfsHelper(node.right, level + 1, result);
    }

    public List<List<Integer>> levelOrderUsingBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // Set<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public TreeNode createBinaryTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
}
