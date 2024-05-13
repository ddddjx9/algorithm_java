package dynamicProgramming;

public class MinValueWay {
    public static void main(String[] args) {
        //1 4 5
        //2 7 6
        //6 8 1
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(findMinValue(grid));
    }

    public static int findMinValue(int[][] grid) {
        //1 3 1
        //1 5 1
        //4 2 1
        //因为只可能从两个方向过来，所以我们只用看向上或者向左的方向，哪个方向价值最小，将价值更新为最小值即可
        //如果是第一行或者第一列，就是dp[0][i]=dp[0][i-1]+grid[0][i]
        //如果是其他方向，就是dp[i][j]=Integer.min(dp[i-1][j],dp[i][j-1])+grid[i][j]
        //定义二维数组
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //print(dp);
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }

}
