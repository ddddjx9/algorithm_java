package otherTest;

import java.util.Scanner;

public class PrintTime {

    public static void main(String[] args) {
        //将录入的数字按照/3600的商换算小时
        //余数应该就是剩下的秒数
        //然后再让余数除以60，换算商为分钟
        //然后将除以60后的余数为秒数
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        scanner.close();
        StringBuilder sBuilder = new StringBuilder();

        int divisor = time / 3600;
        int rest = time % 3600;
        sBuilder.append(divisor);
        sBuilder.append(":");

        divisor = rest / 60;
        rest = rest % 60;

        sBuilder.append(divisor);
        sBuilder.append(":");

        sBuilder.append(rest);
        System.out.println(sBuilder);

    }
}
