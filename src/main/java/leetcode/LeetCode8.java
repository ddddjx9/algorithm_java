package leetcode;

/**
 * 将字符串转换成一个 32 位有符号整数。
 * <p>
 * 函数 myAtoi(string s) 的算法如下:
 * <p>1. 空格:读入字符串并丢弃无用的前导空格（" "）。  </p>
 * <p>2. 符号:检查下一个字符（假设还未到字符末尾）为 '-' 还是 '+'。
 * 如果两者都不存在,则假定结果为正。  </p>
 * <p>
 * 3. 转换:通过跳过前置零来读取该整数,直到遇到非数字字符或到达字符串的结尾。
 * 如果没有读取数字,则结果为0。
 * </p>
 *
 * <p>
 * 4. 舍入:如果整数数超过 32 位有符号整数范围 [−2^31, 2^31 - 1] ,
 * 需要截断这个整数,使其保持在这个范围内。
 * <p>
 * &nbsp&nbsp具体来说,小于 −2^31 的整数应该被舍入为 −2^31 ,
 * </p>
 * <p>
 * &nbsp&nbsp大于 2^31 - 1 的整数应该被舍入为 2^31 - 1。
 * </p>
 * <p>
 * 5. 返回整数作为最终结果。
 * </p>
 */
public class LeetCode8 {
    public static void main(String[] args) {
        System.out.println(new LeetCode8().myAtoi("    -042"));
        System.out.println("       hello".trim());
    }

    //面向测试编程 - 狗头jpg.
    public int myAtoi(String s) {
        String str = s.trim();

        int sign = 1;
        int res = 0;
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' && i == 0) {
                sign = -1;
            } else if (str.charAt(i) == '+' && i == 0) {
                continue;
            } else if (Character.isDigit(str.charAt(i))) {
                num = str.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                    return Integer.MAX_VALUE;
                }

                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }

            res = res * 10 + sign * num;
        }

        return res;
    }
}
