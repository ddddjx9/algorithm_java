package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class BFSQueen {
    static int n;
    static int[] blackQueen;
    static int[] whiteQueen;
    static ArrayList<Integer> list;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        blackQueen = new int[n + 1];
        whiteQueen = new int[n + 1];

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (input.nextInt() == 0) {
                    //存储棋盘中0的位置
                    list.add(i + 1);
                    list.add(j + 1);
                }
            }
        }

        dfs(1);

        System.out.println(count);
    }


    public static void dfs(int row) {
        if (row > 2 * n) {

            count++;
            return;
        }

        if (row <= n) {
            for (int i = 1; i <= n; i++) {
                blackQueen[row] = i;
                if (blackJudge(row, i)) {
                    dfs(row + 1);
                }
            }
        } else {
            for (int i = 1; i <= n; i++) {
                int temp = row % n;
                if (row % n == 0) {
                    //表示row==16时的情况
                    temp = n;
                }
                whiteQueen[temp] = i;
                if (whiteJudge(temp, i)) {
                    dfs(row + 1);
                }
            }
        }

    }


    public static boolean blackJudge(int r, int c) {
        for (int i = 0; i < list.size(); i += 2) {
            //查找是不是0
            //如果是0，就不能放皇后
            if (list.get(i) == r && list.get(i + 1) == c) {
                return false;
            }
        }

        for (int i = 1; i < r; i++) {
            //查找是不是同一列或者同一个对角线
            if (blackQueen[i] == c || (Math.abs(i - r) == Math.abs(blackQueen[i] - c))) {
                return false;
            }
        }

        return true;
    }

    public static boolean whiteJudge(int r, int c) {
        for (int i = 0; i < list.size(); i += 2) {
            if (list.get(i) == r && list.get(i + 1) == c) {
                //看看放置的位置是不是0
                return false;
            }
        }

        for (int i = 1; i < blackQueen.length; i++) {
            if (i == r && blackQueen[i] == c) {
                //不跟黑皇后放在同一个位置
                return false;
            }
        }

        for (int i = 1; i < r; i++) {
            if (whiteQueen[i] == c || (Math.abs(i - r) == Math.abs(whiteQueen[i] - c))) {
                //不在对角线和同一列上面
                return false;
            }
        }

        return true;
    }
}
