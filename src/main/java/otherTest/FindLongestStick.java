package otherTest;

import java.util.Arrays;
import java.util.Scanner;

public class FindLongestStick {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        // 1 2 3 1
        // 1 1 2 3
        // 2 5
        // 1 2 3 1 4 5
        // 1 1 2 3 4 5
        // 1 2 3 1 2 4 5
        // 1 1 2 2 3 4 5
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int half = sum / 2;
        int res = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (res + arr[i] <= half) {
                res += arr[i];
            }
        }
        System.out.println(res);
    }
}
