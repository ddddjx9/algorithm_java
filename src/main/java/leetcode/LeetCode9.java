package leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数：是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * </p>
 */
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(new LeetCode9().isPalindromePoint(123321));
        System.out.println(new LeetCode9().isPalindromeStringRev(1221));
    }

    /**
     * 使用字符串反转解决
     *
     * @param x 所给的整数
     * @return 返回是否是回文字符串
     */
    public boolean isPalindromeStringRev(int x) {
        StringBuilder sb = new StringBuilder();
        return String.valueOf(x).contentEquals(sb.append(x).reverse());
    }

    /**
     * 采用左右指针法解决
     *
     * @param x 所给的整数
     * @return 返回所给的整数是否是回文字符串
     */
    public boolean isPalindromePoint(int x) {
        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
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
