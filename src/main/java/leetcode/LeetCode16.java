package leetcode;

import java.util.Arrays;

/**
 * LeetCode16：力扣题解16
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * </p>
 */
public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int target = 1;
        System.out.println(new LeetCode16().threeSumClosest(nums, target));
        System.out.println(new LeetCode16().threeSumClosestSimplify(nums, target));
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

    /**
     * 针对第一个方法中的三重循环进行简化，采用更加有效的方式去提取数组中符合要求的三个数字
     *
     * @param nums   传入的数组
     * @param target 目标的数字
     * @return 返回的三个目标数字之和
     */
    public int threeSumClosestSimplify(int[] nums, int target) {
        //TODO 对数组进行排序，简化之前的三重循环的逻辑
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        //TODO 先定下一个基准数字，然后对基准数之后的数字进行扫描
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //TODO 采用双指针法对数组前后进行扫描
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }

                //TODO 如果遇到距离更小的和，进行替换
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                //TODO 说明数字小了，应该将最小的指针向右移动，尝试寻找距离更小的数字
                if (sum < target) {
                    //TODO 定义临时变量，尝试寻找不同于当前最小指针j指向的元素并大于它的元素
                    int temp = j + 1;
                    while (temp < k && nums[temp] == nums[j]) {
                        temp++;
                    }

                    j = temp;
                } else {
                    int temp = k - 1;
                    while (temp > j && nums[temp] == nums[k]) {
                        temp--;
                    }

                    k = temp;
                }
            }
        }

        return result;
    }
}
