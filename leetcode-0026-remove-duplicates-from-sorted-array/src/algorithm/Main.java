package algorithm;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int[] nums = new int[] {1, 1, 2};

    int length = main.removeDuplicates(nums);

    System.out.println("remove duplicates from sorted array length is " + length);
  }

  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }

    int slowPointer = 0;

    for (int fastPointer = 1; fastPointer < nums.length; fastPointer++) {
      if (nums[fastPointer] != nums[slowPointer]) {
        nums[slowPointer + 1] = nums[fastPointer];
        slowPointer++;
      }
    }

    return slowPointer + 1;
  }
}
