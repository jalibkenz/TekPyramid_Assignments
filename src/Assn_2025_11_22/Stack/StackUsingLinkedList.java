package Assn_2025_11_22.Stack;

/**
 * @author Jalib Kenz
 * @since 2025-11-22
 * design : head -> [newest] -> [older] -> [oldest] -> null
 * Actual Design : Node1[data | Node1.1[data|Node1.1.1[data|Node1.1.1.1[.....]]]]
 */


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {
    private Node head;   // head = top of stack
    private int size;

    // Push = insert at head
    public void push(int x) {
        Node newNode = new Node(x); // creating a new node with data as "x" and the Node
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Pop = remove from head
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = head.data;// taking out the head data at the leftmost end
        head = head.next; // setting head as the next Node on to the right of the head
        size--;
        return value;
    }

    // Peek = top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data; //peeking head node's data
    }

    // Is empty?
    public boolean isEmpty() {
        return head == null;
    }

    // Size of stack
    public int size() {
        return size;
    }
}

class Main {
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.size());

        System.out.println(stack.pop());  // 30
        System.out.println(stack.peek()); // 20
    }
}


