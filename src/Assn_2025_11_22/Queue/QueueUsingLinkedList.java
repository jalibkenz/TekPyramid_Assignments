package Assn_2025_11_22.Queue;

import java.util.NoSuchElementException;

/**
 * Queue Using Linked List (Using Fixed LL Design)
 *
 * @author Jalib Kenz
 * @since 2025-11-22
 *.
 * Fixed LinkedList Design (Always)
 * --------------------------------
 * head -> [newest] -> [older] -> [oldest] -> null
 *.
 * Meaning:
 * - head always points to the most recently inserted node (newest)
 * - next pointers move toward older nodes
 * - the final node (tail) is the oldest and points to null
 *.
 * Queue Behavior (FIFO)
 * ---------------------
 * - enqueue(data):
 *     Insert at head (newest)          O(1)
 *.
 * - dequeue():
 *     Remove the last node (oldest)
 *     Requires traversal to find second-last node  O(n)
 *.
 * Logical Queue Structure
 * ------------------------
 * head -> [newest] -> [older] -> [older...] -> [oldest] -> null
 *                                                       ^
 *                                                 (removed first)
 *.
 * Actual Node Representation
 * ---------------------------
 * Node head {
 *   [newest data] | next -> Node2 {
 *                        [older data] | next -> Node3 {
 *                                           [oldest data] | next -> null
 *                        }
 *   }
 * }
 */
class Node {
    int data;
    Node next;

    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

public class QueueUsingLinkedList {

    private Node head;   // newest
    private int size;

    public QueueUsingLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // enqueue: insert at head (newest) -> O(1)
    public void enqueue(int value) {
        Node newNode = new Node(value);
        newNode.next = head; // newNode points to older chain
        head = newNode;      // head becomes newest
        size++;
    }

    // dequeue: remove oldest node -> O(n)
    public int dequeue() {
        if (head == null) {
            throw new NoSuchElementException("Queue empty");
        }

        // If only one node
        if (head.next == null) {
            int val = head.data;
            head = null;
            size--;
            return val;
        }

        // Traverse until temp is the second-last node
        // (i.e., temp.next is the last node where its next == null)
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // temp.next is the oldest
        int val = temp.next.data;
        temp.next = null; // remove oldest
        size--;

        return val;
    }

    // Peek oldest element -> O(n)
    public int peek() {
        if (head == null)
            throw new NoSuchElementException("Queue empty");

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        return temp.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        Node temp = head;
        System.out.print("Queue (newest → oldest): ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // sample main for quick manual test
    public static void main(String[] args) {

        QueueUsingLinkedList q = new QueueUsingLinkedList();

        System.out.println("3 Enqueue operations: Done.\n");
        q.enqueue(10);  // newest
        q.enqueue(20);
        q.enqueue(30);  // oldest is 10

        q.printQueue();

        System.out.println("\nPeek oldest (FIFO): " + q.peek());

        System.out.println("\nDequeue operations:");
        System.out.println("Dequeued: " + q.dequeue());  // should remove 10
        q.printQueue();

        System.out.println("Dequeued: " + q.dequeue());  // should remove 20
        q.printQueue();

        System.out.println("Dequeued: " + q.dequeue());  // should remove 30
        q.printQueue();

        System.out.println("\nIs queue empty? " + q.isEmpty());
        System.out.println(q.size());
    }
}
