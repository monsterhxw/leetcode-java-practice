package algorithm.merge2lists;

import static algorithm.ListNode.createSinglyLinkedList;
import static algorithm.ListNode.printLinkedList;

import algorithm.ListNode;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class Test {
  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 1, 3, 4, 5};
    int[] nums2 = new int[] {1, 3};
    ListNode first = createSinglyLinkedList(nums1);
    System.out.print("first list is: ");
    printLinkedList(first);
    ListNode second = createSinglyLinkedList(nums2);
    System.out.print("second list is: ");
    printLinkedList(second);

    testMergeTwoListsSolution(first, second);
  }

  private static void testMergeTwoListsSolution(ListNode first, ListNode second) {
    System.out.println("----------testMergeTwoListsSolution-----------");
    MergeTwoListsSolution solution = new MergeTwoListsSolution();
    ListNode merged = solution.mergeTwoLists(first, second);
    System.out.print("The merged List is: ");
    printLinkedList(merged);
  }
}
