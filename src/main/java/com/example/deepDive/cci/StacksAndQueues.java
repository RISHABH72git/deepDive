package com.example.deepDive.cci;

import java.util.EmptyStackException;
import java.util.List;

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

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.insertData(List.of(1, 2, 3, 4, 5, 6));
        myStack.printStack();
    }
}
