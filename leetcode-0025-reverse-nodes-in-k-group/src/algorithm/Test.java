package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-05
 */
public class Test {

  public static void main(String[] args) {
    int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8};

    ListNode head = createSinglyLinkedList(nums);
    System.out.print("Singly Linked List is: ");
    printLinkedList(head);
    int k = 1;
    System.out.println("k is: " + k);

    testIterativeSolution(head, k);

    head = createSinglyLinkedList(nums);

    testRecursiveSolution(head, k);
  }

  private static void testIterativeSolution(ListNode head, int k) {
    System.out.println("----------testIterativeSolution----------");
    IterativeSolution solution = new IterativeSolution();
    ListNode node = solution.reverseKGroup(head, k);
    System.out.print("Reverse Nodes in k(" + k + ")-Group Result is: ");
    printLinkedList(node);
  }

  private static void testRecursiveSolution(ListNode head, int k) {
    System.out.println("----------testRecursiveSolution----------");
    RecursiveSolution solution = new RecursiveSolution();
    ListNode node = solution.reverseKGroup(head, k);
    System.out.print("Reverse Nodes in k(" + k + ")-Group Result is: ");
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
      System.out.print(String.format("%d%s", cur.val, cur.next != null ? "->" : "->null"));
      cur = cur.next;
    }
    System.out.println();
  }
}
