package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {9, 3, 6, 7, 4, 2, 1, 5, 8};
        insertionSort1(a);
        System.out.println(Arrays.toString(a));
        int[] b = {8, 6, 1, 4, 7, 3, 2, 9, 0};
        insertionSort2(b);
        System.out.println(Arrays.toString(b));
    }

    public static void insertionSort1(int[] a) {
        insertion1(a, 1);
    }

    public static void insertionSort2(int[] a) {
        insertion2(a, 1);
    }

    /**
     * 插入排序
     *
     * @param a   待排序的数组
     * @param low 未排序区域的下边界
     */
    private static void insertion1(int[] a, int low) {
        if (low == a.length) {
            //此时表明数组内所有元素均已排序，所以结束递归
            return;
        }
        int t = a[low]; //边界指针指向的元素，待排序的元素
        int i = low - 1; //已排序区域的指针
        //还有一种可能是，待排序的元素比当前所有已经排好序的元素小，
        //那么就加一个边界条件，当i<0时退出循环
        while (i >= 0 && a[i] > t) {
            //如果没有找到插入位置，就不断循环
            a[i + 1] = a[i]; //空出插入位置
            i--;
        }

        //考虑到一种情况，这个待排序的元素本身在数组中就有序
        //所以它的插入位置就是元素原来的位置，也就是low
        if (i + 1 != low) {
            a[i + 1] = t;
        }

        insertion1(a, low + 1);
    }

    private static void insertion2(int[] a, int low) {
        if (low == a.length) {
            //此时表明数组内所有元素均已排序，所以结束递归
            return;
        }
        int i = low - 1;
        while (i >= 0 && a[i] > a[i + 1]) {
            int temp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = temp;
            i--;
        }
        insertion2(a, low + 1);
    }
}
