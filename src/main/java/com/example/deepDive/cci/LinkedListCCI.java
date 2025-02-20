package com.example.deepDive.cci;

public class LinkedListCCI {
    LinkedListCCI next;
    int val;

    public LinkedListCCI(int data) {
        this.val = data;
    }

    private void appendToTail(int data) {
        LinkedListCCI last = new LinkedListCCI(data);
        LinkedListCCI node = this;
        while (node.next != null) {
            node = node.next;
        }
        node.next = last;
    }

    private LinkedListCCI deleteFromLinkedList(int data) {
        LinkedListCCI head = this;
        if (head.val == data) {
            return head.next;
        }
        while (head.next != null) {
            if (head.next.val == data) {
                head.next = head.next.next;
                return head;
            }
            head = head.next;
        }
        return head;
    }

    private LinkedListCCI addHead(int data) {
        LinkedListCCI newHead = new LinkedListCCI(data);
        newHead.next = this;
        return newHead;
    }
}
