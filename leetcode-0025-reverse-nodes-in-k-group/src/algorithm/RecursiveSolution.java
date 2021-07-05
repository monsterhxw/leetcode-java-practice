package algorithm;

/**
 * Time Complexity: O(n); Space Complexity: O(n);
 *
 * @author XueweiHuang
 * @created 2021-07-05
 */
public class RecursiveSolution {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode tail = head;
    for (int i = 0; i < k - 1; i++) {
      if (tail.next == null) {
        return head;
      } else {
        tail = tail.next;
      }
    }
    tail.next = reverseKGroup(tail.next, k);
    return reverseList(head, tail);
  }

  private ListNode reverseList(ListNode head, ListNode tail) {
    ListNode previous = tail.next;
    ListNode current = head;
    while (previous != tail) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return tail;
  }
}
