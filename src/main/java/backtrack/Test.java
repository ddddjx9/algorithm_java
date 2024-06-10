package backtrack;

public class Test {
    public static void main(String[] args) {
        int[][] mazeMatrix = {
                {0, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 1, 1, 0}
        };

        ColoredMap coloredMap = new ColoredMap(mazeMatrix.length, mazeMatrix, 3); // 设置迷宫矩阵大小为 5x5
        MapOverlay mapOverlay = new MapOverlay();
        mapOverlay.findColorMethod(coloredMap, 0, coloredMap.getColorRecord()); // 设置起始节点编号为 0，颜色数量为 3
    }
}
