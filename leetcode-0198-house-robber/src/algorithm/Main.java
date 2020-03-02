package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int[] nums = new int[] {2, 7, 9, 3, 1};
    System.out.println("using recursive : " + main.robUsingRecursive(nums));
  }

  public int robUsingRecursive(int[] nums) {
    return dfsHelper(nums, nums.length - 1);
  }

  private int dfsHelper(int[] nums, int i) {

    if (i == 0) {
      return nums[i];
    }

    if (i == 1) {
      return Math.max(nums[i - 1], nums[i]);
    }

    return Math.max(dfsHelper(nums, i - 2) + nums[i], dfsHelper(nums, i - 1));
  }
}
