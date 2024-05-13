package otherTest;

import java.util.Scanner;

public class MaxGCD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();
        MaxGCD maxGCD = new MaxGCD();
        int findGCD = maxGCD.findGCD(a, b);
        System.out.println(findGCD);
    }

    public int findGCD(int a, int b) {
        int t = a < b ? a : b;
        int gcd = 1;
        for (int i = t; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }
}
