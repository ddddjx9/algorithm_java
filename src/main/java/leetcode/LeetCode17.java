package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 演示LeetCode17的解法：
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * </p>
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * </p>
 */
public class LeetCode17 {
    public static void main(String[] args) {
        System.out.println(new LeetCode17().letterCombinations("23"));
    }

    /**
     * 采用回溯法解决leetCode问题
     *
     * @param digits 提供的电话号码的数组
     * @return 返回一个由电话号码对应的字符串构成的数组
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuffer sb = new StringBuffer();
        backtrack(result, digits, map, 0, sb);

        return result;
    }

    public void backtrack(List<String> result, String digits, HashMap<Character, String> map, int index, StringBuffer sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            String s = map.get(digits.charAt(index));
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                backtrack(result, digits, map, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
