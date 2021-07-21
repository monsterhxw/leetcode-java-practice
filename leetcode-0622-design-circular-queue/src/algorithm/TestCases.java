package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-21
 */
public class TestCases {
  public static void main(String[] args) {
    int k = 3;

    MyCircularQueue arraySolution = testArraySolution(k);

    testMyCircularQueue(arraySolution, k);
  }

  private static void testMyCircularQueue(MyCircularQueue circularQueue, int k) {
    System.out.println("current class is: " + circularQueue.getClass().getSimpleName());

    for (int i = 1; i <= k + 1; i++) {
      System.out.println("call enQueue(" + i + "). Result is: " + circularQueue.enQueue(i));
    }

    System.out.println("call Rear(). Result is: " + circularQueue.Rear());

    System.out.println("call isFull(). Result is: " + circularQueue.isFull());

    System.out.println("call deQueue(). Result is: " + circularQueue.deQueue());

    System.out.println("call enQueue(" + (k + 1) + "). Result is: " + circularQueue.enQueue(k + 1));

    System.out.println("call Rear(). Result is: " + circularQueue.Rear());
  }

  private static MyCircularQueue testArraySolution(int k) {
    System.out.println("---------testArraySolution-----------");
    MyCircularQueue queue = new ArraySolution(k);
    return queue;
  }
}
