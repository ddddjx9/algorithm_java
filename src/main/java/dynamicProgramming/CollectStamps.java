package dynamicProgramming;

import java.util.Scanner;

public class CollectStamps {

    public static void main(String[] args) {
        // 动态规划 弄不出来递推公式直接白搭
        // 按照数学思维先把递推公式搞出来
        // 分解大问题，转为小问题，进而求出递推公式
        // 用dp数组存储缓存结果
        // 1. 接收数字
        // 长按ctrl键，然后点击鼠标，就跳转到方法调用处
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        double[][] dp = new double[m + 1][n + 1];

        //1. n==1,m==1
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //买了4张，集齐5种
                if (i < j) {
                    dp[i][j] = 0;
                } else if (j == 1) {
                    dp[i][j] = n * (Math.pow(1.0 / n, i));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] * ((n - (j - 1)) * 1.0 / n) + dp[i - 1][j] * (j * 1.0 / n);
                }
            }
        }
        System.out.printf("%.4f", dp[m][n]);
    }
}
