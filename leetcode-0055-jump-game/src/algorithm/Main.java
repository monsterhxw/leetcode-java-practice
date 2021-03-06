package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int[] nums = new int[] {3, 2, 1, 0, 4};

    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();

    System.out.println("using recursion, result is : " + main.canJumpUsingRecursion(nums));

    System.out.println(
        "using memoization search, result is : " + main.canJumpUsingMemoizationSearch(nums));

    System.out.println(
        "using dynamic programming, result is : "
            + main.canJumpUsingDynamicProgrammingApproach(nums));

    System.out.println(
        "using greedy approach, result is : "
            + main.canJumpUsingGreedyApproach(nums));
  }

  public boolean canJumpUsingGreedyApproach(int[] nums) {
    int maxJumpPosition = nums.length - 1;

    for (int prev = nums.length - 2; prev >= 0; prev --) {
      int curr = prev + nums[prev];
      if (curr >= maxJumpPosition) {
        maxJumpPosition = prev;
      }
    }

    return maxJumpPosition == 0;
  }

  public boolean canJumpUsingDynamicProgrammingApproach(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    boolean[] dp = new boolean[nums.length];
    dp[nums.length - 1] = true;

    for (int prev = nums.length - 2; prev >= 0; prev--) {
      int furthestJump = Math.min(prev + nums[prev], nums.length - 1);
      for (int next = prev + 1; next <= furthestJump; next++) {
        if (dp[next]) {
          dp[prev] = true;
          break;
        }
      }
    }

    return dp[0];
  }

  public boolean canJumpUsingMemoizationSearch(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    Boolean[] memo = new Boolean[nums.length];
    memo[nums.length - 1] = true;
    return memoHelper(0, nums, memo);
  }

  private boolean memoHelper(int index, int[] nums, Boolean[] memo) {
    if (memo[index] != null) {
      return memo[index];
    }

    int furthestJump = Math.min(index + nums[index], nums.length - 1);

    for (int nextIndex = index + 1; nextIndex <= furthestJump; nextIndex++) {
      if (memoHelper(nextIndex, nums, memo)) {
        memo[nextIndex] = true;
        return true;
      }
    }

    memo[index] = false;

    return memo[index];
  }

  public boolean canJumpUsingRecursion(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    return dfsHelper(0, nums);
  }

  private boolean dfsHelper(int index, int[] nums) {
    if (index == nums.length - 1) {
      return true;
    }

    int furthestJump = Math.min(index + nums[index], nums.length - 1);

    for (int nextIndex = furthestJump; nextIndex > index; nextIndex--) {
      if (dfsHelper(nextIndex, nums)) {
        return true;
      }
    }

    return false;
  }
}
