package otherTest;

import java.util.Scanner;

public class OuputString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        //发现递归的规律
        //每一个字符都是前一个字符将两边包围
        //"A"
        //"ABA"
        //"ABACABA"
        //digui(3)=digui(2)+"(char)(65+2)"+digui(2)
        //digui(2)=digui(1)+"(char)(65+1)"+digui(1)
        //digui(1)="A"
        System.out.println(recursion(num));
    }

    public static StringBuilder recursion(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 1) {
            return sb.append("A");
        }
        return sb.append(recursion(num - 1)).append((char) (65 + num - 1)).append(recursion(num - 1));
    }
}
