package sort;

import java.util.Arrays;

public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 1, 6, 2, 7, 9, 3, 4, 5, 1, 10, 8};

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();

        System.out.println(end - start); //测试快排的效率
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序：
     * <p>
     * &nbsp;&nbsp;第一轮：以0索引的数字为基准数，确定基准数在数组中正确的位置
     * </p>
     * <p>
     * &nbsp;&nbsp;比基准数小的全部在左边，比基准数大的全部在右边
     * </p>
     * <p>
     * &nbsp;&nbsp;后面以此类推
     * </p>
     *
     * @param arr 我们要排序的数组
     * @param low   要排序数组的起始索引
     * @param high   要排序数组的结束索引
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (true) {
            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            while (left <= right && arr[right] >= pivot) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
            } else {
                break;
            }
        }

        swap(arr, low, right);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}