package recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //递归实现冒泡排序
        int[] arr1 = {5, 4, 3, 2, 1};
        int[] arr2 = {3, 9, 4, 6, 8, 5, 1};
        bubbleSort(arr1, 0);
        bubbleSort(arr2, 0);
        System.out.println(Arrays.toString(arr2));
    }

    public static void bubbleSort(int[] arr, int index) {
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
        bubbleSort(arr, index + 1);
    }
}
