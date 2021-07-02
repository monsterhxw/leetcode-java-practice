package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-02
 */
public class IterativeSolution {

  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode temp = dummy;
    while (temp.next != null && temp.next.next != null) {
      ListNode first = temp.next;
      ListNode second = temp.next.next;
      temp.next = second;
      first.next = second.next;
      second.next = first;
      temp = first;
    }
    return dummy.next;
  }
}
