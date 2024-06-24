package sort;

import static sort.InsertSortDemo.printArr;

public class SelectionSort {
    public static void main(String[] args) {
        //1.定义数组
        int[] arr1 = {2, 4, 5, 3, 1};
        int[] arr2 = {8, 7, 4, 9, 6, 1, 3, 5, 1, 0};
        selectionSort1(arr1);
        printArr(arr1);

        selectionSort2(arr2);
        printArr(arr2);
    }

    /**
     * 选择排序：
     * <p>
     * &nbsp;&nbsp;1.从0索引开始，跟后面的元素一一比较。
     * </p>
     * <p>
     * &nbsp;&nbsp;2.小的放前面，大的放后面。
     * </p>
     * <p>
     * &nbsp;&nbsp;3.第一次循环结束后，最小的数据已经确定。
     * </p>
     * <p>
     * &nbsp;&nbsp;4.第二次循环从1索引开始以此类推。
     * </p>
     *
     * @param arr 待排序数组
     */
    protected static void selectionSort1(int[] arr) {
        //外循环：几轮
        //i:表示这一轮中，用哪个索引上的数据跟后面的数据进行比较并交换
        for (int i = 0; i < arr.length - 1; i++) {
            //内循环：拿着i跟i后面的数据进行比较交换
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    public static void selectionSort2(int[] a) {
        /*
        选择的轮数：arr.length-1
        交换的索引位置，初始值a.length-1，每次递减
        */
        for (int right = a.length - 1; right > 0; right--) {
            int max = right;
            for (int i = 0; i < right; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }

            //如果找到了比最后一个元素更大的值才交换，否则不交换
            if (max != right) {
                swap(a, max, right);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
