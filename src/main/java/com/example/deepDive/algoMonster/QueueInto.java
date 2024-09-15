package com.example.deepDive.algoMonster;

import java.util.ArrayDeque;

public class QueueInto {
    public static void main(String[] args) {
        peekFirst();
        addFirst(5);
        addFirst(6);
        peekFirst();
        peekLast();
        poll();
        addLast(7);
        addLast(8);
        poll();
        peekFirst();
        peekLast();
        System.out.println(deQueue);
    }

    static ArrayDeque<Integer> deQueue = new ArrayDeque<>();

    private static void peekFirst() {
        if (deQueue.isEmpty()) {
            System.out.println("queue is empty");
        } else {
            System.out.println("Peek First " + deQueue.peekFirst());
        }
    }

    private static void peekLast() {
        if (deQueue.isEmpty()) {
            System.out.println("queue is empty");
        } else {
            System.out.println("Peek Last " + deQueue.peekLast());
        }
    }

    private static void addLast(Integer integer) {
        deQueue.add(integer);
    }

    private static void addFirst(Integer integer) {
        deQueue.addFirst(integer);
    }

    private static void poll() {
        deQueue.poll();
    }

}
