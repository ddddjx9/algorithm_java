package algorithm;

import java.util.Scanner;

public class rabbitAndTortoise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rabbitSpeed = sc.nextInt();
        int tortoiseSpeed = sc.nextInt();
        int lead = sc.nextInt();
        int rest = sc.nextInt();
        int totalLength = sc.nextInt();
        int tortoiseTime = totalLength / tortoiseSpeed;

        //先写一个死循环，每一秒进行检查，如果兔子的总路程比乌龟的总路程常指定的路程，那么
        //停下来休息，秒数增加，路程不变，计算达到终点的秒数
        int time = 1;
        int rabbitLength = rabbitSpeed * time;
        int tortoiseLength = tortoiseSpeed * time;
        int rabbitTime = 1;
        while (rabbitLength < totalLength) {
            if (rabbitLength - tortoiseLength >= lead) {
                rabbitTime += rest;
                tortoiseLength += tortoiseSpeed * rest;
            } else {
                rabbitLength += rabbitSpeed * time;
                tortoiseLength += tortoiseSpeed * time;
                rabbitTime += time;
            }
        }
        if (tortoiseTime < rabbitTime) {
            System.out.println("T");
            System.out.println(tortoiseTime);
        } else if (tortoiseTime > rabbitTime) {
            System.out.println("R");
            System.out.println(rabbitTime);
        } else {
            System.out.println("D");
            System.out.println(tortoiseTime);
        }
    }
}