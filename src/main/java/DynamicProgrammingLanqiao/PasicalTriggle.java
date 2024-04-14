package DynamicProgrammingLanqiao;

public class PasicalTriggle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createRow(5);
	}

	public static int[] pasicalTriggle1(int n) {
		// 初始化dp数组
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		if (n < 2) {
			return dp;
		}
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp;
	}

	private static void pasicalTriggle2(int[] row, int i) {
		if (i == 0) {
			row[0] = 1;
			return;
		}
		for (int j = i; j > 0; j--) {
			row[j] = row[j] + row[j - 1];
		}
	}

	public static void createRow(int n) {
		int[] row = new int[n];
		for (int i = 0; i < n; i++) {
			pasicalTriggle2(row, i);
			for (int j = 0; j <= i; j++) {
				System.out.print(row[j] + " ");
			}
			System.out.println();
		}
	}
}
