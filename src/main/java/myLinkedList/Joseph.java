package myLinkedList;

import myLinkedList.dataStructure.SinglyCircleListNode;

import java.util.ArrayList;
import java.util.Scanner;

public class Joseph {
    public static void main(String[] args) {
        //测试遍历代码
//        SinglyCircleListNode list = new SinglyCircleListNode();
//        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//
//        for (Integer i : list) {
//            System.out.println(i);
//        }

        SinglyCircleListNode list = new SinglyCircleListNode();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Integer> joseph = list.joseph(a, b);
        for (int i = 0; i < joseph.size(); i++) {
            System.out.println(joseph.get(i));
        }
    }
}
