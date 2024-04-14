package algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class ReadNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        // str<=20 0000 0000
        // 如果要读数，应该先确定几位，二位数，最高为十
        // 三位数，最高为百
        // 四位数，最高为千
        // 五位数，最高为万
        // 九位数，最高为亿
        // 12 4567 8925
        int length = str.length();

        // 建立map,创建数字与汉字之间的映射
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', "ling");
        map.put('1', "yi");
        map.put('2', "er");
        map.put('3', "san");
        map.put('4', "si");
        map.put('5', "wu");
        map.put('6', "liu");
        map.put('7', "qi");
        map.put('8', "ba");
        map.put('9', "jiu");

        // 开始切割数字
        HashMap<Integer, String> addressHashMap = new HashMap<>();
        addressHashMap.put(1, "");
        addressHashMap.put(2, "shi");
        addressHashMap.put(3, "bai");
        addressHashMap.put(4, "qian");
        addressHashMap.put(5, "wan");
        addressHashMap.put(9, "yi");
        // 每四位一切割
        StringBuilder sb = new StringBuilder();
        if (length <= 4) {
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                if (length == 1) {
                    sb.append(map.get(c));
                    break;
                }
                if (length == 2 && i == 0 && c == '1') {
                    //10
                    sb.append("shi").append(" ");
                    continue;
                }
                if (c != '0') {
                    if (i >= 1 && str.charAt(i - 1) == '0') {
                        sb.append("ling").append(" ");
                    }
                    sb.append(map.get(c)).append(" ").append(addressHashMap.get(length - i)).append(" ");
                }
            }
        } else if (length <= 8) {
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                // 10 2589
                if (c != '0') {
                    if (i >= 1 && str.charAt(i - 1) == '0') {
                        sb.append("ling").append(" ");
                    }
                    if (length == 6 && i == 0 && c == '1') {
                        sb.append("shi").append(" ");
                        continue;
                    }
                    if (i < length - 1 - 4) {
                        //1008 0569
                        sb.append(map.get(c)).append(" ").append(addressHashMap.get(length - i - 4)).append(" ");
                    } else if (i == length - 1 - 4) {
                        sb.append(map.get(c)).append(" ").append("wan").append(" ");
                    } else {
                        sb.append(map.get(c)).append(" ").append(addressHashMap.get(length - i)).append(" ");
                    }
                }
            }
        } else {
            for (int i = 0; i < length; i++) {
                char c = str.charAt(i);
                // 10 2589 4568
                if (length == 10 && c == '1' && i == 0) {
                    sb.append("shi").append(" ");
                    continue;
                }
                if (c != '0') {
                    if (i >= 1 && str.charAt(i - 1) == '0') {
                        sb.append("ling").append(" ");
                    }
                    if (i < length - 1 - 8) {
                        sb.append(map.get(c)).append(" ").append(addressHashMap.get(length - i - 8)).append(" ");
                    } else if (i == length - 1 - 8) {
                        //1 0000 0000
                        sb.append(map.get(c)).append(" ").append("yi").append(" ");
                    } else if (i < length - 1 - 4) {
                        sb.append(map.get(c)).append(" ").append(addressHashMap.get(length - i - 4)).append(" ");
                    } else if (i == length - 1 - 4) {
                        //1 0007 0058
                        sb.append(map.get(c)).append(" ").append("wan").append(" ");
                    } else {
                        sb.append(map.get(c)).append(" ").append(addressHashMap.get(length - i)).append(" ");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
