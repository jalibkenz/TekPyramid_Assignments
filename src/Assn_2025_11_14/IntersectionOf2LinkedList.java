package Assn_2025_11_14;


class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectionOf2LinkedList {
    // Function to get intersection point
    public static Node getIntersection(Node head1, Node head2) {
        Node a = head1;
        Node b = head2;
        // If one pointer reaches null, redirect to other list
        while (a != b) {
            a = (a == null) ? head2 : a.next;
            b = (b == null) ? head1 : b.next;
        }

        return a; // Either intersection node or null
    }

    public static void main(String[] args) {

        // List A: 10 → 20 → 30
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);

        // List B: 100 → 200
        Node head2 = new Node(100);
        head2.next = new Node(200);

        // Common intersection part: 300 → 400 → 500
        Node common = new Node(300);
        common.next = new Node(400);
        common.next.next = new Node(500);

        // Attach intersection
        head1.next.next.next = common;  // List A → 300
        head2.next.next = common;       // List B → 300

        Node intersection = getIntersection(head1, head2);



        if (intersection != null) {
            System.out.println("Intersection at node: " +
                    intersection.data);
        } else {
            System.out.println("No intersection");
        }
    }
}
