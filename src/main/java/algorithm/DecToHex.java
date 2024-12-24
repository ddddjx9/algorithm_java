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
                final double pow = Math.pow(16, target.length() - i - 1);
                num = switch (c) {
                    case 'A' ->
                            num.add(new BigInteger(String.valueOf(10 * ((long) pow))));
                    case 'B' ->
                            num.add(new BigInteger(String.valueOf(11 * ((long) pow))));
                    case 'C' ->
                            num.add(new BigInteger(String.valueOf(12 * ((long) pow))));
                    case 'D' ->
                            num.add(new BigInteger(String.valueOf(13 * ((long) pow))));
                    case 'E' ->
                            num.add(new BigInteger(String.valueOf(14 * ((long) pow))));
                    case 'F' ->
                            num.add(new BigInteger(String.valueOf(15 * ((long) pow))));
                    default -> num;
                };
            } else {
                num = num.add(new BigInteger(String.valueOf(Integer.parseInt(String.valueOf(c)) * ((long) (Math.pow(16, target.length() - i - 1))))));
            }
        }
        System.out.println(num);
    }
}
