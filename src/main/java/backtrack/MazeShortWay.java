package backtrack;

import java.util.ArrayList;
import java.util.List;

public class MazeShortWay {
    // 迷宫的行数和列数
    static final int ROW = 3;
    static final int COL = 3;
    // 迷宫的起点和终点
    static final int startX = 0;
    static final int startY = 0;
    static final int endX = 2;
    static final int endY = 2;
    static int count = 0;
    static int[][] record = new int[3][3];
    // 迷宫的地图，0 表示可以通过的路，1 表示墙壁，2 表示已经走过的路
    static int[][] map = new int[][]{{0, 0, 0}, {0, 0, 1}, {0, 0, 0}};
    // 存储搜索路径
    static List<int[]> path = new ArrayList<>();

    // DFS 搜索迷宫
    public static void dfs(int x, int y) {
        // 如果当前位置是终点，则搜索完成
        if (x == endX && y == endY) {
            // 打印搜索路径
            for (int[] p : path) {
                System.out.print("(" + p[0] + "," + p[1] + ") ");
            }
            System.out.println("(" + x + "," + y + ")");
            System.out.println(count);
            return;
        }

        // 标记当前位置已经走过
        map[x][y] = 2;

        // 将当前位置加入搜索路径
        path.add(new int[]{x, y});
        count++;

        // 分别搜索当前位置的上下左右四个方向
        if (x > 0 && map[x - 1][y] == 0) {
            dfs(x - 1, y);
        }
        if (x < ROW - 1 && map[x + 1][y] == 0) {
            dfs(x + 1, y);
        }
        if (y > 0 && map[x][y - 1] == 0) {
            dfs(x, y - 1);
        }
        if (y < COL - 1 && map[x][y + 1] == 0) {
            dfs(x, y + 1);
        }

        // 如果没有找到终点，将当前位置从搜索路径中移除
        count--;
        map[x][y] = record[x][y];
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < record.length; i++) {
            for (int j = 0; j < record.length; j++) {
                record[i][j] = map[i][j];
            }
        }
        dfs(startX, startY);
    }
}
