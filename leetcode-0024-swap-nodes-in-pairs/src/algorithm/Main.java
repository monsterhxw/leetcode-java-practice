package algorithm;

import java.util.Stack;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        int num = 5;
        ListNode node = initLinkedList(num);
        System.out.println("Initial Linked List.");
        printLinkedList(node);

        // 用迭代实现两两交换链表中的节点
        ListNode iteration = swapPairsIterative(node);
        System.out.println("using iterative method to swap nodes in pairs.");
        printLinkedList(iteration);

        // 用递归实现两两交换链表中的节点
        node = initLinkedList(num);
        ListNode recursion = swapPairsRecursive(node);
        System.out.println("using recursive method to swap nodes in pairs.");
        printLinkedList(recursion);

        // 用 Stack 实现两两交换链表中的节点
        node = initLinkedList(num);
        ListNode stack = swapPairsInStack(node);
        System.out.println("using stack to swap nodes in pairs.");
        printLinkedList(stack);
    }

    public static ListNode swapPairsIterative(ListNode head) {
        // 增加一个特殊的节点，下一个节点指向 head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 创建 pre 指针指向 dummy
        ListNode pre = dummy;
        // 创建 a, b 指针用于指向需要交换的两个节点
        ListNode a = null;
        ListNode b = null;
        while (null != pre.next && null != pre.next.next) {
            // a 指向需要交换的第一个节点
            a = pre.next;
            // b 指向需要交换的第二个节点
            b = a.next;
            // temp 的下一个节点指向由指向 a 指针变成指向 b 指针
            pre.next = b;
            // a 的下一个节点指向 b 指针的下一个节点
            a.next = b.next;
            // b 指针的下一个节点指向 a 指针
            b.next = a;
            // temp 指向交换后的第二个节点即 a 指针
            pre = a;
        }
        return dummy.next;
    }

    /**
     * 递归写法要观察本级递归的解决过程，形成抽象模型，因为递归本质就是不断重复相同的事情。
     * 而不是去思考完整的调用栈，一级又一级，无从下手。
     * 其中我们应该关心的主要有三点：
     *  1. 返回值
     *  2. 调用单元做了什么
     *  3. 终止条件
     * 如
     *  1. 返回值
     *     交换完成的子链表
     *  2. 调用单元
     *     设需要交换的两个点为 head 和 next，head 连接后面交换完成的子链表，next 连接 head，完成交换
     *  3. 终止条件
     *     head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     */
    public static ListNode swapPairsRecursive(ListNode head) {
        // 因跨 2 个节点递归一次，所以
        // 若链表总长是偶数，那么递归函数执行到到终止条件为 null == head;
        // 若链表总长是奇数，那么递归函数执行到到终止条件为 null == head.next;
        if (null == head || null == head.next) {
            return head;
        }
        // 创建 next 指针，指向 head 的下一个节点
        // 如 1 -> 2 -> 3 -> null，head 为 1 ，next 为 2
        ListNode next = head.next;
        // 递归开始，跨 2 个节点递归一次，所以传入的参数为 next.next
        // 如 1 -> 2 -> 3 -> null，next.next 为 3
        // head 节点的下一个节点 head.next 指向递归交换完成的子链表
        // 如 1 -> 2 -> 3 -> 4 -> null，处理节点 3 -> 4 -> null
        // 当递归结束后，就变成 4 -> 3 -> null
        // 于是 head 节点就指向了 4，变成 1 -> 4 -> 3 -> null
        head.next = swapPairsRecursive(next.next);
        // 将 next 的下一个节点指向 head
        // 如 next = 2 -> 3 -> 4 -> null, head =  1 -> 4 -> 3 -> null
        // 所以 next = 2 -> 1 -> 4 -> 3 -> null
        next.next = head;
        return next;
    }

    public static ListNode swapPairsInStack(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        // 用 stack 保存每次迭代的两个节点
        Stack<ListNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        // head 指向新的 dummy 节点，函数结束时返回 head.next 即可
        head = dummy;
        while (null != cur && null != cur.next) {
            // 将两个节点放入 stack 中
            stack.add(cur);
            stack.add(cur.next);
            // 当前节点往后走 2 个节点
            cur = cur.next.next;
            // 从 stack 中弹出两个节点，然后用 dummy 节点指向新弹出的两个节点
            dummy.next = stack.pop();
            dummy = dummy.next;
            dummy.next = stack.pop();
            dummy = dummy.next;
        }
        // 注意边界条件，当链表长度是奇数时，cur 就不为空
        if(cur!=null) {
            dummy.next = cur;
        } else {
            dummy.next = null;
        }
        return head.next;
    }

    private static ListNode initLinkedList(int num) {
        int i = 1;
        ListNode head = new ListNode(i);
        i++;
        while (i <= num) {
            createNodeAtTail(head, i);
            i++;
        }
        return head;
    }

    public static void createNodeAtTail(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        ListNode tail = head;
        while (null != tail.next) {
            tail = tail.next;
        }
        tail.next = newNode;
    }

    private static void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (null != cur) {
            System.out.print(String.format("%d%s", cur.val, " "));
            cur = cur.next;
        }
        System.out.println("\n");
    }
}
