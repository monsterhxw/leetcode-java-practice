package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-02
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5};

    ListNode head = createSinglyLinkedList(nums);
    System.out.print("Singly Linked List is: ");
    printLinkedList(head);

    testRecursiveSolution(head);

    head = createSinglyLinkedList(nums);

    testIterativeSolution(head);
  }

  private static void testRecursiveSolution(ListNode head) {
    System.out.println("----------testRecursiveSolution----------");
    RecursiveSolution solution = new RecursiveSolution();
    ListNode node = solution.reverseList(head);
    System.out.print("Reverse List Result is: ");
    printLinkedList(node);
  }

  private static void testIterativeSolution(ListNode head) {
    System.out.println("----------testIterativeSolution----------");
    IterativeSolution solution = new IterativeSolution();
    ListNode node = solution.reverseList(head);
    System.out.print("Reverse List Result is: ");
    printLinkedList(node);
  }

  private static ListNode createSinglyLinkedList(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return new ListNode();
    } else {
      ListNode head = new ListNode(nums[0]);
      for (int i = 1; i < nums.length; i++) {
        createNodeAtTail(head, nums[i]);
      }
      return head;
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

  private static void printLinkedList(ListNode head) {
    ListNode cur = head;
    while (null != cur) {
      System.out.print(String.format("%d%s", cur.val, cur.next != null ? "->" : ""));
      cur = cur.next;
    }
    System.out.println("\n");
  }
}
