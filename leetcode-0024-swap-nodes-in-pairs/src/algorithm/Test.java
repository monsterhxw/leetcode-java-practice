package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-02
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4};
    ListNode head = arrayToList(nums);
    print(head);

    testIterativeSolution(head);

    head = arrayToList(nums);

    testRecursiveSolution(head);
  }

  private static void testIterativeSolution(ListNode head) {
    System.out.println("----------testIterativeSolution----------");
    IterativeSolution solution = new IterativeSolution();
    ListNode swapped = solution.swapPairs(head);
    print(swapped);
  }

  private static void testRecursiveSolution(ListNode head) {
    System.out.println("----------testRecursiveSolution----------");
    RecursiveSolution solution = new RecursiveSolution();
    ListNode swapped = solution.swapPairs(head);
    print(swapped);
  }

  public static ListNode arrayToList(int[] array) {
    if (null == array || array.length == 0) {
      return new ListNode();
    } else {
      ListNode head = new ListNode();
      for (int i = 0; i < array.length; i++) {
        createNodeAtTail(head, array[i]);
      }
      return head.next;
    }
  }

  private static void createNodeAtTail(ListNode head, int val) {
    ListNode newNode = new ListNode(val);
    ListNode tail = head;
    while (null != tail.next) {
      tail = tail.next;
    }
    tail.next = newNode;
  }

  private static void print(ListNode head) {
    ListNode cur = head;
    while (null != cur) {
      System.out.print(String.format("%d%s", cur.val, cur.next != null ? "->" : ""));
      cur = cur.next;
    }
    System.out.println("\n");
  }
}
