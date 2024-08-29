package leetcode;

import java.util.HashMap;

/**
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例。
 * </p>
 * <p>
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * </p>
 * <p>
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * </p>
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * </p>
 * <p>
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * </p>
 * <p>
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * </p>
 */
public class LeetCode13 {
    public static void main(String[] args) {
        System.out.println(new LeetCode13().romanToInt("MDCXCV"));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();

        //输入: s = "MCMXCIV"
        //输出: 1994
        //MDCXCV
        int num = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            //如果比后面的数大就取单个，反之就加上后面的一个
            if (i == n - 1) {
                num += map.get(chars[i]);
                break;
            }
            if (map.get(chars[i]) >= map.get(chars[i + 1])) {
                num += map.get(chars[i]);
            } else if (map.get(chars[i]) < map.get(chars[i + 1])) {
                num += (map.get(chars[i + 1]) - map.get(chars[i]));
                //两个值已经算过了，所以i++
                i++;
            }
        }

        return num;
    }
}
