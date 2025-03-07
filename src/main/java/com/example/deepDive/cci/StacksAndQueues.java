package com.example.deepDive.cci;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

public class StacksAndQueues {
    public static class MyStack<T> {
        private static class StackNode<T> {
            private T data;
            private StackNode<T> next;

            public StackNode(T data) {
                this.data = data;
            }
        }

        private StackNode<T> top;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = this.top.data;
            this.top = this.top.next;
            return item;
        }

        public void push(T data) {
            StackNode<T> t = new StackNode<T>(data);
            t.next = top;
            top = t;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void printStack() {
            while (top != null) {
                System.out.println(top.data);
                top = top.next;
            }
        }

        public void insertData(List<T> list) {
            for (T ele : list) {
                push(ele);
            }
        }
    }

    public static class MyQueue<T> {
        private static class MyQueueNode<T> {
            private T data;
            private MyQueueNode<T> next;

            public MyQueueNode(T data) {
                this.data = data;
            }
        }

        private MyQueueNode<T> first;
        private MyQueueNode<T> last;

        public void add(T data) {
            MyQueueNode<T> newQueue = new MyQueueNode<>(data);
            if (last != null) {
                last.next = newQueue;
            }
            last = newQueue;
            if (first == null) {
                first = last;
            }
        }

        public T remove() {
            if (first == null) throw new NoSuchElementException();
            T data = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return data;
        }

        public T peek() {
            if (first == null) throw new NoSuchElementException();
            return first.data;
        }

        public boolean isEmpty() {
            return first == null;
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.insertData(List.of(1, 2, 3, 4, 5, 6));
        myStack.printStack();
    }
}
