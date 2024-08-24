package leetcode;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LeetCode3 {
    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        //"abcabcbb"
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int total = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length() - 1; i++) {
            set.add(s.charAt(i));
            total++;
            for (int j = i + 1; j <= s.length() - 1; j++) {
                if (!set.contains(s.charAt(j))) {
                    total++;

                    if (j == s.length() - 1) {
                        max = Math.max(max, total);
                        total = 0;
                        set.clear();
                    }
                    set.add(s.charAt(j));
                } else {
                    max = Math.max(max, total);
                    total = 0;
                    set.clear();
                    break;
                }
            }
        }
        return max;
    }
}
