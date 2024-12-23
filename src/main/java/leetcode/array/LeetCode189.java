package leetcode.array;

public class LeetCode189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        new LeetCode189().rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * @param nums 给定的整数数组
     * @param k    向右轮转的偏移量
     *             输入: nums = [1,2,3,4,5,6,7], k = 3
     *             输出: [5,6,7,1,2,3,4]
     *             向右轮转 1 步: [7,1,2,3,4,5,6]
     *             向右轮转 2 步: [6,7,1,2,3,4,5]
     *             向右轮转 3 步: [5,6,7,1,2,3,4]
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        k = k % n; // 处理 k 大于数组长度的情况
        if (k == 0) {
            return; // 如果 k 是 0，直接返回
        }

        // 创建一个足够大的临时数组
        int[] temp = new int[n];

        // 1. 把 nums 中的元素拷贝到 temp 中
        System.arraycopy(nums, 0, temp, 0, n);

        // 2. 右轮转 k 位
        // 将最后 k 个元素移动到 nums 的前面
        System.arraycopy(temp, n - k, nums, 0, k);

        // 将剩余的元素移动到 nums 的后面
        System.arraycopy(temp, 0, nums, k, n - k);
    }
}
