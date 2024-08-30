package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * </p>
 */
public class LeetCode14 {
    public static void main(String[] args) {
        //System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"flower", "flow", "flight", ""}));
        System.out.println(new LeetCode14().longestCommonPrefix(new String[]{"a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();

        int length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length - 1; i++) {
            int temp = Math.min(strs[i].length(), strs[i + 1].length());
            if (temp < length) {
                length = temp;
            }
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
