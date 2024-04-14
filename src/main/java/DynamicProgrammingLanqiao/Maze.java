package DynamicProgrammingLanqiao;

public class Maze {

	// 迷宫地图
	private int[][] maze;

	// 迷宫大小
	private int row, col;

	// 方向数组
	//上->右->下->左
	private int[] dx = { -1, 0, 1, 0 };
	private int[] dy = { 0, 1, 0, -1 };

	public Maze(int[][] maze) {
		this.maze = maze;
		this.row = maze.length;
		this.col = maze[0].length;
	}

	public boolean dfs(int x, int y) {
		// 如果超出边界或者是墙壁,返回false
		if (!isValid(x, y) || maze[x][y] == 1) {
			return false;
		}

		// 标记当前位置已访问
		maze[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (dfs(nx, ny)) {
				// 如果子问题有解,返回true
				return true;
			}
		}

		// 没有找到下一个节点,回溯
		return false;
	}

	// 判断坐标是否在迷宫内
	private boolean isValid(int x, int y) {
		return x >= 0 && x < row && y >= 0 && y < col;
	}

	public static void main(String[] args) {
		int[][] maze = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		Maze m = new Maze(maze);
		if (m.dfs(0, 0)) {
			System.out.println("Found path!");
		} else {
			System.out.println("No path!");
		}
	}

}
