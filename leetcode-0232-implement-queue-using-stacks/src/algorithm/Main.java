package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(String.format("queue peek: %s", queue.peek()));
        System.out.println(String.format("queue pop: %s", queue.pop()));
        System.out.println(String.format("queue peek: %s", queue.peek()));
        System.out.println(String.format("queue is empty?: %s\n", queue.empty()));

        MyQueue2 queue2 = new MyQueue2();
        queue2.push(3);
        queue2.push(4);
        System.out.println(String.format("queue2 peek: %s", queue2.peek()));
        System.out.println(String.format("queue2 pop: %s", queue2.pop()));
        System.out.println(String.format("queue2 peek: %s", queue2.peek()));
        System.out.println(String.format("queue2 is empty?: %s\n", queue2.empty()));
    }
}
