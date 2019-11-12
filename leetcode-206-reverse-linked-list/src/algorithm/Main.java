package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = initLinkedList(5);
        printLinkedList(head);

        // 用迭代实现反转链表
        ListNode reverseListWithIteration = reverseListWithIteration(head);
        printLinkedList(reverseListWithIteration);

        head = initLinkedList(5);

        // 用递归实现反转链表
        ListNode reverseListWithRecursion = reverseListWithRecursion(head);
        printLinkedList(reverseListWithRecursion);
    }

    /**
     * 我们可以申请两个指针，第一个指针叫 pre，最初是指向null的。
     *
     * 第二个指针 cur 指向 head，然后不断遍历 cur。
     *
     * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
     *
     * 当迭代停止，cur 变成 null ，pre 指向最后一个节点，返回 pre
     */
    public static ListNode reverseListWithIteration(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (null != cur) {
            // 记录当前节点 cur 的下一个节点
            temp = cur.next;
            // 然后将当前节点指向 pre
            cur.next = pre;
            // pre 节点前进一位
            pre = cur;
            // cur 节点前进一位
            cur = temp;
        }
        return pre;
    }

    public static ListNode reverseListWithRecursion(ListNode head) {
        // 递归终止条件是当前节点为空，或者下一个节点为空
        if (null == head || null == head.next) {
            return head;
        }
        // 这里的 cur 就是最后一个节点
        ListNode cur = reverseListWithRecursion(head.next);
        // head 的下一个节点指向 head
        // 如链表是 1 -> 2-> 3 -> 4 -> 5 -> null，那么此时的 cur 就是 5
        // 而 head 是 4，head 的下一个是 5，下下一个是 null
        // head.next.next = head; 5 -> 4
        head.next.next = head;
        // 防止链表循环，需要将 head.next 设置为空
        head.next = null;
        // 每层递归函数都返回 cur，也就是最后一个节点
        return cur;
    }

    private static ListNode initLinkedList(int num) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int i = 2;
        while (i < num + 1) {
            cur.next = new ListNode(i);
            cur = cur.next;
            i++;
        }
        return head;
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
