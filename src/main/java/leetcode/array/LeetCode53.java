package leetcode.array;

import java.util.Arrays;

public class LeetCode53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new LeetCode53().maxSubArray(nums));
        System.out.println(new LeetCode53().maxSubArray2(nums));
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
        // 难点是如何在数组分布未知的情况下，判断累加的分界点在哪里，现在的解决方案是暴力累加
        // 典型的动态规划问题，主要的点是如何确定状态转移方程
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        Arrays.sort(dp);
        return dp[nums.length - 1];
    }

    public int maxSubArray2(int[] nums) {
        // 处理空数组情况
        if (nums.length == 0) return 0;

        // 当前最大子数组和
        int maxSoFar = nums[0];
        // 当前子数组和
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        // 返回最大子数组和
        return maxSoFar;
    }
}
