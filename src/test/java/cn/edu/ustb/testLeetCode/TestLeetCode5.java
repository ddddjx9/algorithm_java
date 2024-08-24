package cn.edu.ustb.testLeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLeetCode5 {
    @Test
    public void test() {
        assertEquals("bb", longestPalindrome("bb"));
    }

    /**
     * 中心扩展方法求解最长回文字串的问题
     *
     * @param s 传入的字符串
     * @return 返回最长的回文子串
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //偶数
            int len1 = expandString(s, i, i + 1);
            //奇数情况
            int len2 = expandString(s, i, i);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandString(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left + 1 - 2;
    }
}
