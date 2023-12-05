package LinkedList.ReorderLinkedList;

public class ReorderList {
    static ListNode node = null;
    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        /*print(head);
        ListNode n = reorderList(head);*/
        reorderLL(head);
        print(head);


    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode reorderList(ListNode head) {
        ListNode mid = getMidPoint(head);

        ListNode second = reverse(mid.next);
        mid.next = null;

        return merge(head, second);

    }

    static ListNode getMidPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static ListNode reverse(ListNode head) {
        ListNode current = head, prev = null, next;

        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
    static ListNode merge(ListNode h1, ListNode h2) {
        ListNode tail = new ListNode(-1);
        ListNode _h1 = h1, _h2 = h2;

        int takeFrom = 1;

        while (_h1 != null && _h2 != null) {
            if (takeFrom == 1) {
                tail.next = _h1;
                _h1 = _h1.next;
                takeFrom = 2;
            } else {
                tail.next = _h2;
                _h2 = _h2.next;
                takeFrom = 1;
            }
            tail = tail.next;
            tail.next = null;
        }

         if (_h1 != null) {
             tail.next = _h1;
         }

         if (_h2 != null) {
             tail.next = _h2;
         }

        return h1;
    }

    static void reorderLL(ListNode head) {
        ListNode s = head, f = head.next;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        ListNode prev = null, curr = s.next, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        s.next = null;

        ListNode h1 = head, h2 = prev;

        while (h2 != null) {
             ListNode h1Next = h1.next, h2Next = h2.next;

             h1.next = h2;
             h2.next = h1Next;

             h1 = h1Next;
             h2 = h2Next;

        }
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
