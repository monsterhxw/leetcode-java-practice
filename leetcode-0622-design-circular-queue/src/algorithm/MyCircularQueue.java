package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-21
 */
public interface MyCircularQueue {

  boolean enQueue(int value);

  boolean deQueue();

  int Front();

  int Rear();

  boolean isEmpty();

  boolean isFull();
}
/**
 * Your MyCircularQueue object will be instantiated and called as such: MyCircularQueue obj = new
 * MyCircularQueue(k); boolean param_1 = obj.enQueue(value); boolean param_2 = obj.deQueue(); int
 * param_3 = obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty(); boolean param_6
 * = obj.isFull();
 */
