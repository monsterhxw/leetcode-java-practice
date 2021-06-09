package algorithm;

/**
 * @author XueweiHuang
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println("target:" + target + ", found index:" + search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int mid;
        int high = nums.length - 1;
        while (low <= high) {
            // prevent integer-overflow
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}