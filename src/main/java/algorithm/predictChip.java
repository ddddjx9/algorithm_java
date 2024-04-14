package algorithm;

import java.util.*;

public class predictChip {
    public static void main(String[] args) {
        //初步思路：
        //如果有几组数据一样，应该说明这些都是好芯片，然后初步筛选
        //查看这些数据中有哪些是坏的芯片，然后根据坏芯片的位置去进一步筛选
        //避免出现记录偶然相同但是没有筛选出来的情况

        //1.接收芯片有几个
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //2.接收芯片数据
        int[][] chipData = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                chipData[i][j] = sc.nextInt();
            }
        }

        //用于记录不同的数据
        //然后用这个数组一遍一遍对比，是否有相同记录
        HashMap<int[], Integer> duplicates = findDuplicates(chipData);
        Set<Map.Entry<int[], Integer>> entries = duplicates.entrySet();
        int max = 0;
        int[] repeatArr = new int[num];
        for (Map.Entry<int[], Integer> entry : entries) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                repeatArr = entry.getKey();
            }
        }
        for (int i = 0; i < repeatArr.length; i++) {
            if (repeatArr[i] == 1) {
                System.out.print(i + 1 + " ");
            }
        }
    }

    public static HashMap<int[], Integer> findDuplicates(int[][] arr) {
        HashMap<int[], Integer> duplicates = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Arrays.equals(arr[i], arr[j])) {
                    // 如果发现重复的行，则将其记录到duplicates中
                    //如果当前行在记录里面没有出现，那么记为1
                    //如果出现过，get到value值后+1即可
                    if (!duplicates.containsKey(arr[i])) {
                        duplicates.put(arr[i], 1);
                    } else {
                        duplicates.put(arr[i], duplicates.get(arr[i]) + 1);
                    }
                }
            }
        }
        return duplicates;
    }
}
