package leetcode;

import java.util.ArrayList;

public class LeetCode12 {
    public static void main(String[] args) {
        System.out.println(new LeetCode12().intToRoman(1994));
    }

    public String intToRoman(int num) {
        ArrayList<String> list = new ArrayList<>();
        list.add("I");
        list.add("V");
        list.add("X");
        list.add("L");
        list.add("C");
        list.add("D");
        list.add("M");

        String s = String.valueOf(num);
        int length = s.length();
        StringBuilder sb = new StringBuilder();

        if (length == 4) {
            sb.append("M".repeat(Math.max(0, num / 1000)));

            for (int j = 1; j < length; j++) {
                concatString(s.charAt(j) - '0', sb, list.get((length - j) * 2 - 2), list.get((length - j) * 2 - 1), list.get((length - j) * 2));
            }
        } else {
            for (int j = 0; j < length; j++) {
                concatString(s.charAt(j) - '0', sb, list.get((length - j) * 2 - 2), list.get((length - j) * 2 - 1), list.get((length - j) * 2));
            }
        }

        return sb.toString();
    }

    public void concatString(int num, StringBuilder sb, String cl, String cb, String cu) {
        if (num < 4) {
            sb.append(cl.repeat(Math.max(0, num)));
        } else if (num == 4) {
            sb.append(cl).append(cb);
        } else if (num < 9) {
            sb.append(cb);
            sb.append(cl.repeat(num - 5));
        } else {
            sb.append(cl).append(cu);
        }
    }
}


