package leetcode.substrings;

import java.util.*;
import java.util.stream.IntStream;

public class LeetCode239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        // System.out.println(Arrays.toString(new LeetCode239().maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(new LeetCode239().maxSlidingWindow2(nums, k)));
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
        // 处理数组长度小于窗口长度的情况
        if (nums.length <= k) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }

        // 存储结果数据，为了不动脑子，直接用集合暴力拷贝
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= nums.length - k; i++) {
            int max = IntStream.range(i, Math.min(i + k, nums.length))
                    .map(j -> nums[j])
                    .max().getAsInt();
            list.add(max);
        }

        // 采用流式写法简化代码，同时在一定程度上提高效率
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 采用双端队列优化逻辑
     *
     * @param nums 给定的整数数组
     * @param k    所给定的目标值
     * @return 返回每个滑动窗口的最大值
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        // 用于存储结果的列表
        List<Integer> resultList = new ArrayList<>();
        // 双端队列，存储元素索引，按照对应元素值从大到小排列（索引对应值大的在前）
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 判断队列头部元素（索引）是否已经滑出窗口范围
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 将新元素与队列尾部元素比较，移除不可能成为最大值的元素
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 当窗口内元素个数达到k个时，记录窗口内最大值（队列头部元素对应的值）
            if (i >= k - 1) {
                resultList.add(nums[deque.peekFirst()]);
            }
        }
        // 将结果列表转换为int数组返回
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
