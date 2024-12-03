package leetcode.hash;

import java.util.Arrays;

public class LeetCode128 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1};
        System.out.println(new LeetCode128().longestConsecutive(nums));
    }

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * @param nums 给定的数组
     * @return 返回最长序列的长度
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int max = 1;
        // 如果两个数字之间的差不是1，那么重新开始计数
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i + 1] - nums[i] != 1) {
                max = Math.max(max, count);
                count = 1;
                continue;
            }
            count++;
        }

        return Math.max(max, count);
    }
}
