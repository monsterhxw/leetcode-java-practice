package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(n); Space Time Complexity: O(n);
 *
 * @author XueweiHuang
 * @created 2021-07-04
 */
public class SetSolution {

  public boolean hasCycle(ListNode head) {
    Set<ListNode> set = new HashSet<>();

    ListNode current = head;

    while (current != null) {
      if (set.contains(current)) {
        return true;
      } else {
        set.add(current);
        current = current.next;
      }
    }

    return false;
  }
}
