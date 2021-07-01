package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-02
 */
public class RecursiveSolution {

  public ListNode reverseList(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    } else {
      ListNode reversed = reverseList(head.next);
      // 如: reversed: 5 -> null
      //     head = 4 && head.next = 5
      // 所以 head.next.next = head ==> 5 -> 4
      //                               |    ｜
      //                               -----—
      // 所以进行 head.next = null，防止链表有环
      // 返回 reversed: 5 -> 4 -> null
      // reversed: 5 -> 4 -> null
      // head = 3 && head.next -> 4;
      // 即 5 -> 4 -> null
      //         |
      //         3 (head)
      // 所以 head.next.next = head ==> 4 -> 3
      //                               |    ｜
      //                               -----—
      // 所以进行 head.next = null，防止链表有环
      // 所以此时 reversed: 5 -> 4 -> 3 -> null;
      head.next.next = head;
      head.next = null;
      return reversed;
    }
  }
}
