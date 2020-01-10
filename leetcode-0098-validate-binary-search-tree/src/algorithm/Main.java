package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author monstervivi
 */
public class Main {

    private Integer prev;

    public static void main(String[] args) {
        List<TreeNode> treeNodes = (new Main()).initExampleTree();
        treeNodes.forEach(treeNode -> System.out.println((new Main()).isValidBSTUsingRecursion(treeNode)));
        System.out.print("\n");
        treeNodes.forEach(treeNode -> System.out.println((new Main()).isValidBSTUsingInOrder(treeNode)));
    }

    public boolean isValidBSTUsingInOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 遍历左子树
        if (!isValidBSTUsingInOrder(root.left)) {
            return false;
        }
        // 遍历根
        if (prev != null && prev >= root.val) {
            return false;
        }
        prev = root.val;
        // 遍历右子树
        if (!isValidBSTUsingInOrder(root.right)) {
            return false;
        }
        return true;
    }

    public boolean isValidBSTUsingRecursion(TreeNode root) {
        return isValidBSTUsingRecursion(root, null, null);
    }

    // 思路:
    // 通过找到了左子树中最大的数，右子树中最小的数,并判断根节点大于左子树中最大的数，小于右子树中最小的数，来判断树是否为合法的二分查找树
    // 由左子树和右子树决定当前根节点的合法取值范围，相反，根节点决定了左孩子和右孩子的合法取值范围
    // 所以我们可以从根节点进行 DFS，然后计算每个节点应该的取值范围
    // 每次只需更新左子树的取值范围中的最大值和更新右子树的取值范围中的最小值
    //             5(null,null)
    //           /              \
    //          1(null,5)        4(5,null）
    //                         /           \
    //                        3(5,4）        6(5,4)
    private boolean isValidBSTUsingRecursion(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return isValidBSTUsingRecursion(node.left, min, node.val) && isValidBSTUsingRecursion(node.right, node.val, max);
    }

    private List<TreeNode> initExampleTree() {
        List<TreeNode> treeNodes = new LinkedList<>();

        TreeNode treeNodeOneLevel1Left = new TreeNode(1);
        TreeNode treeNodeOneLevel1Right = new TreeNode(3);
        TreeNode treeNodeOneRoot = new TreeNode(2);
        treeNodeOneRoot.left = treeNodeOneLevel1Left;
        treeNodeOneRoot.right = treeNodeOneLevel1Right;
        treeNodes.add(treeNodeOneRoot);

        TreeNode treeNodeTwoLevel2RightRootLeft = new TreeNode(3);
        TreeNode treeNodeTwoLevel2RightRootRight = new TreeNode(6);
        TreeNode treeNodeTwoLevel1Left = new TreeNode(1);
        TreeNode treeNodeTwoLevel1Right = new TreeNode(4);
        treeNodeTwoLevel1Right.left = treeNodeTwoLevel2RightRootLeft;
        treeNodeTwoLevel1Right.right = treeNodeTwoLevel2RightRootRight;
        TreeNode treeNodeTwoRoot = new TreeNode(5);
        treeNodeTwoRoot.left = treeNodeTwoLevel1Left;
        treeNodeTwoRoot.right = treeNodeTwoLevel1Right;
        treeNodes.add(treeNodeTwoRoot);

        TreeNode treeNodeThreeLevel1Left = new TreeNode(1);
        TreeNode treeNodeThreeRoot = new TreeNode(1);
        treeNodeThreeRoot.left = treeNodeThreeLevel1Left;
        treeNodes.add(treeNodeThreeRoot);

        return treeNodes;
    }
}
