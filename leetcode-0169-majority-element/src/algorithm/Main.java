package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println("using map : " + (new Main()).majorityElementUsingMap(nums));
        System.out.println("using boyer moore : " + (new Main()).majorityElementUsingBoyerMoore(nums));
        System.out.println("using divide and conquer : " + (new Main()).majorityElementUsingDivideAndConquer(nums));
    }

    // 设置两个变量 candidate 和 count，candidate 用来保存数组中遍历到的某个数字
    // count 表示当前数字的出现次数，一开始 candidate 保存为数组中的第一个数字，count 为 1
    // 遍历整个数组
    // 如果数字与之前 candidate 保存的数字相同，则 count 加 1
    // 如果数字与之前 candidate 保存的数字不同，则 count 减 1
    // 如果出现次数 count 变为 0 ，candidate 进行变化，保存为当前遍历的那个数字，并且同时把 count 重置为 1
    // 遍历完数组中的所有数字即可得到结果
    public int majorityElementUsingBoyerMoore(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public int majorityElementUsingMap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        int majority = -1;
        int majorityCount = -1;
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
            if (countMap.get(nums[i]) > majorityCount) {
                majorityCount = countMap.get(nums[i]);
                majority = nums[i];
            }
        }
        return majority;
    }

    public int majorityElementUsingDivideAndConquer(int[] nums) {
        return majorityElementUsingDivideAndConquer(nums, 0, nums.length - 1);
    }

    private int majorityElementUsingDivideAndConquer(int[] nums, int low, int high) {
        // 基本情况，当数组大小为 1 时，这个元素就是众数
        if (low == high) {
            return nums[low];
        }
        int mid = (high - low) / 2 + low;
        int left = majorityElementUsingDivideAndConquer(nums, low, mid);
        int right = majorityElementUsingDivideAndConquer(nums, mid + 1, high);
        // 如果 left 和 right 中的众数相同，那么返回这个众数
        if (left == right) {
            return left;
        }
        // 否则，对每个元素进行计数，并返回众数
        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
