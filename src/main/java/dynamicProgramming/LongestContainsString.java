package dynamicProgramming;

import java.util.Scanner;

public class LongestContainsString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        findLongestString(s);
    }

    public static void findLongestString(String s) {
        //babad
        //    b a b a d
        //d   0 0 0 0 1
        //a   0 1 0 1 0
        //b   1 0 2 0 0
        //a   0 2 0 3 0
        //b   1 0 3 0 0
        if (s.length() <= 2) {
            System.out.println(s.charAt(0));
            return;
        }
        int range = 0;
        int index = 0;
        int anoRange = 1;
        int flag;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) != s.charAt(i)) {
                //babad类型
                int record = 0;
                StringBuilder sb = new StringBuilder();
                String startStr = s.substring(i - record, i + 1);
                String endStr = s.substring(i, i + record + 1);
                sb.append(endStr).reverse();
                while (startStr.contentEquals(sb)) {
                    record++;
                    if ((i - record) >= 0 && i + record + 1 <= s.length() - 1) {
                        startStr = s.substring(i - record, i + 1);
                        endStr = s.substring(i, i + record + 1);
                        sb.setLength(0);
                        sb.append(endStr).reverse();
                    } else {
                        break;
                    }
                }
                if (record >= range) {
                    range = record;
                    index = i;
                }
            } else {
                //abbd类型
                //i-1 i i+1 i+2
                int record = 0;
                while ((i - record) >= 0 && (i + record + 1) <= s.length() - 1 && s.charAt(i - record) == s.charAt(i + record + 1)) {
                    record++;
                }
                if (record >= anoRange) {
                    anoRange = record;
                    index = i;
                }
            }
        }
        flag = range > anoRange ? 1 : 2;
        switch (flag) {
            case 1:
                //babad
                //index=1
                //range=1
                for (int i = index - range + 1; i <= index + range - 1; i++) {
                    System.out.print(s.charAt(i));
                }
                break;
            case 2:
                //abbd
                //abba
                //anotherRange=2
                //index=2
                //aabb
                //index=1
                //range=1
                for (int i = index - anoRange + 1; i <= index + anoRange; i++) {
                    System.out.print(s.charAt(i));
                }
        }
    }
}
