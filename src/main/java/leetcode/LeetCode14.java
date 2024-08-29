package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * </p>
 */
public class LeetCode14 {
    public static void main(String[] args) {
        System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"flower", "flow", "flight", ""}));
        System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();

        int length = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            length = Math.min(strs[i].length(), strs[i + 1].length());
        }

        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = 0; j < strs.length - 1; j++) {
                if (!strs[j].isEmpty() && !strs[j + 1].isEmpty() && strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                    count++;
                } else {
                    return sb.toString();
                }

                if (count == strs.length - 1) {
                    sb.append(strs[j].charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
