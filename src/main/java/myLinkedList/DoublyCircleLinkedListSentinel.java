package myLinkedList;

import java.util.Iterator;

public class DoublyCircleLinkedListSentinel implements Iterable<Integer> {
    //双向环形链表实现

    private Node sentinel = new Node(null, 0, null);

    public DoublyCircleLinkedListSentinel() {
        //初始化哨兵
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);

        //双向环形链表需要考虑四个指针
        a.next = added;
        b.prev = added;
    }

    public void addLast(int value) {
        Node b = sentinel;
        Node a = sentinel.prev;
        Node added = new Node(a, value, b);

        //维护四个指针
        b.prev = added;
        a.next = added;
    }

    public void removeFirst() {
        Node removed = sentinel.next;

        //如果链表中只有哨兵节点的话，不能够删除哨兵节点
        if (removed == sentinel) {
            throw new NullPointerException("do not have element");
        }
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new NullPointerException("do not have element");
        }
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }

    public void removeByValue(int value) {
        Node removed = findValue(value);
        if (removed == null) {
            throw new NullPointerException("do not have this element");
        }
        Node a = removed.prev;
        Node b = removed.next;

        //跳过removed即可
        a.next = b;
        b.prev = a;
    }

    private Node findValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /**
     * 内部类：节点类
     */
    private static class Node {
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
