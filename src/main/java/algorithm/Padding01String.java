package algorithm;

import java.util.Arrays;

public class Padding01String {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("00000");
        sb.append(",");
        char[] arr = new char[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = '1';
            padding0(arr);
            sb.append(arr);
            sb.append(",");
            clear(arr);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                arr[i] = '1';
                arr[j] = '1';
                padding0(arr);
                sb.append(arr);
                sb.append(",");
                clear(arr);
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                arr[i] = '0';
                arr[j] = '0';
                padding1(arr);
                sb.append(arr);
                sb.append(",");
                clear(arr);
            }
        }
        for (int i = 0; i < 5; i++) {
            arr[i] = '0';
            padding1(arr);
            sb.append(arr);
            sb.append(",");
            clear(arr);
        }
        sb.append("11111");
        String[] split = sb.toString().split(",");
        Arrays.sort(split);
        for (String s : split) {
            System.out.println(s);
        }
    }

    public static void padding0(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '1') {
                arr[i] = '0';
            }
        }
    }

    public static void padding1(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0') {
                arr[i] = '1';
            }
        }
    }

    public static void clear(char[] arr) {
        Arrays.fill(arr, ' ');
    }
}
