package sort;

import java.util.Arrays;

public class MergeSortBottomUp {
    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 2, 5, 8, 1, 4};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int length = arr.length;
        int[] temp = new int[arr.length];
        //利用数学规律对递归规律进行总结，转换成循环处理
        for (int width = 1; width < length; width <<= 1) {
            for (int left = 0; left < length; left += 2 * width) {
                //确保索引范围
                int right = Math.min(left + 2 * width - 1, length - 1);
                int mid = Math.min(left + width - 1, length - 1);
                merge(arr, left, mid, mid + 1, right, temp);
            }
            System.arraycopy(temp, 0, arr, 0, length);
        }
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
