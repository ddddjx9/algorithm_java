package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new LeetCode56().merge(intervals);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * <p>
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * </p>
     *
     * @param intervals 传递过来的二维数组
     * @return 返回一个一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
     */
    public int[][] merge(int[][] intervals) {
        // 将所有区间数据按照升序排列，如果前一个区间和后一个区间之间，第一个数字比前一个区间中的最后一个数字大，那么这两个区间之间就可以合并
        if (intervals.length == 0) {
            return intervals;
        }
        // 按照区间的起始值对整个区间集合进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> resultList = new ArrayList<>();
        int[] current = intervals[0];
        resultList.add(current);
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            // 检查当前区间和下一个区间是否重叠，若重叠则合并
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                resultList.add(current);
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }
}
