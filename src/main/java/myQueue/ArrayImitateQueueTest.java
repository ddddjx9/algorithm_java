package myQueue;

import myQueue.dataStructure.ArrayImitateQueue;

import java.util.Scanner;

public class ArrayImitateQueueTest {
    public static void main(String[] args) {
        //测试
        ArrayImitateQueue aq = new ArrayImitateQueue(3);
        char key; //接受用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列里面取数据");
            System.out.println("h(head):查看队列头数据");
            key = sc.next().charAt(0); //接受一个字符
            switch (key) {
                case 's':
                    aq.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数据：");
                    int value = sc.nextInt();
                    aq.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = aq.getQueue();
                        System.out.printf("取出的数据是：%d/n", result);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = aq.headQueue();
                        System.out.printf("队列头的数据是：%d/n", result);
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

