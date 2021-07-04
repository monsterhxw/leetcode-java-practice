package algorithm;

/**
 * Time Complexity: O(n); Space Complexity: O(1)
 *
 * @author XueweiHuang
 * @created 2021-07-04
 */
public class FloydCycleDetectionAlgorithmSolution {

  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
