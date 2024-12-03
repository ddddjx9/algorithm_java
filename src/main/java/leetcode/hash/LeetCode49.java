package leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode49 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new LeetCode49().groupAnagrams(strs));
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * </p>
     * <p>
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * </p>
     *
     * @param strs 给定的字符串数组
     * @return 返回结果列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String key = new String(charArray);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                ArrayList<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
