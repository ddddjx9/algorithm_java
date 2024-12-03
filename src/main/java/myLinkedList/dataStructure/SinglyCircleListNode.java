package myLinkedList.dataStructure;

import java.util.ArrayList;
import java.util.Iterator;

public class SinglyCircleListNode implements Iterable<Integer> {
    public Node next;
    private static Node sentinel = new Node(-1, null);

    public SinglyCircleListNode() {
        sentinel.next = sentinel;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addLast(int value) {
        Node last = findLast();
        Node added = new Node(value, sentinel);
        last.next = added;
    }

    public Node findLast() {
        Node a = sentinel.next;
        while (a.next != sentinel) {
            a = a.next;
        }
        return a;
    }

    public Node findPrev(Node target) {
        Node a = sentinel.next;
        while (a.next != sentinel) {
            if (a.next == target) {
                return a;
            }
            a = a.next;
        }

        if (sentinel.next == target) {
            return sentinel;
        }
        return null;
    }

    public int getSize() {
        int size = 0;
        for (Node a = sentinel.next; a != sentinel; a = a.next) {
            size++;
        }
        return size;
    }

    public ArrayList<Integer> joseph(int a, int b) {
        ArrayList<Integer> record = new ArrayList<>();
        SinglyCircleListNode list = new SinglyCircleListNode();
        for (int i = 1; i <= a; i++) {
            list.addLast(i);
        }

        Node p = sentinel.next;
        int count = 0;
        while (getSize() > 0) {
            count++;
            if (count == b) {
                record.add(p.value);
                Node prev = findPrev(p);
                prev.next = p.next;
                p = prev.next;
                count = 0;
            } else {
                p = p.next;
                if (p == sentinel) {
                    p = p.next;
                }
            }
        }
        return record;
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
}