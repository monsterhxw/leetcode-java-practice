package algorithm;

/**
 * Time Complexity: O(n); Space Complexity: O(1);
 *
 * @author XueweiHuang
 * @created 2021-07-05
 */
public class IterativeSolution {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode hair = new ListNode();
    hair.next = head;
    ListNode previous = hair;
    while (head != null) {
      ListNode tail = previous;
      for (int i = 0; i < k; i++) {
        if (tail.next == null) {
          return hair.next;
        } else {
          tail = tail.next;
        }
      }
      ListNode[] reversed = reverseList(head, tail);
      head = reversed[0];
      tail = reversed[1];
      // 把子链表重新接回原链表
      previous.next = head;
      // 移动 previous 和 tail 指针
      previous = tail;
      head = tail.next;
    }
    return hair.next;
  }

  private ListNode[] reverseList(ListNode head, ListNode tail) {
    ListNode previous = tail.next;
    ListNode current = head;
    while (previous != tail) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return new ListNode[] {tail, head};
  }
}
