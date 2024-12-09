package leetcode.array;

import java.util.Arrays;

public class LeetCode53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new LeetCode53().maxSubArray(nums));
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组是数组中的一个连续部分。
     * </p>
     *
     * @param nums 给定的整数数组
     * @return 返回一个具有最大和的连续子数组
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num > 0) {
                sum += num;
            }
        }
        return sum;
    }
}
