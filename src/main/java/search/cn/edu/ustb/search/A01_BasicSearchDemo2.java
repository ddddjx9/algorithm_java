package search.cn.edu.ustb.search;

import java.util.ArrayList;

public class A01_BasicSearchDemo2 {
    public static void main(String[] args) {
        //课堂练习1：
        //需求：定义一个方法利用基本查找，查询某个元素在数组中的索引
        //要求：不需要考虑数组中元素是否重复
        int[] arr = {131, 127, 147, 81, 103, 23, 7, 79, 81};
        int number = 82;
        int index = basicSearch1(arr, number);
        System.out.println(index);

        //课堂练习2：
        //需求：定义一个方法利用基本查找，查询某个元素在数组中的索引
        //要求：需要考虑数组中元素有重复的可能性
        //{131, 127, 147, 81, 103, 23, 7, 79, 81}
        //我要查找81，想要返回的是所有索引 3 8
        ArrayList<Integer> list = basicSearch2(arr, number);
        System.out.println(list);
    }

    //参数：
    //一：数组
    //二：要查找的元素

    //返回值：
    //元素是否存在

    //心得：
    //如果我们要返回多个数据的话，可以把这些数据放到数组或者集合中。

    public static int basicSearch1(int[] arr, int number) {
        //利用基本查找来查找number在数组中是否存在
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> basicSearch2(int[] arr, int number) {
        ArrayList<Integer> list = new ArrayList<>();
        //利用基本查找来查找number在数组中是否存在
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                list.add(i);
            }
        }
        return list;
    }
}
