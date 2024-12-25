package leetcode.array;

public class LeetCode41 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 9};
        System.out.println(new LeetCode41().firstMissingPositive(nums));
    }

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数
     * <p>
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案
     * </p>
     *
     * @param nums 给定的整数数组
     * @return 返回其中没有出现的最小的正整数
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换元素，将值放到对应的索引位置
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
