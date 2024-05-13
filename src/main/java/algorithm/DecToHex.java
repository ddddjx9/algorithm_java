package algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class DecToHex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        BigInteger num = new BigInteger("0");
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (Character.isAlphabetic(c)) {
                switch (c) {
                    case 'A':
                        num = num.add(new BigInteger(String.valueOf(10 * ((long) (Math.pow(16, target.length() - i - 1))))));
                        break;
                    case 'B':
                        num = num.add(new BigInteger(String.valueOf(11 * ((long) (Math.pow(16, target.length() - i - 1))))));
                        break;
                    case 'C':
                        num = num.add(new BigInteger(String.valueOf(12 * ((long) (Math.pow(16, target.length() - i - 1))))));
                        break;
                    case 'D':
                        num = num.add(new BigInteger(String.valueOf(13 * ((long) (Math.pow(16, target.length() - i - 1))))));
                        break;
                    case 'E':
                        num = num.add(new BigInteger(String.valueOf(14 * ((long) (Math.pow(16, target.length() - i - 1))))));
                        break;
                    case 'F':
                        num = num.add(new BigInteger(String.valueOf(15 * ((long) (Math.pow(16, target.length() - i - 1))))));
                        break;
                }
            } else {
                num = num.add(new BigInteger(String.valueOf(Integer.parseInt(String.valueOf(c)) * ((long) (Math.pow(16, target.length() - i - 1))))));
            }
        }
        System.out.println(num);
    }
}
