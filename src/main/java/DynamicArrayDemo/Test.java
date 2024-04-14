package DynamicArrayDemo;

import java.util.Scanner;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.addLast(1);
        da.addLast(2);
        da.addLast(5);
        da.add(2, 4);
        for (int i = 0; i < 4; i++) {
            System.out.println(da.get(i));
        }
        da.foreach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        da.remove(2);
        da.stream().forEach(s -> System.out.println(s));
    }
}
