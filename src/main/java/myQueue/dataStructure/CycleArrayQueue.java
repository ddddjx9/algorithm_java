package myQueue.dataStructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


/**
 * 环形数组实现队列
 * <p>
 * 环形数组意味着不存在越界问题
 * </p>
 * <p>
 * 数组性能更优
 * </p>
 * <p>
 * 环形数组比较适合实现有界队列，RingBuffer等
 * </p>
 * <p>
 * 所有其他元素不用动，让指针指向下一个元素即可
 * </p>
 * <p>
 * 仅仅用head和tail判断空和满，head和tail即为索引值
 * </p>
 *
 * @param <E> 队列中元素的类型
 */
public class CycleArrayQueue<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public CycleArrayQueue(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
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
