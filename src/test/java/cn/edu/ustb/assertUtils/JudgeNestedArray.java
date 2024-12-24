package cn.edu.ustb.assertUtils;

import java.util.List;
import java.util.stream.IntStream;

/**
 * 判断嵌套列表是否相等的工具类
 */
public class JudgeNestedArray {
    /**
     * 判断两个嵌套列表是否相等
     * @param list1 其中一个嵌套列表
     * @param list2 另一个嵌套列表
     * @return 返回两个嵌套列表是否相等
     */
    public static <T> boolean compareListOfListsWithStream(List<List<T>> list1, List<List<T>> list2) {
        if (list1 == null || list2 == null) {
            return false;
        }

        if (list1.size()!= list2.size()) {
            return false;
        }

        return IntStream.range(0, list1.size()).allMatch(i -> {
            List<T> subList1 = list1.get(i);
            List<T> subList2 = list2.get(i);
            return IntStream.range(0, subList1.size()).allMatch(j -> subList1.get(j).equals(subList2.get(j)));
        });
    }
}
