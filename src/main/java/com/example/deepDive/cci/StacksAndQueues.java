package com.example.deepDive.cci;

import java.util.Arrays;
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

        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        Integer size = 0;

        public T pop() {
            if (top == null) throw new EmptyStackException();
            T item = this.top.data;
            this.top = this.top.next;
            size--;
            return item;
        }

        public void push(T data) {
            StackNode<T> t = new StackNode<T>(data);
            if (min > (Integer) data) {
                min = (Integer) data;
            }
            if (max < (Integer) data) {
                max = (Integer) data;
            }
            t.next = top;
            top = t;
            size++;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException();
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public int minElement() {
            if (top == null) throw new EmptyStackException();
            Integer min = Integer.MAX_VALUE;
            while (top != null) {
                if (min > (Integer) top.data) {
                    min = (Integer) top.data;
                }
                top = top.next;
            }
            return min;
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

    public static class TripleStack {
        int[] capacity = new int[15];
        int size = 5;
        int[] top = new int[]{4, 9, 14};

        public void push(int stack, int data) {
            if (top[stack - 1] < ((size * stack) - size)) {
                System.out.println("stack is already full");
                return;
            }
            int index = top[stack - 1];
            capacity[index] = data;
            top[stack - 1] = index - 1;
        }

        public int peek(int stack) {
            if (top[stack - 1] == ((size * stack) - 1)) throw new EmptyStackException();
            System.out.println(Arrays.toString(capacity));
            System.out.println(Arrays.toString(top));
            System.out.println(capacity[top[stack - 1] + 1]);
            return capacity[top[stack - 1] + 1];
        }

        public int pop(int stack) {
            if (top[stack - 1] == ((size * stack) - 1)) throw new EmptyStackException();
            return top[stack - 1]++;
        }

        public boolean isEmpty(int stack) {
            return top[stack - 1] == ((size * stack) - 1);
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

    public static class TwoStackQueue {
        MyStack<Integer> newStack, oldStack;

        public TwoStackQueue() {
            newStack = new MyStack<>();
            oldStack = new MyStack<>();
        }

        public void push(Integer data) {
            newStack.push(data);
        }

        private void shiftStacks() {
            if (!newStack.isEmpty()) {
                while (!newStack.isEmpty()) {
                    oldStack.push(newStack.pop());
                }
            }
        }

        public Integer peek() {
            shiftStacks();
            return oldStack.top.data;
        }

        public Integer remove() {
            shiftStacks();
            return oldStack.pop();
        }
    }

    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();
        myStack.insertData(List.of(7, 2, 3, 4, 5, 6, 0, 4));
        myStack.pop();
        System.out.println(myStack.size);
        System.out.println(myStack.min);
        System.out.println(myStack.max);
        System.out.println(myStack.minElement());
        myStack.printStack();
        TripleStack tripleStack = new TripleStack();
        tripleStack.push(1, 5);
        tripleStack.push(1, 55);
        tripleStack.push(1, 6);
        tripleStack.push(1, 99);
        tripleStack.push(1, 33);
        tripleStack.push(1, 23);
        tripleStack.peek(1);
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.push(2);
        twoStackQueue.push(4);
        twoStackQueue.push(5);
        twoStackQueue.push(6);
        System.out.println(twoStackQueue.peek());
        twoStackQueue.remove();
        System.out.println(twoStackQueue.peek());
        twoStackQueue.remove();
        System.out.println(twoStackQueue.peek());
    }
}
