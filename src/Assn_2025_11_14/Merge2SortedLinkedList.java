package Assn_2025_11_14;

public class Merge2SortedLinkedList {

    // TheNode structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Helper: print list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Merge two sorted linked lists
    static Node mergeSorted(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach remaining elements
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }
    public static void main(String[] args) {
        // -------- Create List 1: 10,20,30,40,50 --------
        Node l1 = new Node(10);
        l1.next = new Node(20);
        l1.next.next = new Node(30);
        l1.next.next.next = new Node(40);
        l1.next.next.next.next = new Node(50);

        // -------- Create List 2: 100,200,300,400,500 --------
        Node l2 = new Node(100);
        l2.next = new Node(200);
        l2.next.next = new Node(300);
        l2.next.next.next = new Node(400);
        l2.next.next.next.next = new Node(500);
        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        // -------- Merge both lists --------
        Node merged = mergeSorted(l1, l2);
        System.out.print("Merged List: ");
        printList(merged);
    }
}

