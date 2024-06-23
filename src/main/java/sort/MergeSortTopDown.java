package sort;

import java.util.Arrays;

public class MergeSortTopDown {
    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 2, 5, 8, 1, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * <P>
     * 归并排序：使用递归，自上而下进行排序
     * </P>
     * <p>
     * 将数据切分，每次一分为二，组间进行排序，直到剩最后一个数据；回溯，区间由小到大，进行区间内的排序，多路递归
     * </p>
     *
     * @param arr 待排序的数组
     */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        split(arr, 0, arr.length - 1, temp);
    }

    private static void split(int[] arr, int left, int right, int[] temp) {
        //治
        if (left == right) {
            //表明此范围内只有一个数据
            return;
        }

        //分
        int mid = (left + right) >> 1;
        split(arr, left, mid, temp);
        split(arr, mid + 1, right, temp);

        //合
        merge(arr, left, mid, mid + 1, right, temp);
        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

    /**
     * 使用非递归思路进行实现：将两个有序区间的的有序元素合并，合并后，结果仍然存储在原有空间
     *
     * @param nums1 合并的之前原始数组
     * @param i     第一个有序区间的起点
     * @param iEnd  第一个有序区间的终点
     * @param j     第二个有序区间的起点
     * @param jEnd  第二个有序区间的终点
     * @param nums2 合并之后的结果数组
     */
    private static void merge(int[] nums1, int i, int iEnd, int j, int jEnd, int[] nums2) {
        //使用非递归思路实现，循环判断：
        //将索引k改成方法内的局部变量
        int k = i;
        while (i <= iEnd && j <= jEnd) {
            if (nums1[i] < nums1[j]) {
                nums2[k] = nums1[i];
                i++;
            } else {
                nums2[k] = nums1[j];
                j++;
            }
            k++;
        }
        if (i > iEnd) {
            System.arraycopy(nums1, j, nums2, k, jEnd - j + 1);
        }
        if (j > jEnd) {
            System.arraycopy(nums1, i, nums2, k, iEnd - i + 1);
        }
    }
}
