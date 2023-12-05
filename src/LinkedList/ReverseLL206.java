package LinkedList;

public class ReverseLL206 {
    public static void main(String[] args) {
      /*  LinkedList.CycleInLinkeList.LinkedList ll = new LinkedList.CycleInLinkeList.LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        ll.print();
        ll.reverseLinkedList();
        ll.print();*/
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

class LinkedList {
    Node head;

    LinkedList() {
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

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverseLinkedList() {
        if (head == null || head.next == null) return;

        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
}
