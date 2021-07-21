package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-21
 */
public class ArraySolution implements MyCircularQueue {

  private int[] queue;
  private int front;
  private int size;
  private int capacity;

  public ArraySolution() {
    this(16);
  }

  public ArraySolution(int k) {
    this.capacity = k;
    this.queue = new int[k];
    this.front = 0;
    this.size = 0;
  }

  @Override
  public boolean enQueue(int value) {
    if (isFull()) {
      return false;
    } else {
      this.queue[(this.front + this.size) % this.capacity] = value;
      this.size++;
      return true;
    }
  }

  @Override
  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    } else {
      this.queue[this.front] = 0;
      this.front = (this.front + 1) % this.capacity;
      this.size--;
      return true;
    }
  }

  @Override
  public int Front() {
    if (isEmpty()) {
      return -1;
    } else {
      return this.queue[front];
    }
  }

  @Override
  public int Rear() {
    if (isEmpty()) {
      return -1;
    } else {
      return this.queue[(this.front + this.size - 1) % this.capacity];
    }
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public boolean isFull() {
    return this.size == this.capacity;
  }
}
