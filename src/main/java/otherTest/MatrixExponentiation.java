package otherTest;

import java.util.Scanner;

public class MatrixExponentiation {

    public static void main(String[] args) {
        //计算矩阵的次幂，递归
        //A2=A1*A1
        //A3=A2*A1
        //A4=A3*A1
        //ctrl + shift + o 去除导入的没有用的包 - eclipse
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        //存储结果的数组，同时作为中间件被传输
        //初始化结果数组
        int[][] result = new int[row][row];
        for (int i = 0; i < row; i++) {
            result[i][i] = 1;
        }

        int[][] calculateMatrix = calculateMatrix(result, arr, n);
        for (int i = 0; i < calculateMatrix.length; i++) {
            for (int j = 0; j < calculateMatrix.length; j++) {
                System.out.print(calculateMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] calculateMatrix(int[][] result, int[][] arr, int n) {
        int[][] temp;
        if (n == 0) {
            return result;
        }
        //8 4 2 1
        //5 4 2 1
        if (n % 2 == 0) {
            temp = calculateMatrix(result, arr, n / 2);
            return multiplyMatrix(temp, temp);
        } else {
            temp = calculateMatrix(result, arr, n - 1);
            return multiplyMatrix(temp, arr);
        }
    }

    private static int[][] multiplyMatrix(int[][] result, int[][] arr) {
        int[][] temp = new int[arr.length][arr.length];
        //矩阵乘法，矩阵第一行和另一个矩阵的第一列到最后一列相乘，
        //相应的数值的位置是相应的行标，列标
        //1 2 1 2
        //3 4 3 4
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = 0;
                for (int k = 0; k < arr.length; k++) {
                    sum += result[i][k] * arr[k][j];
                }
                temp[i][j] = sum;
            }
        }
        return temp;
    }
}
