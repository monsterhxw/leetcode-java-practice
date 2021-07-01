package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-26
 */
public class Test {

  public static void main(String[] args) {
    testHashAndDoublyLinkedListSolution();
  }

  private static void testHashAndDoublyLinkedListSolution() {
    System.out.println("--------------testHashAndDoublyLinkedListSolution--------------");
    HashAndDoublyLinkedListSolution cache = new HashAndDoublyLinkedListSolution(2);
    System.out.println("Invoke put(1, 1) and put(2, 2)");
    cache.put(1, 1);
    cache.put(2, 2);
    cache.printDLList();

    System.out.println();
    System.out.println("Invoke get(1), value is: " + cache.get(1));
    cache.printDLList();

    System.out.println();
    System.out.println("Invoke put(3, 3)");
    cache.put(3, 3);
    cache.printDLList();

    System.out.println();
    System.out.println("Invoke get(2), value is: " + cache.get(2));
    cache.printDLList();

    System.out.println();
    System.out.println("Invoke get(3), value is: " + cache.get(3));
    cache.printDLList();

    System.out.println();
    System.out.println("Invoke put(4, 4)");
    cache.put(4, 4);
    cache.printDLList();

    System.out.println();
    System.out.println("Invoke get(1), value is: " + cache.get(1));
    System.out.println("Invoke get(3), value is: " + cache.get(3));
    System.out.println("Invoke get(4), value is: " + cache.get(4));
    cache.printDLList();
  }
}
