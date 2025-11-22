package Assn_2025_11_22.MS_CQ_DeQ;

import java.util.NoSuchElementException;

/**
 * Deque (Double Ended Queue) using Doubly Linked List
 *
 * Operations:
 * - addFirst(x)      O(1)
 * - addLast(x)       O(1)
 * - removeFirst()    O(1)
 * - removeLast()     O(1)
 * - peekFirst()      O(1)
 * - peekLast()       O(1)
 *
 * Author:  Jalib Kenz
 * Since :  2025-11-22
 */
public class Deque<T> {

    // Doubly Linked List Node
    private static class Node<T> {
        T data;
        Node<T> prev, next;
        Node(T d) { data = d; }
    }

    private Node<T> head; // front
    private Node<T> tail; // rear
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Insert at front */
    public void addFirst(T value) {
        Node<T> n = new Node<>(value);

        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    /** Insert at rear */
    public void addLast(T value) {
        Node<T> n = new Node<>(value);

        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    /** Remove from front */
    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("Deque empty");

        T val = head.data;
        head = head.next;

        if (head == null) tail = null;
        else head.prev = null;

        size--;
        return val;
    }

    /** Remove from rear */
    public T removeLast() {
        if (tail == null) throw new NoSuchElementException("Deque empty");

        T val = tail.data;
        tail = tail.prev;

        if (tail == null) head = null;
        else tail.next = null;

        size--;
        return val;
    }

    /** Peek front */
    public T peekFirst() {
        if (head == null) throw new NoSuchElementException("Deque empty");
        return head.data;
    }

    /** Peek rear */
    public T peekLast() {
        if (tail == null) throw new NoSuchElementException("Deque empty");
        return tail.data;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    /** Print for debugging */
    public void printDeque() {
        Node<T> cur = head;
        System.out.print("Deque (front → rear): ");
        while (cur != null) {
            System.out.print(cur.data + (cur.next == null ? "" : " ↔ "));
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Deque<Integer> dq = new Deque<>();

        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(5);

        dq.printDeque();  // 5 ↔ 10 ↔ 20

        System.out.println("removeLast(): " + dq.removeLast());   // 20
        dq.printDeque();  // 5 ↔ 10

        System.out.println("removeFirst(): " + dq.removeFirst()); // 5
        dq.printDeque();  // 10

        dq.addLast(30);
        dq.addLast(40);
        dq.printDeque();  // 10 ↔ 30 ↔ 40

        System.out.println("peekFirst(): " + dq.peekFirst()); // 10
        System.out.println("peekLast(): " + dq.peekLast());   // 40
    }
}
