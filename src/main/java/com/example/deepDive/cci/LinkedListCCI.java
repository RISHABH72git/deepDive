package com.example.deepDive.cci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListCCI {
    LinkedListCCI next;
    int val;
    private LinkedListCCI head;

    public LinkedListCCI(int data) {
        this.val = data;
        this.head = this;
    }

    public LinkedListCCI(int data, LinkedListCCI linkedListCCI) {
        this.val = data;
        this.head = this;
        this.next = linkedListCCI;
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
            System.out.println(head.val);
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
        this.head = head;
        for (int i = 0; i < integerList.size(); i++) {
            head.next = new LinkedListCCI(integerList.get(i));
            head = head.next;
        }
        return head;
    }

    public void removeDuplicatesBySets() {
        LinkedListCCI node = this;
        Set<Integer> seenValues = new HashSet<>();
        seenValues.add(node.val);

        while (node.next != null) {
            if (seenValues.contains(node.next.val)) {
                node.next = node.next.next;
            } else {
                seenValues.add(node.next.val);
                node = node.next;
            }
        }
    }

    public void removeDuplicateWithoutBuffer() {
        LinkedListCCI current = head;
        while (current != null) {
            LinkedListCCI nextNode = current;
            while (nextNode.next != null) {
                if (current.val == nextNode.next.val) {
                    nextNode.next = nextNode.next.next;
                } else {
                    nextNode = nextNode.next;
                }
            }
            current = current.next;
        }
    }

    public LinkedListCCI returnKthToLast(int k) {
        LinkedListCCI current = this;
        List<LinkedListCCI> list = new ArrayList<>();
        while (current != null) {
            list.add(current);
            current = current.next;
        }
        return list.get(list.size() - k);
    }

    public LinkedListCCI returnKthToLastWithOutBuffer(int k) {
        LinkedListCCI p1 = this;
        LinkedListCCI p2 = this;
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public void reverseLinkedListByList() {
        LinkedListCCI current = this;
        List<Integer> allList = new ArrayList<>();
        while (current != null) {
            allList.add(current.val);
            current = current.next;
        }
        LinkedListCCI newCurrent = this;
        newCurrent.val = allList.get(allList.size() - 1);
        for (int i = allList.size() - 2; i >= 0; i--) {
            newCurrent.next = new LinkedListCCI(allList.get(i));
            newCurrent = newCurrent.next;
        }
    }

    public void reverseLinkedList() {
        LinkedListCCI current = this;
        LinkedListCCI previous = null;
        while (current != null) {
            LinkedListCCI nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head = previous;
    }

    public void deleteHead() {
        LinkedListCCI current = this;
        if (current.next != null) {
            current = current.next;
        }
        head = current;
    }

    public void printAllLinkedListItem() {
        LinkedListCCI current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public void deleteMiddleNode() {
        LinkedListCCI slow = head;
        LinkedListCCI fast = slow;

        while (slow.next != null) {
            if (fast.next == null || fast.next.next == null) {
                LinkedListCCI current = this.head;
                while (current.next != null) {
                    if (current.next.val == slow.val) {
                        current.next = slow.next;
                    }
                    current = current.next;
                }
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public void deleteMiddleNodeOptimize() {
        LinkedListCCI dummy = new LinkedListCCI(0);
        dummy.next = this.head;
        LinkedListCCI fast = this.head;
        LinkedListCCI slow = dummy;
        this.head = dummy;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        this.head = dummy.next;
    }

    public void partitionInLinkedList(int partition) {
        LinkedListCCI current = this.head;
        LinkedListCCI smallHead = new LinkedListCCI(0, current);
        LinkedListCCI largerHead = new LinkedListCCI(0, current);
        LinkedListCCI larger = largerHead;
        LinkedListCCI smaller = smallHead;
        while (current != null) {
            if (current.val < partition) {
                smaller.next = current;
                smaller = smaller.next;
            } else {
                larger.next = current;
                larger = larger.next;
            }
            current = current.next;
        }
        larger.next = null;
        smaller.next = largerHead.next;
        this.head = smallHead.next;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 2, 9, 4, 3, 5, 6, 5);
        LinkedListCCI linkedListCCI = new LinkedListCCI(1);
        linkedListCCI.createLinkedList(list);
//        linkedListCCI.removeDuplicateWithoutBuffer();
//        linkedListCCI.reverseLinkedListByList();
//        linkedListCCI.reverseLinkedList();
//        while (reversed != null) {
//            System.out.println(reversed.val);
//            reversed = reversed.next;
//        }
//        linkedListCCI.deleteHead();
//        LinkedListCCI listCCI =
//        linkedListCCI.deleteMiddleNodeOptimize();
//        while (listCCI != null) {
//            System.out.println(listCCI.val);
//            listCCI = listCCI.next;
//        }
        linkedListCCI.partitionInLinkedList(5);
        linkedListCCI.printAllLinkedListItem();
//        System.out.println("-------------------");
//        LinkedListCCI kthElement = linkedListCCI.returnKthToLast(2);
//        System.out.println(kthElement.val);
//        LinkedListCCI kthElement2 = linkedListCCI.returnKthToLastWithOutBuffer(2);
//        System.out.println(kthElement2.val);
    }
}
