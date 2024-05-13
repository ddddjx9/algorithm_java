package otherTest;

import java.util.Scanner;

public class RecursiveSymbol {
    public static void main(String[] args) {
        // 先找找规律
        // A1=sin(1)
        // A2=sin(1-sin(2))
        // A3=sin(1-sin(2+sin(3)))
        // S1=sin(1)+1
        // S2=(sin(1)+2)sin(1-sin(2))+1
        // S3=((sin(1)+3)sin(1-sin(2))+2)sin(1-sin(2+sin(3)))+1
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(Sn(num));
    }

    public static StringBuilder Sn(int num) {
        StringBuilder sb = new StringBuilder();
        // 先添加Sn的前置括号，然后再进行递推
        for (int i = 0; i < num - 1; i++) {
            sb.append("(");
        }
        for (int i = 1; i <= num; i++) {
            if (i == num) {
                sb.append(An(i)).append("+").append(num - i + 1);
            } else {
                sb.append(An(i)).append("+").append(num - i + 1).append(")");
            }
        }
        return sb;
    }

    public static StringBuilder An(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append("sin(1");
        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0) {
                sb.append("-").append("sin(").append(i);
            } else {
                sb.append("+").append("sin(").append(i);
            }
            if (i == num) {
                for (int j = 0; j < num; j++) {
                    sb.append(")");
                }
            }
        }
        if (num == 1) {
            sb.append(")");
        }
        return sb;
    }
}
