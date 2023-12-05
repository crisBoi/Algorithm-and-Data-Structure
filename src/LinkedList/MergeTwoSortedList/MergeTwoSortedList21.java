package LinkedList.MergeTwoSortedList;

public class MergeTwoSortedList21 {
    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();

        ll1.add(1);
        ll1.add(3);
        ll1.add(5);
        ll1.add(9);

        ll1.print(ll1.head);

        LinkedList ll2 = new LinkedList();

        ll2.add(2);
        ll2.add(4);
        ll2.add(6);
        ll2.add(7);

        ll2.print(ll2.head);

        ll2.print(sortMergeList(ll1.head, ll2.head));

    }

    static Node sortMergeList(Node head1, Node head2) {
        Node newHead = new Node(-1);
        Node newTail = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newTail.next = head1;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                head2 = head2.next;
            }

            newTail = newTail.next;
        }

        if (head1 != null) { newTail.next = head1;}

        if (head2 != null) { newTail.next = head2;}

        return newHead.next;

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

    void print(Node head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
        System.out.println();
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

