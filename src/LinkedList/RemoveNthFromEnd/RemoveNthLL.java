package LinkedList.RemoveNthFromEnd;


import LinkedList.ListNode;

public class RemoveNthLL {
    public static void main(String[] args) {

    }

    ListNode removeLast(ListNode head, int nth) {
        if (head == null) return head;

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode fast = head, slow = temp;

        int iteration = nth;

        while (iteration > 0 && fast != null) {
            fast = fast.next;
            iteration--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return temp.next;
    }
}

