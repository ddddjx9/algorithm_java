package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 2, 5, 8, 1, 4};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * <p>
     * 希尔排序：简单来说，就是分组实现插入，每组元素索引间隙称为gap
     * </p>
     * 每轮排序后gap逐渐变小，每一组中的元素越来越多，直到gap等于1时，说明二者相邻，排序完成后，结束排序
     * <p>
     * 对插入排序的优化，让元素更快速地交换到最终位置
     * </p>
     *
     * @param arr 待排序的数组
     */
    public static void shellSort(int[] arr) {
        //arr.length  每次除以2  直到间隙为1为止
        for (int gap = arr.length >> 1; gap >= 1; gap >>= 1) {
            for (int low = gap; low < arr.length; low++) {
                int t = arr[low];
                int i = low - gap;
                //自右向左寻找插入位置，如果比插入元素大，则不断右移，空出插入位置
                while (i >= 0 && t < arr[i]) {
                    arr[i + gap] = arr[i];
                    i -= gap;
                }
                //找到插入位置
                if (i != low - gap) {
                    arr[i + gap] = t;
                }
            }
        }
    }
}
