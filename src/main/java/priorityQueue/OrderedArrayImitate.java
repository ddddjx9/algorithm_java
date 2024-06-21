package priorityQueue;

import myQueue.Queue;

import java.util.Iterator;

public class OrderedArrayImitate<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public OrderedArrayImitate(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        insertElement(e);
        size++;
        return true;
    }

    private void insertElement(E e) {
        //前提是队列未满
        int i = size - 1;
        while (i >= 0 && array[i].priority() > e.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = e;
    }

    @Override
    //取数组中优先级最高的对象
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        E e = (E) array[size - 1];
        //如果是引用数组类型，可能数组还引用着这个对象，我们需要将他们之间的联系断开
        array[--size] = null;
        return e;
    }

    @Override
    //取数组中优先级最高的对象
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return (E) array[size - 1];
    }
}
