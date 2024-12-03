package leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target
 * <p>
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * </p>
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(new LeetCode1().twoSum(nums, target)));
        System.out.println(Arrays.toString(new LeetCode1().twoSumUseHashMap(nums, target)));
    }

    /**
     * 暴力枚举法实现
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 返回数组中 两数之和 为目标值的数组下标
     * <p>
     * nums = [2,7,11,15]
     * </p>
     * <p>
     * target = 9
     * </p>
     * <p>
     * 输出：[0,1]
     * </p>
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 使用HashMap减少一重循环
     *
     * @param nums   目标数组
     * @param target 目标值
     * @return 返回两数之和为目标值的数组所在的索引
     */
    public int[] twoSumUseHashMap(int[] nums, int target) {
        // 记录数组中某些元素的值和其下角标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
