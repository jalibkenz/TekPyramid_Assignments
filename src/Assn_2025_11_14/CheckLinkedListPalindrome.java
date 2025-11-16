package Assn_2025_11_14;

class TheNode {
    int data;
    TheNode next;
    TheNode(int d) { data = d; next = null; }
}

public class CheckLinkedListPalindrome {

    // Main function to check palindrome
    public static boolean isPalindrome(TheNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle
        TheNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // For odd number of nodes
        if (fast != null) {
            slow = slow.next;
        }

        // 2. Reverse second half
        TheNode secondHalf = reverseList(slow);
        TheNode copySecond = secondHalf;

        // 3. Compare halves
        TheNode firstHalf = head;
        boolean palindrome = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // 4. Restore
        reverseList(copySecond);

        return palindrome;
    }

    // Helper: reverse list
    private static TheNode reverseList(TheNode head) {
        TheNode prev = null;
        TheNode curr = head;
        while (curr != null) {
            TheNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Utility to print list
    private static void printList(TheNode head) {
        TheNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Test the function
    public static void main(String[] args) {

        TheNode head1 = new TheNode(1);
        head1.next = new TheNode(2);
        head1.next.next = new TheNode(3);
        head1.next.next.next = new TheNode(2);
        head1.next.next.next.next = new TheNode(1);

        System.out.print("List 1: ");
        printList(head1);
        System.out.println("Is palindrome? " + isPalindrome(head1)); // true

        TheNode head2 = new TheNode(1);
        head2.next = new TheNode(2);
        head2.next.next = new TheNode(3);
        head2.next.next.next = new TheNode(4);

        System.out.print("List 2: ");
        printList(head2);
        System.out.println("Is palindrome? " + isPalindrome(head2)); // false
    }
}
