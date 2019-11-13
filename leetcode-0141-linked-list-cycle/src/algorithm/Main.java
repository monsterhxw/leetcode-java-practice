package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        ListNode node = initLinkedList(4);
        createCycle(node);

        System.out.println("using double pointers (Floyd’s Cycle-Finding Algorithm) to detect loop in a linked list.");
        System.out.println(hasCycleUsingDoublePointers(node));

        System.out.println("using hashing to detect loop in a linked list.");
        System.out.println(hasCycleUsingHashing(node));
    }

    public static boolean hasCycleUsingDoublePointers(ListNode head) {
        if (null == head || null == head.next) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != fast) {
            if (null == fast || null == fast.next) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycleUsingHashing(ListNode head) {
        if (null == head) {
            return false;
        }
        Set<ListNode> nodesSeen = new HashSet<>();
        while (null != head) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    public static void createCycle(ListNode head) {
        ListNode tail = head;
        ListNode poiNode = tail.next.next;
        while (null != tail.next) {
            tail = tail.next;
        }
        tail.next = poiNode;
    }

    public static ListNode initLinkedList(int num) {
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
