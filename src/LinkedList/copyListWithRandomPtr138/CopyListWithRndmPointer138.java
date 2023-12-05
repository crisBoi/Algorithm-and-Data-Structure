package LinkedList.copyListWithRandomPtr138;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CopyListWithRndmPointer138 {
    public static void main(String[] args) {
        Solution138 sol = new Solution138();

        Node first = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);


        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        fifth.random = null;
        second.random = fourth;
        third.random = fifth;
        fourth.random = first;
        fifth.random = third;

        sol.print(first);

        Node newList = sol.getListCopy(first);

        sol.print(newList);

    }
}

class Solution138 {

    void print(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    Node getListCopy(Node head) {
        LinkedHashMap<Node, Node> oldToNewObj = new LinkedHashMap<>();

        Node originalH = head;

        while (originalH != null) {
            oldToNewObj.put(originalH, new Node(originalH.val));
            originalH = originalH.next;
        }

        Node newList = new Node(-1);

        if (oldToNewObj.isEmpty()) {
            return null;
        }

        int i = 0;
        for (Map.Entry<Node, Node> entrySet: oldToNewObj.entrySet()) {

            if (i == 0) {
                newList.next = oldToNewObj.get(entrySet.getKey());
                i++;
            }

            oldToNewObj.get(entrySet.getKey()).next = oldToNewObj.get(entrySet.getKey().next);
            oldToNewObj.get(entrySet.getKey()).random = oldToNewObj.get(entrySet.getKey().random);

        }

        return newList.next;

    }

    Node getCopyOptimized(Node head) {
        Node curr = head;

        HashMap<Node, Node> oldToNew = new HashMap<>();

        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
             curr = curr.next;
        }

        return oldToNew.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        next = null;
        random = null;
    }
}
