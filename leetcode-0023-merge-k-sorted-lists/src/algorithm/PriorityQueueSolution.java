package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author XueweiHuang
 * @created 2021-07-18
 */
public class PriorityQueueSolution {
  /** Time Complexity: O(knlogk); Space Complexity: O(k); */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    // offer() Time Space: O(logk);
    // poll Time Space: O(logk);
    PriorityQueue<ListNode> minQueue =
        new PriorityQueue<>(
            lists.length,
            new Comparator<ListNode>() {
              @Override
              public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
              }
            });
    for (int k = 0; k < lists.length; k++) {
      if (lists[k] != null) {
        minQueue.offer(lists[k]);
      }
    }
    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;
    // Time Complexity: O(knlogk);
    while (!minQueue.isEmpty()) {
      ListNode min = minQueue.poll();
      tail.next = min;
      if (min.next != null) {
        minQueue.offer(min.next);
      }
      tail = tail.next;
    }
    return dummy.next;
  }
}
