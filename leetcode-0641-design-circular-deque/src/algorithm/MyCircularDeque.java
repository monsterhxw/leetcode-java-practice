package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-21
 */
public interface MyCircularDeque {

  /** Initialize your data structure here. Set the size of the deque to be k. */

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  boolean insertFront(int value);

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  boolean insertLast(int value);

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  boolean deleteFront();

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  boolean deleteLast();

  /** Get the front item from the deque. */
  int getFront();

  /** Get the last item from the deque. */
  int getRear();

  /** Checks whether the circular deque is empty or not. */
  boolean isEmpty();

  /** Checks whether the circular deque is full or not. */
  boolean isFull();
}

/**
 * Your MyCircularDeque object will be instantiated and called as such: MyCircularDeque obj = new
 * MyCircularDeque(k); boolean param_1 = obj.insertFront(value); boolean param_2 =
 * obj.insertLast(value); boolean param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
