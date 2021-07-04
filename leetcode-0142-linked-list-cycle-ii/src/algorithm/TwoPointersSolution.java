package algorithm;

/**
 * Time Complexity: O(n); Space Complexity: O(1);
 *
 * @author XueweiHuang
 * @created 2021-07-04
 */
public class TwoPointersSolution {

  /**
   * 因为快慢指针，fast 指针走的步数是 slow 指针的 2 倍，所以有 fastStep = 2 * slowStep;
   *
   * <p>fast 与 slow 重合时，比 slow 多走了 n 个环长，所以有 fastStep = slowStep + n * b (环中的总节点)
   *
   * <p>根据上面两个式子得出，slowStep = n * b; fastStep = 2 * n * b;
   *
   * <p>指针从 head 走到链表环入口节点时的步数是： k = a + n * b; a 代表的是不计链表入口的节点， b 是指环中的总节点;
   *
   * <p>而目前 slow 指针走过的步数 slowStep 为 n * b，所以我们要让 slow 指针再走 a 步停下来，就可以找到链表环入口的节点
   *
   * <p>从那里走到链表环入口节点需要 a 步？答案是链表头部 head;
   *
   * <p>所以我们让 fast 指针设置为 head，并与 slow 一起向前走 a 步后，两者会在链表环入口重合。
   */
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    // 1. 让 fast 与 slow 相遇
    // 2. 设置 fast 为 head，并与 slow 一起向前走，再次相遇即找到环的入口
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        fast = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return fast;
      }
    }
    return null;
  }
}
