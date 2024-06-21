package heapify;

/**
 * 大顶堆
 */
public class MaxHeap {
    int[] arr;
    int size;

    public MaxHeap(int capacity) {
        this.arr = new int[capacity];
    }

    public MaxHeap(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
        heapify();
    }

    public int[] getArr() {
        return arr;
    }

    /**
     * 该方法用于建堆
     */
    private void heapify() {
        //找到最后一个非叶子节点
        //从后向前，对每一个节点执行下潜

        //计算最后一个非叶子节点：
        //size / 2 - 1，这就是最后一个非叶子节点的索引值（从0开始建立大顶堆）
        for (int i = (size / 2 - 1); i >= 0; i--) {
            down(i);
        }
    }

    /**
     * 删除堆顶元素
     *
     * @return 堆顶元素
     */
    public int poll() {
        if (size == 0) {
            throw new NullPointerException("堆中没有元素！");
        }
        //将堆顶元素和堆底元素进行交换
        int max = arr[size];
        swap(0, size - 1);
        size--;
        //将刚刚被交换上来的数进行下潜
        down(0);
        return max;
    }

    /**
     * 删除指定元素
     *
     * @param index 给定的要删除的元素索引
     * @return 返回被删除的元素
     */
    public int poll(int index) {
        if (size == 0) {
            throw new NullPointerException("堆中没有元素！");
        }
        //将被删除元素与堆底元素进行交换
        //让size--，相当于元素被删除
        //将被交换的元素进行下潜
        //将堆顶元素和堆底元素进行交换
        int removed = arr[index];
        swap(index, size - 1);
        size--;
        //将刚刚被交换上来的数进行下潜
        down(index);
        return removed;
    }

    /**
     * 获取堆顶元素
     *
     * @return 返回堆顶元素
     */
    public int peek() {
        if (size == 0) {
            throw new NullPointerException("堆中没有元素！");
        }
        return arr[0];
    }

    /**
     * 获取堆顶元素
     *
     * @return 返回堆顶元素
     */
    public boolean offer(int offered) {
        if (size == arr.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    /**
     * 替换堆顶元素
     *
     * @param replaced 要替换的新元素
     */
    public void replace(int replaced) {
        if (size == 0) {
            throw new NullPointerException("堆中没有元素！");
        }
        arr[0] = replaced;
        down(0);
    }

    /**
     * 将要插入的元素进行上浮，直到该元素小于父元素或者到达堆顶为止
     *
     * @param offered 待插入的元素
     */
    private void up(int offered) {
        int child = size;
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (offered > arr[parent]) {
                arr[child] = arr[parent];
            } else {
                break;
            }
            child = parent;
        }
        arr[child] = offered;
    }

    /**
     * 将父元素索引处的元素下沉，与两个孩子中较大的值进行交换，直到没有孩子或者孩子没它大为止
     *
     * @param parent 即将下潜的父元素
     */
    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }

        if (max != parent) {
            //说明找到了一个值，发现这个值比parent更大
            swap(max, parent);
            down(max);
        }
    }

    /**
     * 交换两个索引处的元素位置
     *
     * @param i 待交换的元素1
     * @param j 待交换的元素2
     */
    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
