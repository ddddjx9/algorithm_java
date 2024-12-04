package leetcode.slidingWindows;

import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new LeetCode438().findAnagrams(s, p));
    }

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串
     * <p>
     * 返回这些子串的起始索引。不考虑答案输出的顺序
     * </p>
     *
     * @param s 给定的字符串1
     * @param p 给定的字符串2
     * @return 返回返回这些子串的起始索引构成的集合
     */
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (s.length() < p.length()) {
            return resultList;
        }
        // 用于统计字符串p中各字符出现的频次
        int[] pCount = new int[26];
        // 用于统计滑动窗口中各字符出现的频次
        int[] windowCount = new int[26];
        // 先统计字符串p的字符频次
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        // 初始化窗口
        for (int i = 0; i < p.length(); i++) {
            windowCount[s.charAt(i) - 'a']++;
        }
        if (isAnagram(pCount, windowCount)) {
            resultList.add(0);
        }

        // 滑动窗口遍历后续位置
        for (int i = p.length(); i < s.length(); i++) {
            // 移除窗口最左边字符的频次记录
            windowCount[s.charAt(i - p.length()) - 'a']--;
            // 添加窗口新进入字符的频次记录
            windowCount[s.charAt(i) - 'a']++;
            if (isAnagram(pCount, windowCount)) {
                resultList.add(i - p.length() + 1);
            }
        }

        return resultList;
    }

    /**
     * 统计目标字符串中各个字符出现的频次数和窗口中的字符串出现的频次数是否相等
     * @param pCount 统计目标字符串中各个字符出现的频次数
     * @param windowCount 统计窗口中的字符串出现的频次数
     * @return 返回是否相等的结果
     */
    private boolean isAnagram(int[] pCount, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i]!= windowCount[i]) {
                return false;
            }
        }
        return true;
    }
}