package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        /*if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);*/
        //剪枝
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        return optimizeRecursion(n, arr);
    }

    public static int frogJumpFootstep(int n) {
        //楼梯有n阶，青蛙要爬到楼顶，可以一次跳一阶，也可以一次跳两阶
        //只能向上跳，问有几种跳法
        //以第17阶台阶为例，有可能是从16阶台阶上来，也有可能是15阶，所以
        //f(17)=f(15)+f(16)
        //依次递归即可
        //f(3)=f(2)+f(1)
        //f(2)=f(1)
        if (n == 2) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return frogJumpFootstep(n - 1) + frogJumpFootstep(n - 2);
    }

    private static int optimizeRecursion(int n, int[] arr) {
        //典型的空间换时间的思想
        //避免重复调用，重复计算，提高效率
        //也可以使用循环递推的方式
        //空间换时间
        /*public static int Fibonacci(int n) {
            //1 1 2 3 5 8 13 21 34
            int[] arr = new int[n];
            if (n == 1) {
                return 1;
            }
            arr[0] = 1;
            arr[1] = 1;
            for (int i = 2; i < arr.length; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2])%10007;
            }
            return arr[n - 1];
        }*/

        if (arr[n] != -1) {
            //避免和前两项0和1出现冲突
            return arr[n];
        }
        int x = optimizeRecursion(n - 1, arr);
        int y = optimizeRecursion(n - 2, arr);
        arr[n] = x + y;
        return arr[n];
    }
}
