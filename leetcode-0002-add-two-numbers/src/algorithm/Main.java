package algorithm;

/** @author monstervivi */
public class Main {

  /** Definition for singly-linked list. */
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode createListNode(int[] nums) {
    ListNode head = new ListNode(0);
    ListNode dummy = head;

    for (int num : nums) {
      dummy.next = new ListNode(num);

      dummy = dummy.next;
    }

    return head.next;
  }

  public static void main(String[] args) {
    Main main = new Main();

    int[] nums1 = {2, 4, 3};
    ListNode l1 = main.createListNode(nums1);

    int[] nums2 = {5, 6, 4};
    ListNode l2 = main.createListNode(nums2);

    ListNode res = main.addTwoNumbers(l1, l2);

    System.out.print("l1 is : ");
    for (int i = 0; i < nums1.length; i++) {
      System.out.print(nums1[i] + " ");
    }
    System.out.println();

    System.out.print("l2 is : ");
    for (int i = 0; i < nums2.length; i++) {
      System.out.print(nums2[i] + " ");
    }
    System.out.println();

    System.out.print("result is : ");
    ListNode dummy = res;
    while (dummy != null) {
      System.out.print(dummy.val + " ");
      dummy = dummy.next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    ListNode dummyOne = l1;
    ListNode dummyTwo = l2;

    int carry = 0;

    while (dummyOne != null || dummyTwo != null) {
      int x = dummyOne == null ? 0 : dummyOne.val;
      int y = dummyTwo == null ? 0 : dummyTwo.val;

      int sum = carry + x + y;

      carry = sum / 10;

      curr.next = new ListNode(sum % 10);

      curr = curr.next;

      if (dummyOne != null) {
        dummyOne = dummyOne.next;
      }

      if (dummyTwo != null) {
        dummyTwo = dummyTwo.next;
      }
    }

    if (carry > 0) {
      curr.next = new ListNode(carry);
    }

    return dummyHead.next;
  }
}
