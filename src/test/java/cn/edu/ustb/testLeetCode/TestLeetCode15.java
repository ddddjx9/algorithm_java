package cn.edu.ustb.testLeetCode;

import cn.edu.ustb.assertUtils.JudgeNestedArray;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLeetCode15 {
    @Test
    public void testLeetCode15() {
        int[] nums = {-1, 0, 1};
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        resultList.add(Arrays.asList(-1, 0, 1));

        assertTrue(JudgeNestedArray.compareListOfListsWithStream(resultList, threeSum(nums)));
    }

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
     * <p>
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 请你返回所有和为 0 且不重复的三元组。
     * </p>
     *
     * @param nums 给定的数组
     * @return 返回所有和为0的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 先对数组进行排序，方便后续进行处理
        Arrays.sort(nums);
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int last = nums.length - 1;
                while (j < last && nums[i] + nums[j] > -nums[last]) {
                    last--;
                }

                if (j == last) {
                    break;
                }

                if (nums[i] + nums[j] + nums[last] == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[j], nums[last]));
                }
            }
        }

        return resultList;
    }
}
