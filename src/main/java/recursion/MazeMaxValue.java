package recursion;

import java.util.Scanner;

public class MazeMaxValue {
    static int[][] dp;

    public static void main(String[] args) {
        //1. 保证走的每一步都是价值最大化
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        /*dp = new int[n][n];
        dp[0][0] = maze[0][0];
        findMaxValueRecursion(maze, 0, 0, n);
        System.out.println(dp[n - 1][n - 1]);*/
        System.out.println(findMaxValueDynamicProgramming(maze, n));
    }

    public static void findMaxValueRecursion(int[][] maze, int row, int col, int n) {
        if (row == n - 1 && col == n - 1) {
            return;
        }
        //向右走
        if (col < n - 1) {
            if (dp[row][col + 1] < dp[row][col] + maze[row][col + 1]) {
                dp[row][col + 1] = dp[row][col] + maze[row][col + 1];
            }
            findMaxValueRecursion(maze, row, col + 1, n);
        }
        //向下走
        if (row < n - 1) {
            if (dp[row + 1][col] < dp[row][col] + maze[row + 1][col]) {
                dp[row + 1][col] = dp[row][col] + maze[row + 1][col];
            }
            findMaxValueRecursion(maze, row + 1, col, n);
        }
    }

    public static int findMaxValueDynamicProgramming(int[][] maze, int n) {
        int[][] dp = new int[n][n];
        dp[0][0] = maze[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + maze[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + maze[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + maze[i][j];
            }
        }
        return dp[n - 1][n - 1];
    }
}
