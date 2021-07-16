package algorithm;

import java.util.Arrays;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class Test {
  public static void main(String[] args) {
    int[] one = new int[] {1, 4, 5};
    int[] two = new int[] {1, 3, 4};
    int[] three = new int[] {2, 6};
    int[][] nums = new int[][] {one, two, three};
    ListNode[] lists = new ListNode[nums.length];
    System.out.println("lists is: ");
    for (int i = 0; i < nums.length; i++) {
      lists[i] = ListNode.createSinglyLinkedList(nums[i]);
      ListNode.printLinkedList(lists[i]);
    }
    System.out.println();

    testBruteForceSolution(lists);
  }

  private static void testBruteForceSolution(ListNode[] lists) {
    System.out.println("----------testBruteForceSolution-----------");
    ListNode[] copyOf = Arrays.copyOf(lists, lists.length);
    BruteForceSolution solution = new BruteForceSolution();
    System.out.println("call mergeKLists: ");
    ListNode.printLinkedList(solution.mergeKLists(copyOf));
  }
}
