package algorithm.merge2lists;

import algorithm.ListNode;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class Test {
  public static void main(String[] args) {
    int[] nums1 = new int[] {1, 4, 5};
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

  private static ListNode createSinglyLinkedList(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return new ListNode();
    } else {
      ListNode head = new ListNode(nums[0]);
      for (int i = 1; i < nums.length; i++) {
        createNodeAtTail(head, nums[i]);
      }
      return head;
    }
  }

  private static void createNodeAtTail(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    ListNode tail = head;
    while (null != tail.next) {
      tail = tail.next;
    }
    tail.next = newNode;
  }

  private static void printLinkedList(ListNode head) {
    ListNode cur = head;
    while (null != cur) {
      System.out.print(String.format("%d%s", cur.val, cur.next != null ? "->" : "->null"));
      cur = cur.next;
    }
    System.out.println();
  }
}
