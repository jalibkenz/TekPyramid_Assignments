package Assn_2025_11_22.MS_CQ_DeQ;
import java.util.NoSuchElementException;

/**
 * Circular Queue (array-backed)
 *
 * - Fixed capacity circular buffer
 * - front: index of current first element
 * - rear : index of next insertion position
 * - count: current number of elements
 *
 * Methods:
 * - enqueue(x)  O(1)
 * - dequeue()   O(1)
 * - peek()      O(1)
 * - isEmpty(), isFull(), size()
 *
 * Author:  Jalib Kenz
 * Since :  2025-11-22
 */
public class CircularQueue {
    private final int[] arr;
    private final int capacity;
    private int front;   // index of first element
    private int rear;    // index of next insertion
    private int count;   // number of elements

    public CircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = 0;
        this.rear = 0;
        this.count = 0;
    }

    public void enqueue(int x) {
        if (isFull()) throw new IllegalStateException("Queue is full");
        arr[rear] = x;
        rear = (rear + 1) % capacity;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue empty");
        int v = arr[front];
        front = (front + 1) % capacity;
        count--;
        return v;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue empty");
        return arr[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public int size() {
        return count;
    }

    // debug printing: front -> ... -> rear-1
    public void printQueue() {
        System.out.print("CircularQueue: ");
        for (int i = 0; i < count; i++) {
            int idx = (front + i) % capacity;
            System.out.print(arr[idx] + (i == count - 1 ? "" : " -> "));
        }
        System.out.println();
    }

    // demo
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(4);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.printQueue();            // 10 -> 20 -> 30
        System.out.println(q.dequeue()); // 10
        q.printQueue();            // 20 -> 30
        q.enqueue(40);
        q.enqueue(50);
        q.printQueue();            // 20 -> 30 -> 40 -> 50
        // q.enqueue(60); // would throw (full)
        while (!q.isEmpty()) System.out.println("d:" + q.dequeue());
    }
}

