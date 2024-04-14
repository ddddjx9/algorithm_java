package DynamicProgrammingLanqiao;

import java.util.Scanner;

public class MaxSkill {
	static int preSkill;

	public static void main(String[] args) {
		// 录入n个技能和m个技能点
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] skill = new int[n];
		for (int i = 0; i < n; i++) {
			skill[i] = scanner.nextInt();
		}
		int[][] predict = new int[n - 1][2];
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < 2; j++) {
				predict[i][j] = scanner.nextInt();
			}
		}
		boolean[] flag = new boolean[n + 1];
		scanner.close();
		int[][] dp = new int[n][m];
		// 初始化动态数组
		// 应该二维数组，dp[n][m]表示能获得的最大威力
		for (int i = 0; i < m; i++) {
			dp[0][i] = skill[0];// 第一个技能可能是那个最根本的技能
		}
		for (int i = 0; i < n; i++) {
			dp[i][0] = skill[0];
		}
		// 基本逻辑处理完毕，现在开始处理先导式，如果有了先导技能后递推式会不会发生什么改变
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				// 访问先导技能的数组，如果是除了1没有依赖的先导技能，比如不存在3->2->1这样的连续依赖，递推式不发生改变
				if (flag[predict[i - 1][0]] != true) {
					// 为了避免有连续依赖的关系，一直访问，直到技能的先导技能为1为止，记录这时候的技能序号，下一次如果
					// 还有技能点，那么就访问它的先导技能的先导技能
					findPredictSkill(predict, i - 1, predict[i - 1][1]);

					if (m - i > 0) {
						dp[i][j] = dp[i][j - 1] + skill[preSkill - 1];
					}
					flag[predict[i - 1][0]] = true;
				} else {
					dp[i][j] = dp[i][j - 1] + skill[i];
					flag[i] = true;
				}
			}

		}
		System.out.println(dp[n - 1][m - 1]);
	}

	public static void findPredictSkill(int[][] predict, int row, int skill) {
		if (predict[row][0] == 1 && predict[row][1] == skill) {
			preSkill = predict[row][1];
			return;
		}
		findPredictSkill(predict, row - 1, predict[row][0]);
	}
}
