package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-21
 */
public class TestCases {
  public static void main(String[] args) {
    int k = 3;

    MyCircularDeque arraySolution = testArraySolution(k);

    testMyCircularDeque(arraySolution);
  }

  private static void testMyCircularDeque(MyCircularDeque circularDeque) {
    System.out.println("current class is: " + circularDeque.getClass().getSimpleName());

    System.out.println("call insertLast(1). Result is: " + circularDeque.insertLast(1));

    System.out.println("call insertLast(2). Result is: " + circularDeque.insertLast(2));

    System.out.println("call insertFront(3). Result is: " + circularDeque.insertFront(3));

    System.out.println("call insertFront(4). Result is: " + circularDeque.insertFront(4));

    System.out.println("call getRear(). Result is: " + circularDeque.getRear());

    System.out.println("call isFull(). Result is: " + circularDeque.isFull());

    System.out.println("call deleteLast(). Result is: " + circularDeque.deleteLast());

    System.out.println("call insertFront(4). Result is: " + circularDeque.insertFront(4));

    System.out.println("call getFront(). Result is: " + circularDeque.getFront());
  }

  private static MyCircularDeque testArraySolution(int k) {
    System.out.println("---------testArraySolution-----------");
    MyCircularDeque queue = new ArraySolution(k);
    return queue;
  }
}
