package algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = main.createBinaryTree();
        System.out.println("using DFS : " + main.minDepthUsingDFS(root));
        System.out.println("using optimizing DFS : " + main.minDepthUsingOptimizingDFS(root));
        System.out.println("using BFS : " + main.minDepthUsingBFS(root));
    }

    // 需要判断一下左节点或者右节点是否为 null
    // 因为如果根的左节点或者右节点为 null
    // 是不满足根到叶子节点这个定义的
    public int minDepthUsingOptimizingDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepthUsingOptimizingDFS(root.left);
        int rightMinDepth = minDepthUsingOptimizingDFS(root.right);
        // 根据题目是根节点到最近到叶子节点，所以不可以直接取 min(left, right) 的值
        // leftMinDepth == 0 || leftMinDepth == 0 成立
        // 说明要么只有左子树要么只有右子树，所以我们返回 leftMinDepth + leftMinDepth + 1，这样返回的是存在的子节点的最小深度路径 + 1（本节点深度）
        // 如果左右子树都不为空，那么返回 Math.min(leftMinDepth, rightMinDepth)
        return (leftMinDepth == 0 || rightMinDepth == 0) ? leftMinDepth + rightMinDepth + 1 : 1 + Math.min(leftMinDepth, rightMinDepth);
    }

    public int minDepthUsingDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果没有左子树，只需要考虑右子树
        if (root.left == null) {
            return 1 + minDepthUsingDFS(root.right);
        }
        // 如果没有右子树，只需要考虑左子树
        if (root.right == null) {
            return 1 + minDepthUsingDFS(root.left);
        }

        // divide and conquer
        // 如果有左右子树，找出左右子树的最小 depth
        int leftMinDepth = minDepthUsingDFS(root.left);
        int rightMinDepth = minDepthUsingDFS(root.right);

        // process subproblems' results
        int result = 1 + Math.min(leftMinDepth, rightMinDepth);

        return result;
    }

    public int minDepthUsingBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.left == null) {
                    return depth;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
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
