package myArray;

import java.util.Arrays;

public class MergeOrderedArray {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 6, 2, 4, 10, 11};
        int[] a2 = new int[a1.length];
        new MergeOrderedArray().merge2(a1, 0, 2, 3, 6, a2);
        System.out.println(Arrays.toString(a2));
        //如果想要将a1的数据更新为合并后的结果，只需要将a2中的元素拷贝给a1就可以了
    }

    /**
     * LeetCode88：使用递归思路进行实现：将两个有序区间的的有序元素合并，合并后，结果仍然存储在原有空间
     *
     * @param nums1 合并的之前原始数组
     * @param i     第一个有序区间的起点
     * @param iEnd  第一个有序区间的终点
     * @param j     第二个有序区间的起点
     * @param jEnd  第二个有序区间的终点
     * @param nums2 合并之后的结果数组
     * @param k     num2[]数组使用的索引
     */
    public void merge1(int[] nums1, int i, int iEnd, int j, int jEnd, int[] nums2, int k) {
        /*
        将两个有序区间中的元素进行比较，谁更小，就将谁放到结果数组中
        每次将更小的元素放在结果数组中即可
         */
        if (i > iEnd) {
            System.arraycopy(nums1, j, nums2, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(nums1, i, nums2, k, iEnd - i + 1);
            return;
        }
        if (nums1[i] < nums1[j]) {
            nums2[k] = nums1[i];
            merge1(nums1, i + 1, iEnd, j, jEnd, nums2, k + 1);
        } else {
            nums2[k] = nums1[j];
            merge1(nums1, i, iEnd, j + 1, jEnd, nums2, k + 1);
        }
    }

    public void merge2(int[] nums1, int i, int iEnd, int j, int jEnd, int[] nums2) {
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