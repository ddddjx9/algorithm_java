package leetcode.substrings;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(new LeetCode560().subarraySum(nums, k));
    }

    /**
     * <p>
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * </p>
     * <p>
     * 子数组是数组中元素的连续非空序列。
     * </p>
     *
     * @param nums 给定的子数组
     * @param k    给定的整数k
     * @return 返回数组中和为k的子数组的个数
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        // 初始化前缀和为0出现1次，这对应了从头开始累加就满足条件的情况
        preSumMap.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            // 计算当前前缀和与目标值k的差值，查看这个差值在前缀和的统计中出现的次数
            int target = sum - k;
            if (preSumMap.containsKey(target)) {
                result += preSumMap.get(target);
            }
            // 更新当前前缀和出现的次数
            preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
