package algorithm;

/**
 * push()&pop()&top()&getMin():Time Complexity: O(1); Space Complexity: O(n);
 *
 * @author XueweiHuang
 * @created 2021-07-08
 */
public class CustomStackSolution implements MinStack {

  private static class Node {
    int val;
    int min;
    Node next;

    Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }

    Node(int val, int min) {
      this(val, min, null);
    }
  }

  private Node head;

  public CustomStackSolution() {}

  @Override
  public void push(int val) {
    if (head == null) {
      head = new Node(val, val);
    } else {
      int min = val < head.min ? val : head.min;
      head = new Node(val, min, head);
    }
  }

  @Override
  public void pop() {
    head = head.next;
  }

  @Override
  public int top() {
    return head.val;
  }

  @Override
  public int getMin() {
    return head.min;
  }
}
