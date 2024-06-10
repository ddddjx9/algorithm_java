package recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //递归实现冒泡排序
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {3, 9, 4, 6, 8, 5, 1};
        bubbleSort1(arr1, 0);
        for (int i : arr1) {
            System.out.println(i);
        }
        bubbleSort2(arr2, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }

    public static void bubbleSort1(int[] arr, int index) {
        //1 8 4 2 9
        //给开始索引和节数索引
        //1 4 8 2 9
        //1 4 2 8 9
        //1 2 4 8 9
        //当结束的索引等于数组长度时，说明所有的数字全部被排好序
        //书写递归的结束条件
        if (index == arr.length - 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1 - index; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSort1(arr, index + 1);
    }

    /**
     * 递归函数在索引范围内冒泡最大元素的最右侧 - 优化版
     *
     * @param arr 待排序的数组
     * @param j   未排序区域的右边界
     */
    public static void bubbleSort2(int[] arr, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                x = i;
            }
        }
        bubbleSort2(arr, x);
    }
}
