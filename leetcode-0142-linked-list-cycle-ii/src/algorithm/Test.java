package algorithm;

import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * @author XueweiHuang
 * @created 2021-07-04
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 0, -4};
    ListNode head = arrayToList(nums, 1);

    testHashtableSolution(head);

    testTwoPointersSolution(head);
  }

  private static void testHashtableSolution(ListNode head) {
    System.out.println("----------testHashtableSolution----------");
    HashtableSolution solution = new HashtableSolution();
    printHasCycle(solution.detectCycle(head));
  }

  private static void testTwoPointersSolution(ListNode head) {
    System.out.println("----------testTwoPointersSolution----------");
    TwoPointersSolution solution = new TwoPointersSolution();
    printHasCycle(solution.detectCycle(head));
  }

  private static void printHasCycle(ListNode head) {
    System.out.println(
        head == null
            ? "There is no cycle in the linked list."
            : "There is a cycle in the linked list.");
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
