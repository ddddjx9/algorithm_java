package leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串
 */
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(new LeetCode5().longestPalindrome("bu"));
    }

    /**
     * 暴力枚举法求解最长回文子串
     *
     * @param s 传入的字符串
     * @return 返回最长的回文子串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        if (s.length() == 1) {
            return s;
        }

        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isPalindrome(s, i, j) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

