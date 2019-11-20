package algorithm;

public class Main {

    public static void main(String[] args) {
        // 设置容量大小为3
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        // 返回 true
        System.out.println(String.format("circularDeque insertLast 1, return %b", circularDeque.insertLast(1)));
        // 返回 1
        System.out.println(String.format("circularDeque getRear, return %d", circularDeque.getRear()));
        // 返回 true
        System.out.println(String.format("circularDeque insertLast 2, return %b", circularDeque.insertLast(2)));
        // 返回 true
        System.out.println(String.format("circularDeque insertFront 3, return %b", circularDeque.insertFront(3)));
        // 已经满了，返回 false
        System.out.println(String.format("circularDeque insertFront 4, return %b", circularDeque.insertFront(4)));
        // 返回 2
        System.out.println(String.format("circularDeque getRear, return %d", circularDeque.getRear()));
        // 返回 true
        System.out.println(String.format("circularDeque isFull, return %b", circularDeque.isFull()));
        // 返回 true
        System.out.println(String.format("circularDeque deleteLast, return %b", circularDeque.deleteLast()));
        // 返回 true
        System.out.println(String.format("circularDeque insertFront 4, return %b", circularDeque.insertFront(4)));
        // 返回 4
        System.out.println(String.format("circularDeque getFront, return %d", circularDeque.getFront()));
    }
}
