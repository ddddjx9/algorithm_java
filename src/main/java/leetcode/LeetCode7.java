package leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * </p>
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * </p>
 */
public class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(new LeetCode7().reverse(123));
    }

    public int reverse(int x) {
        //int的范围是-2^31次方 ~ 2^31次方-1
        //提示：
        //-2^31 <= x <= 2^31 - 1
        int reversed = 0;
        int INT_MAX = Integer.MAX_VALUE; // 2147483647
        int INT_MIN = Integer.MIN_VALUE; // -2147483648

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // 检查是否会溢出
            if (reversed > INT_MAX / 10 || (reversed == INT_MAX / 10 && pop > 7)) {
                return 0;
            }
            if (reversed < INT_MIN / 10 || (reversed == INT_MIN / 10 && pop < -8)) {
                return 0;
            }

            // 更新反转后的结果
            reversed = reversed * 10 + pop;
        }

        return reversed;
    }
}
