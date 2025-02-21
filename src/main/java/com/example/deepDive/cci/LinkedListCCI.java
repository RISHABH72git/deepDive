package com.example.deepDive.cci;

import java.util.List;

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

    private LinkedListCCI createLinkedList(List<Integer> integerList) {
        LinkedListCCI head = this;
        for (int i = 0; i < integerList.size(); i++) {
            head.next = new LinkedListCCI(integerList.get(i));
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 6, 7, 8, 9);
        LinkedListCCI linkedListCCI = new LinkedListCCI(5);
        linkedListCCI.createLinkedList(list);
        while (linkedListCCI.next != null) {
            System.out.println(linkedListCCI.val);
            linkedListCCI = linkedListCCI.next;
        }
    }
}
