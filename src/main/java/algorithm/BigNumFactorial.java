package algorithm;

import java.util.Scanner;

public class BigNumFactorial {
    public static void main(String[] args) {
        int c = 0;
        int s;
        int[] arr = new int[5000];
        arr[0] = 1;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < arr.length; j++) {
                s = arr[j] * i + c;
                arr[j] = s % 10;
                c = s / 10;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                for (int j = i; j >= 0; j--) {
                    System.out.print(arr[j]);
                }
                break;
            }
        }
    }
}
