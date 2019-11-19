package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        // 设置长度为 3
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        // 返回 true
        System.out.println(String.format("circularQueue enQueue, return %b", circularQueue.enQueue(1)));
        // 返回 1, 1
        System.out.println(String.format("circularQueue Rear, return front = %d, rear = %d", circularQueue.Front(), circularQueue.Rear()));
        // 返回 true
        System.out.println(String.format("circularQueue enQueue, return %b", circularQueue.enQueue(2)));
        // 返回 true
        System.out.println(String.format("circularQueue enQueue, return %b", circularQueue.enQueue(3)));
        // 返回 false，队列已满
        System.out.println(String.format("circularQueue enQueue, return %b", circularQueue.enQueue(4)));
        // 返回 3
        System.out.println(String.format("circularQueue Rear, return rear = %d", circularQueue.Rear()));
        // 返回 true
        System.out.println(String.format("circularQueue isFull, return %b", circularQueue.isFull()));
        // 返回 true
        System.out.println(String.format("circularQueue deQueue, return %b", circularQueue.deQueue()));
        // 返回 true
        System.out.println(String.format("circularQueue enQueue, return %b", circularQueue.enQueue(4)));
        // 返回 4
        System.out.println(String.format("circularQueue Rear, return rear = %d \n", circularQueue.Rear()));
    }
}
