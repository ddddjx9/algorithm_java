package backtrack;

public class ColoredMap {
    private int top;
    private int[][] matrix;
    private int colorRecord;


    public ColoredMap() {
    }

    public ColoredMap(int top, int[][] matrix, int colorRecord) {
        this.top = top;
        this.matrix = matrix;
        this.colorRecord = colorRecord;
    }

    /**
     * 获取
     *
     * @return top
     */
    public int getTop() {
        return top;
    }

    /**
     * 设置
     *
     * @param top
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * 获取
     *
     * @return matrix
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * 设置
     *
     * @param matrix
     */
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * 获取
     *
     * @return color
     */
    public int getColorRecord() {
        return colorRecord;
    }

    /**
     * 设置
     *
     * @param colorRecord
     */
    public void setColorRecord(int colorRecord) {
        this.colorRecord = colorRecord;
    }

    public String toString() {
        return "ColoredMap{top = " + top + ", matrix = " + matrix + ", color = " + colorRecord + "}";
    }

    public void printMaze() {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }
}
