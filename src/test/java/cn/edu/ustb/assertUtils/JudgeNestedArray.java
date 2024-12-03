package cn.edu.ustb.assertUtils;

import java.util.List;
import java.util.stream.IntStream;

public class JudgeNestedArray {
    public static boolean compareListOfListsWithStream(List<List<Integer>> list1, List<List<Integer>> list2) {
        if (list1.size()!= list2.size()) {
            return false;
        }
        return IntStream.range(0, list1.size()).allMatch(i -> {
            List<Integer> subList1 = list1.get(i);
            List<Integer> subList2 = list2.get(i);
            return IntStream.range(0, subList1.size()).allMatch(j -> subList1.get(j).equals(subList2.get(j)));
        });
    }
}
