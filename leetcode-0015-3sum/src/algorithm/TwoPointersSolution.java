package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XueweiHuang
 * @created 2021-07-01
 */
public class TwoPointersSolution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    // first, to sort the array
    Arrays.sort(nums);

    // 枚举 nums[first]
    // notice: for 循环的结束条件为 'i < nums.length - 2 && nums[i] <= 0'
    // 因为 nums 数组已经排序好了，如果 nums[i] 大于 0，就不会存在 nums[first] + nums[second] + nums[third] == 0 了
    for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
      // skip duplicates
      if (i == 0 || nums[i] != nums[i - 1]) {
        int leftPtr = i + 1;
        int rightPtr = nums.length - 1;
        int twoSum = 0 - nums[i];
        while (leftPtr < rightPtr) {
          if (nums[leftPtr] + nums[rightPtr] == twoSum) {
            result.add(new ArrayList<>(Arrays.asList(nums[i], nums[leftPtr], nums[rightPtr])));
            leftPtr++;
            rightPtr--;
            // improve : skip duplicates
            while (leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr - 1]) {
              leftPtr++;
            }
            while (leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr + 1]) {
              rightPtr--;
            }
          } else if (nums[leftPtr] + nums[rightPtr] < twoSum) {
            // improve : skip duplicates
            while (leftPtr < rightPtr && nums[leftPtr] == nums[leftPtr + 1]) {
              leftPtr++;
            }
            leftPtr++;
          } else {
            // nums[leftPtr] + nums[rightPtr] > twoSum
            // improve : skip duplicates
            while (leftPtr < rightPtr && nums[rightPtr] == nums[rightPtr - 1]) {
              rightPtr--;
            }
            rightPtr--;
          }
        }
      }
    }

    return result;
  }
}
