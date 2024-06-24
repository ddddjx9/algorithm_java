package sort;

import java.util.ArrayList;

public class RadixSort {
    public static void main(String[] args) {
        String[] phoneNumbers = new String[10];
        phoneNumbers[0] = "13812345678";
        phoneNumbers[1] = "18030429597";
        phoneNumbers[2] = "18734608756";
        phoneNumbers[3] = "13685471698";
        phoneNumbers[4] = "13784759876";
        phoneNumbers[5] = "13548671395";
        phoneNumbers[6] = "15487695881";
        phoneNumbers[7] = "15587360945";
        phoneNumbers[8] = "15087469180";
        phoneNumbers[9] = "27894681378";

        radixSort(phoneNumbers, phoneNumbers.length);
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }

    /**
     * 基数排序（LSD）：按位排序，一位一位来排，个十百千万来排序
     * <p>
     * 第一轮：按前三位数字中的个位来排序，结合桶排序来实现，使用0123456789，九个桶来排序
     * </p>
     * <p>
     * &nbsp;&nbsp;保证遍历的顺序和放入桶中的顺序一致
     * </p>
     * <p>
     * 第二轮：按前三位数字中的十位来排序，将其依次放入桶中
     * </p>
     * <p>
     * &nbsp;&nbsp;注意：轮数越靠后，它的优先级越高，如果从高往低排，个位的优先级越高，就会得到错误的结果
     * </p>
     *
     * @param arr    待排序的数组
     * @param length 待排序的数组中元素长度
     */
    public static void radixSort(String[] arr, int length) {
        //准备桶
        //集合数组范围为每一个字符串中的字符范围
        //这里设置为ASCII码的范围
        ArrayList<String>[] buckets = new ArrayList[128];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = length - 1; i >= 0; i--) {
            //根据每一位进行排序
            for (String s : arr) {
                //根据字符的末位确定一个字符在哪个桶 - 确定索引值
                int index = s.charAt(i);
                //根据个位加入到相应的桶
                buckets[index].add(s);
            }

            int index = 0;
            //将桶里的元素取出，放回到原始数组中
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    arr[index++] = s;
                }
                //放回到原始数组中后，清空当前的桶
                bucket.clear();
            }
            //调试：System.out.println(Arrays.toString(arr));
        }
    }
}
