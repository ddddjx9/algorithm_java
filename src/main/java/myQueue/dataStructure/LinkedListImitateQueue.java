package myQueue.dataStructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

//使用单向环形链表来模拟队列
//考虑队列容量问题，一旦超出容量，那么就不能再加入元素，offer方法返回false
public class LinkedListImitateQueue<E> implements Queue<E>, Iterable<E> {
    private static class Node<E> {
        //内部类，节点依赖于链表存在，所以写成内部类
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<E> head = new Node<>(null, null);
    Node<E> tail = head;
    private int capacity = Integer.MAX_VALUE;
    private int size;

    //构造方法中如果有重复代码，将之写在初始化语句块中
    {
        tail.next = head;
    }

    public LinkedListImitateQueue(int capacity) {
        //如果被调用，由用户指定容量，如果没有被调用，默认无限加入
        this.capacity = capacity;
    }

    public LinkedListImitateQueue() {
        tail.next = head;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> last = new Node<>(e, head);
        tail.next = last;
        tail = last;
        size++;
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        //取出队列头部的元素，并移除
        //环形链表，不用考虑为null的情况，每个节点肯定都有后继
        if (isEmpty()) {
            return null;
        }
        //如果只剩一个元素。tail指针的值应该被更新
        Node<E> first = head.next;
        if (first == tail) {
            tail = head;
        }
        head.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        //返回队列头部的元素，不移除队列头部的元素
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    /**
     * 检查队列是否已满
     *
     * @return 如果满，返回true，如果没满，返回false
     */
    public boolean isFull() {
        return size == capacity;
    }
}
