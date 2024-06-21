package priorityQueue;

import myLinkedList.ListNode;

public class MinHeap {
    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }

    public boolean offer(ListNode newNode) {
        //只需要加入到数组的末尾即可
        //从左向右依次填满
        //上浮过程
        if (isFull()) {
            return false;
        }
        int child = size++;
        //先比较，再填充
        int parent = (child - 1) / 2;
        while (child > 0 && newNode.val < array[parent].val) {
            array[child] = array[parent];
            //继续向上寻找
            child = parent;
            parent = (parent - 1) / 2;
        }
        array[child] = newNode;
        return true;
    }

    public ListNode poll() {
        //首先将堆顶处的元素和数组最末尾处的元素进行交换，size-1即可将其移除
        //调整完毕后，根节点处的优先级和两个孩子里面较小的元素进行交换
        //重复这个过程，将其下潜到合适的位置
        //直到两个孩子都没根节点处的优先级大或者是该节点处已经没有孩子为止，结束下潜
        if (isEmpty()) {
            return null;
        }

        //交换并出队
        swap(0, size - 1);
        size--;
        ListNode min = array[size];
        array[size] = null;

        //下潜
        dive(0);

        return min;
    }

    private void swap(int i, int j) {
        ListNode temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void dive(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        //假设parent索引处的元素最小
        int minIndex = parent;
        if (left < size && array[left].val < array[minIndex].val) {
            minIndex = left;
        }
        if (right < size && array[right].val < array[minIndex].val) {
            minIndex = right;
        }

        //说明做了交换，有孩子比父亲小
        if (minIndex != parent) {
            swap(minIndex, parent);
            //重复该过程，递归调用
            dive(minIndex);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
