package search;

import java.util.Arrays;

public class BinarySearchInsert {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 查找数组应该插入的位置，并创建新的数组
     * 将目标值插入进去
     */
    public static void test1() {
        int[] a = {2, 5, 8};
        int target = 4;
        int i = Arrays.binarySearch(a, target);

        //-2=-插入点-1
        //-2+1=-插入点
        if (i < 0) {
            int insertIndex = Math.abs(i + 1);
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = target;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }

    }

    /**
     * 普通的二分查找，没有经过任何性能优化
     *
     * @param nums   待查找的数组
     * @param target 目标值
     * @return 目标值索引，没有就返回-1
     */
    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >>> 1;
            if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
