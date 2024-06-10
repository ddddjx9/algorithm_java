package sort;

public class HeapSort {
    /**
     * 堆排序
     * 堆排序的最好，最坏，平均时间都是O(nlog(n))，空间复杂度O(1)，不稳定
     * 建立大顶堆
     * 每次将元素最大值交换到末尾，调整栈顶元素，让它重新符合大顶堆的特性
     *
     * @param arr 待排序的数组
     */
    public static void heapSort(int[] arr) {
        buildHeap(arr, arr.length);
        for (int right = arr.length - 1; right > 0; right--) {
            swap(arr, 0, right);
            //交换完后将数组重新调整成大顶堆
            down(arr, 0, right);
        }
    }

    /**
     * 建立大顶堆
     *
     * @param arr  待排序数组
     * @param size 从非叶子节点倒着调用下潜方法
     */
    private static void buildHeap(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(arr, i, size);
        }
    }

    private static void down(int[] arr, int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && arr[left] > arr[max]) {
            max = left;
        }
        if (right < size && arr[right] > arr[max]) {
            max = right;
        }
        if (max != parent) {
            swap(arr, parent, max);
            down(arr, max, size);
        }
    }

    private static void swap(int[] arr, int parent, int max) {
        int temp = arr[max];
        arr[max] = arr[parent];
        arr[parent] = temp;
    }
}
