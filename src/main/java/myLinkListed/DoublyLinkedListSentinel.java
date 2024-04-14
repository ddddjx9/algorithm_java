package myLinkListed;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {
    //双向链表 - 带哨兵
    //对双向链表来说，尾哨兵和头哨兵都是已知的
    //可以通过尾哨兵的previous得到最后一个节点，不用从头进行查找

    //哨兵 - 头部
    private Node head;  //头指针
    private Node tail;  //尾指针

    public DoublyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);

        //没有添加元素之前，头指针的下一个元素指向尾指针，尾指针的前一个元素指向头指针
        head.next = tail;
        tail.previous = head;
    }

    /**
     * 工具类方法，对外隐藏实现接口，所以设置成private，根据索引查找相应的节点
     *
     * @param index 给出的索引值
     * @return 返回查找到的节点，没有找到返回null
     */
    private Node findNode(int index) {
        Node p = head;
        int i = -1;
        //因为是双向链表，所以当是尾哨兵的时候，代表双向链表的结束
        while (p != tail) {
            if (i == index) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }

    public void insert(int index, int value) {
        Node previous = findNode(index - 1);
        if (previous == null) {
            throw new IllegalArgumentException("索引不合法！" + String.format("index [%d]", index));
        }
        Node next = previous.next;
        Node inserted = new Node(previous, value, next);
        previous.next = inserted;
        next.previous = inserted;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void remove(int index) {
        Node previous = findNode(index - 1);
        if (previous == null) {
            throw new IllegalArgumentException("索引不合法！" + String.format("index [%d]", index));
        }
        Node removed = previous.next;

        //如果被删除元素是尾哨兵，不行，抛出异常
        if (removed == tail) {
            throw new IllegalArgumentException("索引不合法！" + String.format("index [%d]", index));
        }
        Node next = removed.next;
        previous.next = next;
        next.previous = previous;
    }

    public void removeFirst() {
        remove(0);
    }

    public void addLast(int value) {
        Node last = tail.previous;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.previous = added;
    }

    public void removeLast() {
        //如果是空链表，那么就只有尾哨兵和头哨兵，所以两次previous会报错
        Node removed = tail.previous;
        if (removed == head) {
            throw new NullPointerException("do not have element");
        }
        Node previous = removed.previous;
        tail.previous = previous;
        previous.next = tail;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
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
     * 内部类：节点类，双向链表和该类为包含关系，所以设计为内部类
     */
    static class Node {
        Node previous; //代表上一个指针
        int value;
        Node next; //代表当前节点的下一个指针

        public Node(Node previous, int value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
