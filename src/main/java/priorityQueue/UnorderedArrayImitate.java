package priorityQueue;

import myQueue.Queue;

import java.util.Iterator;

/**
 * 普通队列：先进先出
 * 优先级队列：按照队列中元素的优先级出队
 */
public class UnorderedArrayImitate<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public UnorderedArrayImitate(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public int size() {
        return 0;
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
        array[size++] = e;
        return true;
    }

    @Override
    //取数组中优先级最高的对象
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int maxIndex = selectMax();
        E e = (E) array[maxIndex];
        remove(maxIndex);
        return e;
    }

    private void remove(int index) {
        //如果是最后一个元素
        //index < size-1，说明不是最后一个元素，需要将最后一个元素向前移动
        //如果等于，不需要移动，size--
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        //如果是引用数组类型，可能数组还引用着这个对象，我们需要将他们之间的联系断开
        array[--size] = null;
    }

    @Override
    //取数组中优先级最高的对象
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int maxIndex = selectMax();
        return (E) array[maxIndex];
    }

    /**
     * @return 优先级最高的索引值
     */
    private int selectMax() {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
    }
}
