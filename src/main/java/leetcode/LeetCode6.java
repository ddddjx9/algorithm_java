package leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * </p>
 * <p>
 * P   A   H   N
 * </p>
 * <p>
 * A P L S I I G
 * </p>
 * <p>
 * Y   I   R
 * </p>
 */
public class LeetCode6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(new LeetCode6().convert(str, n));
    }

    public String convert(String s, int numRows) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        int total = 0;
        while (total < s.length()) {
            for (int i = 0; i < numRows; i++) {
                if (total >= s.length()) {
                    break;
                }
                list.get(i).add(s.charAt(total++));
            }

            for (int i = numRows - 2; i > 0; i--) {
                if (total >= s.length()) {
                    break;
                }
                list.get(i).add(s.charAt(total++));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (ArrayList<Character> characters : list) {
            for (Character c : characters) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
