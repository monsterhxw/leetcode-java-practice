package algorithm;

public class Main {

    private static ListNode head, tail;

    public static void main(String[] args) {
        generateListNode();
        System.out.print("initial list: ");
        printList(head);
        System.out.print("remove element 0: ");
        printList(removeElements(head, 0));
        System.out.print("use dummy head to remove element 0: ");
        printList(removeElementsUsingDummyHead(head, 0));
        System.out.print("use recursion to remove element 0: ");
        printList(removeElementsUsingRecursion(head, 0));
    }

    public static ListNode removeElements(ListNode head, int val) {
        while (null != head && head.val == val) {
            head = head.next;
        }
        if (null == head) {
            return null;
        }
        ListNode prev = head;
        while (null != prev.next) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static ListNode removeElementsUsingDummyHead(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (null != prev.next) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode removeElementsUsingRecursion(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        head.next = removeElementsUsingRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }

    private static void generateListNode() {
        for (int i = 0; i < 5; i++) {
            addListNodeAtTail(i % 3);
        }
    }

    private static void addListNodeAtTail(int val) {
        if (null == tail) {
            tail = new ListNode(val);
            head = tail;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }

    private static void printList(ListNode head) {
        ListNode cur = head;
        while (null != cur) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.print("null \n");
    }
}
