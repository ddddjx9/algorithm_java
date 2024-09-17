package cn.edu.ustb.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * <p>
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * </p>
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 */
public class LeetCode18 {
    public static void main(String[] args) {
        System.out.println(new LeetCode18().fourSum(new int[]{0, 0, 0, 0}, 0));
    }

    /**
     * 最简单的方法就是四层循环，但是应该会超时，采用简化一重循环的手段看看效果
     *
     * @param nums   传入的数组
     * @param target 要达到的目标值
     * @return 返回目标值的二维集合
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int last = k + 1;
                    while (last < nums.length && target - (nums[i] + nums[j] + nums[k]) > nums[last]) {
                        last++;
                    }

                    if (nums.length == last) {
                        continue;
                    }

                    final BigInteger add = new BigInteger(String.valueOf(nums[i])).add(new BigInteger(String.valueOf(nums[j]))).add(new BigInteger(String.valueOf(nums[k]))).add(new BigInteger(String.valueOf(nums[last])));
                    if (add.equals(new BigInteger(String.valueOf(target)))) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[last]);
                        res.add(list);
                    }
                }
            }
        }

        return res;
    }
}
