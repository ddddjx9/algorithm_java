package leetcode.substrings;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode239 {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(Arrays.toString(new LeetCode239().maxSlidingWindow(nums, k)));
    }

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * <p>
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * </p>
     *
     * @param nums 给定的整数数组
     * @param k    规定的滑动窗口的大小
     * @return 返回 滑动窗口中的最大值
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 处理数组长度小于滑动窗口长度的情况
        if (nums.length <= k) {
            int max = 0;
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return new int[]{max};
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int startOffset = i;
            int max = nums[startOffset];
            while (startOffset < i + k && startOffset < nums.length) {
                if (nums[startOffset] > max) {
                    max = nums[startOffset];
                }

                startOffset++;
            }

            list.add(max);
        }

        // 创建一个int数组，用于存储结果
        int[] res = new int[list.size()];
        // 填充int数组
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
