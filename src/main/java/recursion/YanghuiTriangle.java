package recursion;

import java.util.Scanner;

public class YanghuiTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            pascalTriangle2(arr, i);
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] recurrence(int n) {
        //递推解决杨辉三角，空间换时间
        //第一列全部是1，对角线全部是1
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }
        //1
        //1 1
        //1 2 1
        for (int i = 2; i < n; i++) {
            //从第二行第一列开始
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        return arr;
    }

    public static int pascalTriangle(int[][] arr, int i, int j) {
        if (arr[i][j] > 0) {
            return arr[i][j];
        }
        if (i == 0 || i == j) {
            arr[i][j] = 1;
            return 1;
        }
        //第一列全部是1，对角线全部是1
        //然后从第二行第一列开始递归
        //1
        //1 1
        //1 2 1

        arr[i][j] = pascalTriangle(arr, i - 1, j - 1) + pascalTriangle(arr, i - 1, j);
        return arr[i][j];

    }

    public static void pascalTriangle2(int[] arr, int i) {
        //采用一维数组存储计算出来的元素值
        //i表示第几行
        if (i == 0) {
            arr[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            arr[j] = arr[j - 1] + arr[j];
        }
    }
}
