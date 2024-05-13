package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class CombineSelect {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CombineSelect combineSelect = new CombineSelect();
        ArrayList<int[]> combineSelect2 = combineSelect.combineSelect(3, 2);
        // 转到方法声明处，ctrl + 鼠标左键
        // eclipse中竖向选择的快捷键：alt + shift + a

        combineSelect2.forEach(new Consumer<int[]>() {
            @Override
            public void accept(int[] t) {
                // TODO Auto-generated method stub
                System.out.println(Arrays.toString(t));
            }

        });

    }

    public ArrayList<int[]> combineSelect(int m, int n) {
        // C53=10
        // C32=3
        // 1 2
        // 1 3
        // 2 3

        ArrayList<int[]> resultList = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            for (int j = i + 1; j <= m; j++) {
                int[] select = new int[n];
                select[0] = i;
                select[1] = j;
                resultList.add(select);
            }
        }
        return resultList;
    }
}
