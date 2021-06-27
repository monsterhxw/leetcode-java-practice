package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-28
 */
public class TwoLoopSolution {

  public void moveZeroes(int[] nums) {
    int nonZeroCounter = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[nonZeroCounter] = nums[i];
        nonZeroCounter++;
      }
    }

    while (nonZeroCounter < nums.length) {
      nums[nonZeroCounter] = 0;
      nonZeroCounter++;
    }
  }
}
