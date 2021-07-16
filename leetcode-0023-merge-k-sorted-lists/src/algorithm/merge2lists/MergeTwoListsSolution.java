package algorithm.merge2lists;

import algorithm.ListNode;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class MergeTwoListsSolution {
  /** Time Complexity: O(n); Space Complexity: O(1); */
  public ListNode mergeTwoLists(ListNode a, ListNode b) {
    if (a == null || b == null) {
      return a == null ? b : a;
    }
    ListNode head = new ListNode(-1);
    ListNode tail = head;
    ListNode firstPtr = a;
    ListNode secondPtr = b;
    while (firstPtr != null && secondPtr != null) {
      if (firstPtr.val < secondPtr.val) {
        tail.next = firstPtr;
        firstPtr = firstPtr.next;
      } else {
        tail.next = secondPtr;
        secondPtr = secondPtr.next;
      }
      tail = tail.next;
    }
    tail.next = firstPtr == null ? secondPtr : firstPtr;
    return head.next;
  }
}
