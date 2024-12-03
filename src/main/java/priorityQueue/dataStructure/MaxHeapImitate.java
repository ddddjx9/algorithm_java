package priorityQueue.dataStructure;

import myQueue.impl.Queue;
import priorityQueue.impl.Priority;

import java.util.Iterator;

/**
 * 使用堆模拟优先级队列最佳实现
 * <p>
 * 只能先填满左边，然后再填右边
 * </p>
 * <p>
 * 大顶堆，父节点的值总是比子节点要小；
 * </p>
 * <p>
 * 小顶堆，父节点的值总是比子节点小
 * </p>
 * <p>
 * 虽然是非线性的数据结构，但是本质可以用线性的数据结构-数组来进行存储
 * </p>
 */
public class MaxHeapImitate<E extends Priority> implements Queue<E> {
    public Priority[] array;
    public int size;

    public MaxHeapImitate(int capacity) {
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

    /**
     * <p>
     * 入队新的元素，加入到数组的末尾（索引c）
     * </p>
     * <p>
     * 加入后可能会破坏大顶堆的特性，所以需要调整，将父节点下潜，不断比较新加入的元素和父节点（parent）的优先级
     * </p>
     * <p>
     * 如果父节点优先级低，向下移动，并找到下一个parent进行比较，直到父节点优先级更高或者达到根节点位置
     * </p>
     *
     * @param e 要插入的新的元素
     * @return 返回是否插入成功
     */
    @Override
    public boolean offer(E e) {
        //只需要加入到数组的末尾即可
        //从左向右依次填满
        //上浮过程
        if (isFull()) {
            return false;
        }
        int child = size++;
        //先比较，再填充
        int parent = (child - 1) / 2;
        while (child > 0 && e.priority() > array[parent].priority()) {
            array[child] = array[parent];
            //继续向上寻找
            child = parent;
            parent = (parent - 1) / 2;
        }
        array[child] = e;
        return true;
    }

    @Override
    //移除数组中优先级最高的对象
    public E poll() {
        //首先将堆顶处的元素和数组最末尾处的元素进行交换，size-1即可将其移除
        //调整完毕后，根节点处的优先级和两个孩子里面较大的元素进行交换
        //重复这个过程，将其下潜到合适的位置
        //直到两个孩子都没根节点处的优先级大或者是该节点处已经没有孩子为止，结束下潜
        if (isEmpty()) {
            return null;
        }

        //交换并出队
        swap(0, size - 1);
        size--;
        Priority max = array[size];
        array[size] = null;

        //下潜
        dive(0);

        return (E) max;
    }

    private void swap(int i, int j) {
        Priority temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void dive(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        //假设parent索引处的优先级最高
        int maxIndex = parent;
        if (left < size && array[left].priority() > array[maxIndex].priority()) {
            maxIndex = left;
        }
        if (right < size && array[right].priority() > array[maxIndex].priority()) {
            maxIndex = right;
        }

        //说明做了交换，有孩子比父亲大
        if (maxIndex != parent) {
            swap(maxIndex, parent);
            //重复该过程，递归调用
            dive(maxIndex);
        }
    }

    @Override
    //取数组中优先级最高的对象
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }
}
