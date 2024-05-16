package recursion;

import java.util.Scanner;

public class SplitNumbers {
    static int[] arr;
    static int n;
    static int num;
    static int index = 0;
    static boolean flag = true;

    public static void main(String[] args) {
        //拆分数字
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        num = scanner.nextInt();
        arr = new int[n];
        scanner.close();
        int[] visited = new int[n + 1];
        splitNum(index, arr, visited);
    }

    public static void splitNum(int index, int[] arr, int[] visited) {
        //当数组满之后，判断是否符合条件，如果不符合，回溯
        //如果满足条件，停止递归，因为我们本来就是从最小的
        //字典序开始递归，只要找到一个满足条件的数组，就是最优解
        //1. 开头写结束递归的条件
        //2. 关键：如何生成全排列

        if (flag) {
            if (index == n) {
                int[] temp = new int[n];
                for (int i = 0; i <= n - 1; i++) {
                    temp[i] = arr[i];
                }
                for (int i = 1; i <= n - 1; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        temp[j] = temp[j] + temp[j + 1];
                    }
                }
                if (temp[0] == num) {
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    flag = false;
                    return;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 1) {
                    continue;
                }
                arr[index] = i;
                visited[i] = 1;
                splitNum(index + 1, arr, visited);
                visited[i] = 0;
            }
        }
    }
}
