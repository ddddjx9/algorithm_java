package myStack;

import java.util.Iterator;

public class LinkedListStack<E> implements Stack<E>, Iterable<E> {
    private int capacity;
    private int size = 0;
    //这里栈只能在栈顶操作元素，所以使用一个指针就可以了
    private Node<E> head = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /*
        2 ->
        head -> 1 -> null
        head -> 2 -> 1 -> null
     */
    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(head.next, value);
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    static class Node<E> {
        Node<E> next;
        E value;

        public Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }
    }
}
