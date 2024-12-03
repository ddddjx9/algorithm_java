package myQueue.dataStructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 引入辅助变量size来判断队列的空和满
 * <p>
 * 在初始化队列的时候限定了队列的长度，array.length
 * <p>
 * 那么size只要等于array.length表明队列中已经存满了元素
 * <p>
 * 如果size等于0，表明队列中还没有元素
 *
 * @param <E> 队列中元素的类型
 */
public class CycleArrayQueue2<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    @SuppressWarnings("all")
    public CycleArrayQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                count++;
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
        array[tail] = e;
        //重新计算尾指针的范围，不至于超过它的有效范围
        tail = (tail + 1) % array.length;
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
        if (isEmpty()) {
            return null;
        }

        E value = array[head];
        head = (head + 1) % array.length;
        size--;
        return value;

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
        return array[head];
    }
}
