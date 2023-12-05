package LinkedList.addTwoNumbers2;

import LinkedList.ListNode;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        LL ll = new LL();
        ll.printLL(l1);
        ll.printLL(l2);

        ll.printLL(ll.addLinkedList(l1, l2));
    }
}

class LL {

    void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    ListNode addLinkedList(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1), tail = result;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = l1.val + l2.val + carry;
            if (x > 9) {
                carry = x / 10;
                x = x % 10;
            } else {
                carry = 0;
            }

            tail.next = new ListNode(x);
            tail = tail.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int x = l1.val + carry;
            if (x > 9) {
                carry = x / 10;
                x = x % 10;
            } else {
                carry = 0;
            }

            tail.next = new ListNode(x);
            tail = tail.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int x = l2.val + carry;
            if (x > 9) {
                carry = x / 10;
                x = x % 10;
            } else {
                carry = 0;
            }

            tail.next = new ListNode(x);
            tail = tail.next;

            l2 = l2.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
            carry = 0;
            tail = tail.next;
        }

        return result.next;

    }
}
