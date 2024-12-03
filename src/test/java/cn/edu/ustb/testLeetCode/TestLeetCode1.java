package cn.edu.ustb.testLeetCode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestLeetCode1 {
    @Test
    public void testLeetCode1() {
        int[] nums = new int[]{1, 9, 3, 4, 5};
        int target = 7;
        int[] targetArr = new int[]{2, 3};
        assertArrayEquals(new TestLeetCode1().twoSum(nums, target), targetArr);
    }

    /**
     * 使用HashMap减少循环次数
     *
     * @param nums   传递过来的数组
     * @param target 给定的目标值
     * @return 返回目标值所在的两个索引数组
     */
    public int[] twoSum(int[] nums, int target) {
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
