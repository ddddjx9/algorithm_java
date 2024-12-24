package dynamicProgramming;

public class FindMethodsMaze {
    public static void main(String[] args) {
        /*int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(findMethods1(m, n));*/
        int[][] maze = {{0, 1}, {0, 0}};
        System.out.println(findWayMaze(maze));
    }

    public static int findMethods1(int m, int n) {
        //
        //  1 2 3 4 5 6 7
        //1 1  1  1  1  1  1  1
        //2 1  2  3  4  5  6  7
        //3 1  3  6  10 15 21 28
        //定义数组：3行7列
        //初始化数组：第一行和第一列都只有一种走法，就是一直向下走或者一直向右走
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int findWayMaze(int[][] maze) {
        // 0 0 0
        // 0 1 0
        // 0 0 0
        //  0 1 2
        //0 1 1 1
        //1 1 0 1
        //2 1 1 2
        int[][] dp = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < maze[0].length; i++) {
            if (maze[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        if (maze.length == 1 || maze[0].length == 1) {
            for (int[] ints : maze) {
                if (ints[0] == 1) {
                    return 0;
                }
            }
            for (int i = 0; i < maze[0].length; i++) {
                if (maze[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[maze.length - 1][maze[0].length - 1];
    }
}
