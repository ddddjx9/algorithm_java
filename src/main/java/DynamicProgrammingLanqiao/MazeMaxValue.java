package DynamicProgrammingLanqiao;

import java.util.Scanner;

public class MazeMaxValue {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[][] maze=new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j]=scanner.nextInt();
			}
		}
		scanner.close();
		//1. 动态规划
		//3. 然后将每一条路的价值进行更新
		//4. 找到最大价值的路即可
		//暴力一点，存储一个变量，如果另一条路价值更大，对其进行更新
		//如果一条路走完了，回溯
		//开始尝试：
		
	}
	
	public int maxCoins(int[][] grid) {
	    int n = grid.length;
	    int[][] dp = new int[n][n];
	    
	    dp[0][0] = grid[0][0];

	    // 初始化第一行和第一列
	    for (int i = 1; i < n; i++) {
	        dp[0][i] = dp[0][i - 1] + grid[0][i];
	        dp[i][0] = dp[i - 1][0] + grid[i][0];
	    }

	    // 计算其他格子的最大金币数量
	    for (int i = 1; i < n; i++) {
	        for (int j = 1; j < n; j++) {
	            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
	        }
	    }

	    return dp[n - 1][n - 1];
	}
}
