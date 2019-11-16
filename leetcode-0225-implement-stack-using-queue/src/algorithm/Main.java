package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(String.format("stack peek: %s", stack.top()));
        System.out.println(String.format("stack pop: %s", stack.pop()));
        System.out.println(String.format("stack peek: %s", stack.top()));
        System.out.println(String.format("stack is empty?: %s\n", stack.empty()));

        MyStack2 stack2 = new MyStack2();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println(String.format("stack2 peek: %s", stack2.top()));
        System.out.println(String.format("stack2 pop: %s", stack2.pop()));
        System.out.println(String.format("stack2 peek: %s", stack2.top()));
        System.out.println(String.format("stack2 is empty?: %s\n", stack2.empty()));

        MyStack3 stack3 = new MyStack3();
        stack3.push(1);
        stack3.push(2);
        stack3.push(3);
        System.out.println(String.format("stack3 peek: %s", stack3.top()));
        System.out.println(String.format("stack3 pop: %s", stack3.pop()));
        System.out.println(String.format("stack3 peek: %s", stack3.top()));
        System.out.println(String.format("stack3 is empty?: %s\n", stack3.empty()));

    }
}
