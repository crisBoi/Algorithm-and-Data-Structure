package LinkedList.CycleInLinkeList;

import javax.swing.tree.TreeNode;

public class LinkedListCycle141 {
    public static void main(String[] args) {
        System.out.println("" + ("".isBlank()));
    }
}

class LinkedList141 {
    Node head;

    LinkedList141() {
        head = null;
    }

    void add(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new Node(val);
    }

    boolean isCycle(Node head) {
        if (head == null) return false;
        if (head.next == null || head.next.next == null) return false;

        Node slow = head;
        Node fast = head.next.next;

        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
           if (fast.next.next == null) return false;
           else { fast = fast.next.next;}

           "".isBlank();
        }

        return false;
    }

    boolean isNotBlank(String st) {
        return !st.isBlank();
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
