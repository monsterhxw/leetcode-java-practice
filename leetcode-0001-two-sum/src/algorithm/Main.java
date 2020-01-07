package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 黄学维
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        print((new Main()).twoSumUsingForeach(nums, target));
        print((new Main()).twoSumUsingHashtable(nums, target));
    }

    public int[] twoSumUsingForeach(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumUsingHashtable(int[] nums, int target) {
        Map<Integer, Integer> dummy = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (dummy.containsKey(target - nums[i])) {
                return new int[]{dummy.get(target - nums[i]), i};
            }
            dummy.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static void print(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
