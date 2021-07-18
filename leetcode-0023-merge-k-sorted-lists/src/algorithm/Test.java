package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-16
 */
public class Test {
  public static void main(String[] args) {
    testBruteForceSolution(creatListNodeArray());

    testDivideAndConquerRecursiveSolution(creatListNodeArray());

    testPriorityQueueSolution(creatListNodeArray());
  }

  private static void testBruteForceSolution(ListNode[] lists) {
    System.out.println("----------testBruteForceSolution-----------");
    print(lists);
    BruteForceSolution solution = new BruteForceSolution();
    System.out.println("call mergeKLists: ");
    ListNode.printLinkedList(solution.mergeKLists(lists));
  }

  private static void testDivideAndConquerRecursiveSolution(ListNode[] lists) {
    System.out.println("----------testDivideAndConquerRecursiveSolution-----------");
    print(lists);
    DivideAndConquerRecursiveSolution solution = new DivideAndConquerRecursiveSolution();
    System.out.println("call mergeKLists: ");
    ListNode.printLinkedList(solution.mergeKLists(lists));
  }

  private static void testPriorityQueueSolution(ListNode[] lists) {
    System.out.println("----------testPriorityQueueSolution-----------");
    print(lists);
    PriorityQueueSolution solution = new PriorityQueueSolution();
    System.out.println("call mergeKLists: ");
    ListNode.printLinkedList(solution.mergeKLists(lists));
  }

  private static ListNode[] creatListNodeArray() {
    int[] one = new int[] {1, 4, 5};
    int[] two = new int[] {1, 3, 4};
    int[] three = new int[] {2, 6, 8, 10, 78};
    int[][] nums = new int[][] {one, two, three};
    ListNode[] lists = new ListNode[nums.length];
    for (int i = 0; i < nums.length; i++) {
      lists[i] = ListNode.createSinglyLinkedList(nums[i]);
    }
    return lists;
  }

  private static void print(ListNode[] lists) {
    System.out.println("lists is: ");
    for (int i = 0; i < lists.length; i++) {
      ListNode.printLinkedList(lists[i]);
    }
  }
}
