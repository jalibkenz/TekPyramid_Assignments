package Assn_2025_11_22.Queue;
/**
 * @author Jalib Kenz
 * @since 2025-11-22
 *.
 * Queue Using Array (Linear / Circular Approach)
 *.
 * Design:
 * - Uses an integer array of fixed capacity: int[] arr
 * - front : index of the first element in the queue
 * - rear  : index of the last inserted element
 * - size  : current number of elements
 * - capacity : total size of the array
 *.
 * Logical Order:
 *      front → arr[...] → arr[...] → arr[...] → rear
 *.
 * Circular Index Movement:
 *      rear  = (rear + 1) % capacity
 *      front = (front + 1) % capacity
 *.
 * Requirement:
 * - FIFO (First-In First-Out)
 * - Insert at rear, remove from front
 */


class QueueUsingArray {
    private final int[] arr;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    // Dequeue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int removed = arr[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Is full
    public boolean isFull() {
        return size == capacity;
    }

    // Size
    public int size() {
        return size;
    }
}


class MainClass2 {
    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.size());
        System.out.println("Dequeue ->" + q.dequeue()); // 10
        System.out.println("Peek ->" + q.peek());    // 20
    }
}

