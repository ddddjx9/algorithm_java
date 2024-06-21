package myQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * 入队的时候tail+1，出队的时候tail-1
 * <p>
 * 让head和tail就是不断递增的指针值，不代表具体的索引，这是和第一版最主要的区别
 * <p>
 * 用到索引值的时候，让head和tail不要存储计算后的索引值，随用随计算即可
 *
 * @param <E> 队列中元素的类型
 */
public class CycleArrayQueue3<E> implements Queue<E>, Iterable<E> {
    //我们此时并不是动态创建队列，创建之后，不可能重新new一个，加上final进行修饰
    private final E[] array;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("all")
    public CycleArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
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
        return tail - head == array.length;
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
                E value = array[p % array.length];
                p++;
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
        //通过tail计算索引
        array[tail % array.length] = e;
        tail++;
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

        E value = array[head % array.length];
        //因为head表示移除头部的元素，所以我们需要跳过头部的元素，head++
        head++;
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
        return array[head % array.length];
    }
}
