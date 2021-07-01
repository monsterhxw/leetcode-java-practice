package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author XueweiHuang
 * @created 2021-06-30
 */
public class BruteForceSolution {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      // skip duplicates
      if (i == 0 || nums[i] != nums[i - 1]) {
        for (int j = i + 1; j < nums.length - 1; j++) {
          // skip duplicates
          if (j == i + 1 || nums[j] != nums[j - 1]) {
            for (int k = j + 1; k < nums.length; k++) {
              // skip duplicates
              if (k == j + 1 || nums[k] != nums[k - 1]) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                  result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                }
              }
            }
          }
        }
      }
    }

    return result;
  }
}
