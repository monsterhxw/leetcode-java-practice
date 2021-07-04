package algorithm;

/**
 * Time Complexity: O(n); Space Complexity: O(1)
 *
 * @author XueweiHuang
 * @created 2021-07-04
 */
public class BrentCycleDetectionAlgorithmSolution {

  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    int stepCount = 0;
    int stepLimit = 1;

    while (fast != null) {
      fast = fast.next;
      if (fast == slow) {
        return true;
      } else {
        stepCount++;
        if (stepCount == stepLimit) {
          slow = fast;
          stepCount = 0;
          stepLimit = stepLimit * 2;
        }
      }
    }

    return false;
  }
}
