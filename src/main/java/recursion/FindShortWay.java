package recursion;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortWay {
    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //设置挡板，用1表示
        map[3][1] = 1;
        map[3][2] = 1;

        //输出地图
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("==========================================");

        // 使用BFS算法找到最短路径
        findShortestPath(map, 1, 1);
    }

    public static void findShortestPath(int[][] map, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (map[x][y] == 2) {
                // 找到终点，结束搜索
                break;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length && map[newX][newY] == 0) {
                    // 将新位置标记为已访问，并加入队列
                    map[newX][newY] = map[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        // 输出最短路径地图
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
