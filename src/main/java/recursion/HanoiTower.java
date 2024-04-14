package recursion;

import java.util.LinkedList;
import java.util.Scanner;

public class HanoiTower {
    //定义为静态变量，使得两个方法都能访问，不用额外传递参数
    static LinkedList<Integer> listA = new LinkedList<>();
    static LinkedList<Integer> listB = new LinkedList<>();
    static LinkedList<Integer> listC = new LinkedList<>();

    public static void main(String[] args) {
        //递归不能传递数字过大，要是数字过大，时间复杂度过高，无法在3s内完成任务，舍弃
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        init(n);
        hanoiTower(listA, listB, listC, n);
    }

    /**
     * @param a 要移动的圆盘柱子
     * @param b 中间柱子
     * @param c 目标柱子
     * @param n 圆盘数量
     */
    public static void hanoiTower(LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c, int n) {
        //3 2 1
        //如果要使得圆盘从a移动到c
        //先将n-1个圆盘从a移动到b, 借助c
        //然后将第n个圆盘从a移动到c, 借助b
        //然后将n-1个圆盘从b移动到c, 借助a
        if (n == 0) {
            return;
        }
        //3 2 1
        //1 2 3
        hanoiTower(a, c, b, n - 1);
        c.addLast(a.removeLast());
        print();
        hanoiTower(b, a, c, n - 1);
    }

    public static void init(int n) {
        for (int i = n; i > 0; i--) {
            listA.addLast(i);
        }
    }

    public static void print() {
        System.out.println("=============================");
        System.out.println(listA);
        System.out.println(listB);
        System.out.println(listC);
    }
}
