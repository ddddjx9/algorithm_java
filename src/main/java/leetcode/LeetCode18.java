package leetcode;

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
        //System.out.println(new LeetCode18().fourSum(new int[]{0, 0, 0, 0}, 0));
        System.out.println(new LeetCode18().fourSumPrune(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    /**
     * 最简单的方法就是四层循环，但是应该会超时，采用简化一重循环的手段看看效果
     * <p>
     * &nbsp&nbsp！！最重要的手段应该是查看题目规律然后进行剪枝
     * </p>
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

    /**
     * 采用剪枝手段，并采用双指针进一步简化循环，减少时间的耗费
     *
     * @param nums   传入的数组
     * @param target 目标值
     * @return 返回能够加和为目标值的四元组
     */
    public List<List<Integer>> fourSumPrune(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        //TODO 这次采用双指针法进一步简化一重循环，将第三个数和第四个数同时采用双指针法寻找，减少循环的时间耗费
        for (int i = 0; i < nums.length - 3; i++) {
            //TODO 避免枚举到与之前相同的数字，如果遇到与之前相同的数字就跳过，保证每一个位置上的数字都与之前自己的取值不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //TODO 进一步剪枝，将不能符合要求的组合尽量在循环之前就筛选出去
            //      枚举四个数字中和 过大 或者 过小 的情况
            //      如果枚举最小的四个数字的和不能满足要求，那么就结束循环
            //      根据题目要求，单个数字不可能会超过int的范围，但是它们的加和可能会产生溢出，导致进行位移运算
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > (long) target) {
                break;
            }

            if ((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < (long) target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                //TODO 剪枝
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > (long) target) {
                    break;
                }

                if ((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < (long) target) {
                    continue;
                }

                //TODO 使用双指针法找到剩下的可能符合要求的两个数字
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    final int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);

                        //TODO 如果找到了可行解，那么接着试探下一个和当前数字不相同的数字，看看有没有可能符合要求
                        //      先处理一下特殊情况，如果有连续多个相同的数字，那么就跳过，寻找下一个符合要求的元组
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        //TODO 没有特殊情况的时候，就让头指针前移，尾指针后移
                        left++;

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
