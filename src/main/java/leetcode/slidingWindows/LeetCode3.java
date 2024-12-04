package leetcode.slidingWindows;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LeetCode3 {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(new LeetCode3().lengthOfLongestSubstring(s));
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
     *
     * @param s 给定的字符串
     * @return 返回其中不含有重复字符的最长字串的长度
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        int startOffset = 0;
        int i = 0;
        while (i < s.length()) {
            // 如果遇到重复的字符串，不应该直接将集合清空
            // 应该将其中的重复字符移除掉
            if (set.contains(s.charAt(i))) {
                startOffset++;
                i = startOffset;
                set.clear();
                continue;
            }

            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, set.size());
            i++;
        }
        return maxLength;
    }
}
