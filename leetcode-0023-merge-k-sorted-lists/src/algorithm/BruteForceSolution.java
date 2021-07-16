package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class BruteForceSolution {
  /** Time Complexity: O(k^2n); Space Complexity: O(1) */
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode merged = null;
    for (int i = 0; i < lists.length; i++) {
      merged = mergeTwoLists(merged, lists[i]);
    }
    return merged;
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
