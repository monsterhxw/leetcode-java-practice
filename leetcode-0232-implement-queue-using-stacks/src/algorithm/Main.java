package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        System.out.println(queue.empty());
    }
}
