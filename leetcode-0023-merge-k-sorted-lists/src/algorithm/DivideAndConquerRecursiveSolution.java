package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class DivideAndConquerRecursiveSolution {
  /** Time Complexity: O(knlogk); Space Complexity: O(logk); */
  public ListNode mergeKLists(ListNode[] lists) {
    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] lists, int left, int right) {
    if (left == right) {
      return lists[left];
    } else if (left > right) {
      return null;
    } else {
      // left < right;
      int mid = left + (right - left) / 2;
      return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }
  }

  private ListNode mergeTwoLists(ListNode first, ListNode second) {
    if (first == null || second == null) {
      return first == null ? second : first;
    }
    ListNode head = new ListNode(-1);
    ListNode tail = head;
    ListNode firstPtr = first;
    ListNode secondPtr = second;
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
