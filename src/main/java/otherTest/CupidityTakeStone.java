package otherTest;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CupidityTakeStone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        long[] stone = new long[n];
        for (int i = 0; i < stone.length; i++) {
            stone[i] = scanner.nextLong();
        }
        scanner.close();
        ArrayList<Long> list = getLongs(n, stone, s);
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    private static @NotNull ArrayList<Long> getLongs(int n, long[] stone, long s) {
        long startTotal;
        long endTotal;
        int k = 1;
        ArrayList<Long> list = new ArrayList<>();
        while (2 * k <= n) {
            startTotal = 0;
            endTotal = 0;
            for (int j = 0; j < k; j++) {
                startTotal += stone[j];
            }
            for (int j = 2 * k - 1; j >= 2 * k - k; j--) {
                endTotal += stone[j];
            }
            if (startTotal <= s && endTotal <= s) {
                list.add(2L * k);
            }
            k++;
        }
        return list;
    }
}
