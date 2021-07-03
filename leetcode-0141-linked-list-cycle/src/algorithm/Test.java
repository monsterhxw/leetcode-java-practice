package algorithm;

import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * @author XueweiHuang
 * @created 2021-07-03
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 0, -4};
    ListNode head = arrayToList(nums, 1);
    testSetSolution(head);
  }

  private static void testSetSolution(ListNode head) {
    System.out.println("----------testSetSolution----------");
    SetSolution solution = new SetSolution();
    System.out.println("has cycle? " + solution.hasCycle(head));
  }

  private static ListNode arrayToList(int[] array, int pos) {
    if (null == array || array.length == 0) {
      return new ListNode();
    } else {
      ListNode head = new ListNode();
      for (int i = 0; i < array.length; i++) {
        createNodeAtTail(head, array[i]);
      }
      if (pos != -1) {
        ListNode tail = getTail(head);
        try {
          tail.next = getCycleNode(head.next, pos);
        } catch (NotFound notFound) {
          notFound.printStackTrace();
        }
      }
      return head.next;
    }
  }

  private static void createNodeAtTail(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    ListNode tail = getTail(head);
    tail.next = newNode;
  }

  private static ListNode getTail(ListNode head) {
    ListNode tail = head;
    while (null != tail.next) {
      tail = tail.next;
    }
    return tail;
  }

  private static ListNode getCycleNode(ListNode head, int pos) throws NotFound {
    ListNode cur = head;
    int index = 0;
    while (null != cur) {
      if (pos == index) {
        return cur;
      } else {
        index++;
        cur = cur.next;
      }
    }
    throw new NotFound();
  }
}
