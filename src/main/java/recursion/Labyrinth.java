package recursion;

public class Labyrinth {
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
        for (int[] value : map) {
            for (int i : value) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("==========================================");

        //使用递归回溯给小球找路
        setWay2(map, 1, 1);

        //输出新的地图。小球走过并标识过的地图
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路
    //说明：
    //1. Map表示地图
    //2. i,j 表示从地图的哪个位置开始找
    //3. 如果小球能够到map的[6][5]位置，表示通路找到
    //4. 约定：当map[i][j]=0时，表示该点还没有走过；1表示墙；2表示通路，可以走；3表示该点已经走过，但是走不通
    //5. 在走迷宫时，我们需要确定一个策略，先由人判断怎样更省力，比如：
    //      先走下面->右面->上面->左面，如果该点走不通，再回溯
    /*
        map 表示地图
        i 表示从哪个位置开始找
        j
        如果找到则为真。如果找不到则为假
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前这个点还没有走过
                //按照策略走
                //在走之前，先将这个点标为2

                //假定该点可以走通
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j]!=0，有可能为1，2或者3
                //1是墙，不能走；2是走过了，不能走；3是死路，不能走
                return false;
            }
        }
    }

    //修改找路的策略
    //改成上->右->下->左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //说明通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                //如果当前这个点还没有走过
                //按照策略走
                //在走之前，先将这个点标为2

                //假定该点可以走通
                map[i][j] = 2;
                if (setWay2(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay2(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay2(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                //如果map[i][j]!=0，有可能为1，2或者3
                //1是墙，不能走；2是走过了，不能走；3是死路，不能走
                return false;
            }
        }
    }
}
