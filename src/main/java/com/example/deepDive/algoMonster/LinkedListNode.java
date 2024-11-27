package com.example.deepDive.algoMonster;

public class LinkedListNode<T> {
    public T val;
    public LinkedListNode<T> next;

    public LinkedListNode(T val) {
        this(val, null);
    }

    public LinkedListNode(T val, LinkedListNode<T> next) {
        this.val = val;
        this.next = next;
    }
}