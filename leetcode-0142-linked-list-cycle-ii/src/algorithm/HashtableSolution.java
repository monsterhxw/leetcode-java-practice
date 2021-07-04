package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(n); Space Complexity: O(n)
 *
 * @author XueweiHuang
 * @created 2021-07-04
 */
public class HashtableSolution {

  public ListNode detectCycle(ListNode head) {
    Set<ListNode> hashset = new HashSet<>();
    ListNode current = head;
    while (current != null) {
      if (hashset.contains(current)) {
        return current;
      } else {
        hashset.add(current);
        current = current.next;
      }
    }
    return null;
  }
}
