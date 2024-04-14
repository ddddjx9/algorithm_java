package algorithm;

import java.util.Scanner;

public class CounterclockwiseNum {
    public static void main(String[] args) {
        //按照下->右->上->左的顺序回形取数
        //通过控制数组，实现对相应坐标的移动
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        //定义两个计数器
        //第一个变量count记录经历了几次循环，如果dx,dy一遍数组走完
        //说明一次循环就已经结束了
        //第二个total用于记录当前已经循环了多少个数字，如果数字等于row*col
        //说明已经遍历完毕，终止循环
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //定义两个计数器
        //第一个变量count记录经历了几次循环，如果dx,dy一遍数组走完
        //说明一次循环就已经结束了
        //第二个total用于记录当前已经循环了多少个数字，如果数字等于row*col
        //说明已经遍历完毕，终止循环
        int total = 0;

        //声明四个变量控制方向
        int down = 0; //行+1
        int right = row - 1;
        int up = col - 1;
        int left = 0; //列+1
        //System.out.print(arr[0][0]);
        while (true) {
            for (int i = 0; i < dx.length; i++) {
                if (i == 0) {
                    //说明向下走
                    for (int j = down; j <= right; j += dx[i]) {
                        System.out.print(arr[j][down + dy[i]] + " ");
                        total++;
                        if (total == row * col) {
                            return;
                        }
                    }
                } else if (i == 1) {
                    //向右走
                    for (int j = left + 1; j <= up; j += dy[i]) {
                        System.out.print(arr[right + dx[i]][j] + " ");
                        total++;
                        if (total == row * col) {
                            return;
                        }
                    }
                } else if (i == 2) {
                    //向上走
                    for (int j = right - 1; j >= left; j--) {
                        System.out.print(arr[j][up + dy[i]] + " ");
                        total++;
                        if (total == row * col) {
                            return;
                        }
                    }
                } else {
                    //向左走
                    for (int j = up - 1; j > down; j--) {
                        System.out.print(arr[left + dx[i]][j] + " ");
                        total++;
                        if (total == row * col) {
                            return;
                        }
                    }
                }
            }
            down += 1;
            left += 1;
            right = right - 1;
            up = up - 1;
        }
    }
}
