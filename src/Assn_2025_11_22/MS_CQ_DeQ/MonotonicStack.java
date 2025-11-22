package Assn_2025_11_22.MS_CQ_DeQ;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Monotonic Stack (supports push/pop/top and getMax)
 *
 * - Maintains primary stack for values and a monotonic (decreasing) helper stack
 *   so getMax() returns the current maximum in O(1).
 *
 * Behavior:
 * - push(x): pushes x, and updates helper stack by popping smaller values
 * - pop(): pops and synchronizes helper stack
 * - top(): returns top element
 * - getMax(): returns current maximum
 *
 * Author:  Jalib Kenz
 * Since :  2025-11-22
 */
public class MonotonicStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> mono; // monotonic decreasing: top = current max

    public MonotonicStack() {
        this.stack = new Stack<>();
        this.mono = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        // Maintain monotonic decreasing property: remove values < x
        while (!mono.isEmpty() && mono.peek() < x) {
            mono.pop();
        }
        mono.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) throw new NoSuchElementException("Stack empty");
        int v = stack.pop();
        if (!mono.isEmpty() && mono.peek() == v) {
            mono.pop();
        }
        return v;
    }

    public int top() {
        if (stack.isEmpty()) throw new NoSuchElementException("Stack empty");
        return stack.peek();
    }

    /** O(1) current maximum (or throws if empty) */
    public int getMax() {
        if (mono.isEmpty()) throw new NoSuchElementException("Stack empty");
        return mono.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    // quick demo
    public static void main(String[] args) {
        MonotonicStack ms = new MonotonicStack();
        ms.push(2);
        ms.push(1);
        ms.push(5);
        ms.push(3);
        System.out.println("Top: " + ms.top());      // 3
        System.out.println("Max: " + ms.getMax());  // 5
        System.out.println("Popped: " + ms.pop());  // 3
        System.out.println("Max: " + ms.getMax());  // 5
        System.out.println("Popped: " + ms.pop());  // 5
        System.out.println("Max: " + ms.getMax());  // 2
    }
}
