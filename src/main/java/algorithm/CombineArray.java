package algorithm;

public class CombineArray {
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int n = 3;
        int[] nums2 = {1, 2, 3};
        CombineArray combineArray = new CombineArray();
        combineArray.merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1.思路：采用插值法排序，
        //先遍历nums1数组，找到小于等于nums2数组索引1的元素，记录此处的索引，
        //然后将nums1数组这个索引处的索引后移一位，
        //依次插入nums2的元素

        //依次插入nums2数组的元素
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int record = m - 1;
        for (int i = 0; i < n; i++) {
            //遍历nums1数组
            for (int j = record; j >= 0; j--) {
                if (j == 0 && nums2[i] < nums1[0]) {
                    System.arraycopy(nums1, 0, nums1, 1, record + 1);
                    nums1[0] = nums2[i];
                    record++;
                    break;
                }
                if (nums1[j] <= nums2[i]) {
                    //该索引处的元素依次后移
                    System.arraycopy(nums1, j + 1, nums1, j + 2, record + 1 - j - 1);
                    nums1[j + 1] = nums2[i];
                    record++;
                    break;
                }
            }
        }
    }
}
