package otherTest;

import java.util.LinkedList;

public class HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) {
        a.addLast(4);
        a.addLast(3);
        a.addLast(2);
        a.addLast(1);
        hanoiTower(4, a, b, c);
        System.out.println(count);
    }

    //汉诺塔的移动方案
    //使用分治算法
    public static void hanoiTower(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        //如果只有一个盘
        if (n == 0) {
            return;
        }
        //先将第n-1个盘从a移动到b
        hanoiTower(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print();
        count++;
        hanoiTower(n - 1, b, a, c);
    }

    public static void print() {
        System.out.println("==============================");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
