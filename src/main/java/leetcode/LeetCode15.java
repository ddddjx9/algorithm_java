package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
 * <p>
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0
 * </p>
 * <p>
 * 请你返回所有和为 0 且不重复的三元组。
 * </p>
 */
public class LeetCode15 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new LeetCode15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    /**
     * 暴力枚举解决 -- 无法处理拥有相同元素的组合问题
     *
     * @param nums 目标数组
     * @return 返回满足条件的集合列表
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int last = nums.length - 1;
                while (j < last && nums[i] + nums[j] > -nums[last]) {
                    last--;
                }

                if (j == last) {
                    break;
                }

                if (nums[i] + nums[j] == -(nums[last])) {
                    ArrayList<Integer> list = new ArrayList<>();
                    Collections.addAll(list, nums[i], nums[j], nums[last]);
                    res.add(list);
                }
            }
        }

        return res;
    }
}
