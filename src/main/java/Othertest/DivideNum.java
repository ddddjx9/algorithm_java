package Othertest;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DivideNum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        for (int i = a; i <= b; i++) {
            treeMap.put(i, primeFactorization(i));
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()) {
            int key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            System.out.print(key + "=");
            for (int i = 0; i < value.size() - 1; i++) {
                System.out.print(value.get(i) + "*");
            }
            System.out.print(value.get(value.size() - 1));
            System.out.println();
        }
    }

    public static ArrayList<Integer> primeFactorization(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
        	//25 / 5 = 5
        	//5 / 2 !=0
        	//24/2=12
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
	}

}
