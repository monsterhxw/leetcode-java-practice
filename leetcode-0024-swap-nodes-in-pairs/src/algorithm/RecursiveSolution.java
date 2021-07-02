package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-02
 */
public class RecursiveSolution {

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    } else{
      ListNode newHead = head.next;
      head.next = swapPairs(head.next.next);
      newHead.next = head;
      return newHead;
    }
  }
}
