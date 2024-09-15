package cn.edu.ustb.algorithm;

/**
 * LeetCode16：力扣题解16
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * </p>
 */
public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        int target = 1;
        System.out.println(new LeetCode16().threeSumClosest(nums, target));
    }

    /**
     * 尝试暴力枚举解决和与目标值的最接近的问题
     *
     * @param nums   传入的目标数组
     * @param target 传入的目标数字
     * @return 返回目标的三个数字之和
     */
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(temp - target) < Math.abs(result - target)) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }
}
