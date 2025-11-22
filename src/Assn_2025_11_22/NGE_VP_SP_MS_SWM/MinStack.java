package Assn_2025_11_22.NGE_VP_SP_MS_SWM;

import java.util.Stack;
import java.util.NoSuchElementException;

public class MinStack {
    private final Stack<Integer> data;
    private final Stack<Integer> mins;

    public MinStack() {
        data = new Stack<>();
        mins = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (mins.isEmpty() || x <= mins.peek()) {
            mins.push(x);
        }
    }

    public int pop() {
        if (data.isEmpty()) throw new NoSuchElementException("Stack empty");
        int v = data.pop();
        if (v == mins.peek()) mins.pop();
        return v;
    }

    public int top() {
        if (data.isEmpty()) throw new NoSuchElementException("Stack empty");
        return data.peek();
    }

    public int getMin() {
        if (mins.isEmpty()) throw new NoSuchElementException("Stack empty");
        return mins.peek();
    }

    public boolean isEmpty() { return data.isEmpty(); }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(3);
        ms.push(5);
        System.out.println("Min: " + ms.getMin()); // 3
        ms.push(2);
        ms.push(2);
        System.out.println("Min: " + ms.getMin()); // 2
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 2
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 3
    }
}

