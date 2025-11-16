package Assn_2025_11_14;

class ListNode {
    int val;
    ListNode next;
    ListNode(int v) { val = v; }
}

public class FindTheMiddleElement {

    public static ListNode findMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;      // move slow by 1
            fast = fast.next.next; // move fast by 2
        }
        return slow; // middle node
    }

    public static void main(String[] args) {

        // Create: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode middle = findMiddle(head);

        System.out.println("Middle node value: " + middle.val);
    }
}


