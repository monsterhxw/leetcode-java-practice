package algorithm;

/**
 * 我们可以申请两个指针，第一个指针叫 pre，最初是指向null的。
 *
 * 第二个指针 cur 指向 head，然后不断遍历 cur。
 *
 * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
 *
 * 当迭代停止，cur 变成 null ，pre 指向最后一个节点，返回 pre
 *
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        ListNode head = initLinkedList(5);
        printLinkedList(head);
        // 反转链表
        ListNode reverseLinkedList = reverseList(head);
        printLinkedList(reverseLinkedList);
    }

    public static ListNode reverseList(ListNode head) {
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
