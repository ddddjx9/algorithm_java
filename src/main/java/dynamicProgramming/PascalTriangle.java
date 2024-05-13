package dynamicProgramming;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PascalTriangle(n);
    }

    public static void PascalTriangle(int n) {
        //1
        //1 1
        //1 2 1
        //1 3 3  1
        //1 4 6  4  1
        //1 5 10 10 5 1
        //观察这个数组的情况可以发现，主对角线和第一列的值全部是1
        //第二行的值全部是1
        //其他情况：
        //dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        //打印dp数组
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0 && j < i) {
                    System.out.print(dp[i][j] + ",");
                }
                if (j == i) {
                    System.out.print(dp[i][j]);
                }
            }
            if (i < n - 1) {
                System.out.print("],");
            } else {
                System.out.print("]");
            }
        }
        System.out.print("]");
    }

}
