package cn.edu.ustb.testLeetCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestLeetCode238 {

    @Test
    public void testLeetCode238() {
        int[] nums = {1, 2, 3, 4};
        int[] result = new TestLeetCode238().productExceptSelf(nums);
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(result,expected);
    }

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
     * <p>
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内
     * </p>
     * <p>
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * </p>
     *
     * @param nums 给定的整数数组
     * @return 返回除了自己位置的乘积
     */
    public int[] productExceptSelf(int[] nums) {
        int lp = 1;
        int rp = 1;
        int[] resultArr = new int[nums.length];
        Arrays.fill(resultArr, 1);
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length && right >= 0) {
            resultArr[left] *= lp;
            resultArr[right] *= rp;
            lp *= nums[left++];
            rp *= nums[right--];
        }

        return resultArr;
    }
}
