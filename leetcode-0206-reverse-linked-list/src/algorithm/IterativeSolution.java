package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-02
 */
public class IterativeSolution {

  public ListNode reverseList(ListNode head) {
    ListNode previous = null;
    ListNode current = head;
    while (null != current) {
      ListNode next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    return previous;
  }
}
