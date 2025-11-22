package Assn_2025_11_22.Stack;

/**
 * @author Jalib Kenz
 * @since 2025-11-22
 * design : int[] arr |      [0][1][2][3]   | top =  index utilised in capacity | size = length of the array
 */

public class StackUsingArray {
    private final int[] arr;
    private int top;
    private final int capacity;

    // Constructor
    public StackUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Push operation
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack is full, Hence Stack Overflow");
            return;
        }
        arr[++top] = x; // increase top and insert
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty, Hence Stack Underflow");
            return -1;
        }
        return arr[top--]; // return and decrease top
    }

    // Peek operation
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        }
        System.out.println("Stack is Empty");
        return -1;
    }

    // Check empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Size of stack
    public int size() {
        return top + 1;
    }
}


class MainClass1 {
    public static void main(String[] args) {
        //Example1
        StackUsingArray stack1 = new StackUsingArray(5);

        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        System.out.println(stack1.size());


        System.out.println(stack1.pop());  // 30
        System.out.println(stack1.peek()); // 20

        //Example2
        StackUsingArray stack2 = new StackUsingArray(10);

        stack2.push(110);
        stack2.push(120);
        stack2.push(130);
        System.out.println(stack2.size());


        System.out.println(stack2.pop());  // 30
        System.out.println(stack2.peek()); // 20
    }
}
