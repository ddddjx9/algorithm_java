package leetcode.array;

import java.util.Arrays;

public class LeetCode238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new LeetCode238().productExceptSelf(nums)));
    }

    /**
     * 给你一个整数数组 nums，返回 数组 answer，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     * <p>
     * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位整数范围内。
     * </p>
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * @param nums 给定的数组
     * @return 返回一个数组，其中answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);
        int left = 0, right = nums.length - 1;
        int lp = 1, rp = 1;
        while (right >= 0 && left < nums.length) {
            answer[right] *= rp;
            answer[left] *= lp;
            lp *= nums[left++];
            rp *= nums[right--];
        }
        return answer;
    }
}
