package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-21
 */
public class ArraySolution implements MyCircularDeque {

  private int[] queue;
  private int capacity;
  private int size;
  private int frontPtr;

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public ArraySolution(int k) {
    this.capacity = k;
    this.queue = new int[k];
    this.size = 0;
    this.frontPtr = 0;
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  @Override
  public boolean insertFront(int value) {
    if (size == capacity) {
      return false;
    } else {
      frontPtr = (frontPtr - 1 + capacity) % capacity;
      queue[frontPtr] = value;
      size++;
      return true;
    }
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  @Override
  public boolean insertLast(int value) {
    if (size == capacity) {
      return false;
    } else {
      int tail = (frontPtr + size) % capacity;
      queue[tail] = value;
      size++;
      return true;
    }
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  @Override
  public boolean deleteFront() {
    if (size == 0) {
      return false;
    } else {
      queue[frontPtr] = 0;
      frontPtr = (frontPtr + 1) % capacity;
      size--;
      return true;
    }
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  @Override
  public boolean deleteLast() {
    if (size == 0) {
      return false;
    } else {
      queue[(frontPtr + size - 1) % capacity] = 0;
      size--;
      return true;
    }
  }

  /** Get the front item from the deque. */
  @Override
  public int getFront() {
    if (size == 0) {
      return -1;
    } else {
      return queue[frontPtr];
    }
  }

  /** Get the last item from the deque. */
  @Override
  public int getRear() {
    if (size == 0) {
      return -1;
    } else {
      int rear = (frontPtr + size - 1) % capacity;
      return queue[rear];
    }
  }

  /** Checks whether the circular deque is empty or not. */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /** Checks whether the circular deque is full or not. */
  @Override
  public boolean isFull() {
    return size == capacity;
  }
}
