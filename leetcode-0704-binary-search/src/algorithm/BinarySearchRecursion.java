package algorithm;

/**
 * @author XueweiHuang
 */
public class BinarySearchRecursion {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 6;
        System.out.println("target:" + target + ", found index:" + search(nums, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearchRecur(nums, target, 0, nums.length - 1);
    }

    public static int binarySearchRecur(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchRecur(nums, target, mid + 1, high);
        } else {
            return binarySearchRecur(nums, target, low, mid - 1);
        }
    }
}