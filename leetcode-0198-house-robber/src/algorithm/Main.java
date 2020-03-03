package algorithm;

import java.util.Arrays;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int[] nums = new int[] {2, 7, 9, 3, 1};
    System.out.println("using recursive : " + main.robUsingRecursiveAndMemoization(nums));
    System.out.println("using dynamic programming : " + main.robUsingDP(nums));
    System.out.println(
        "using dynamic programming optimization: " + main.robUsingDPOptimization(nums));
  }

  public int robUsingDPOptimization(int[] nums) {
    int preMax = 0;
    int curMax = 0;

    for (int num : nums) {
      int temp = curMax;
      curMax = Math.max(preMax + num, curMax);
      preMax = temp;
    }

    return curMax;
  }

  public int robUsingDP(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int[] memoization = new int[nums.length];
    memoization[0] = nums[0];
    memoization[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      memoization[i] = Math.max(memoization[i - 2] + nums[i], memoization[i - 1]);
    }

    return memoization[memoization.length - 1];
  }

  public int robUsingRecursiveAndMemoization(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, -1);
    return dfsHelper(nums, 0, memo);
  }

  private int dfsHelper(int[] nums, int i, int[] memo) {
    if (i >= nums.length) {
      return 0;
    }

    if (memo[i] != -1) {
      return memo[i];
    }

    memo[i] = Math.max(nums[i] + dfsHelper(nums, i + 2, memo), dfsHelper(nums, i + 1, memo));

    return memo[i];
  }
}
