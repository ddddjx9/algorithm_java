package Othertest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SpecialPalindromic {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		specialPalindromic(n);
	}

	public static int getSum(int n) {
		String s = String.valueOf(n);
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += Integer.valueOf(s.charAt(i)-'0');
		}
		return sum;
	}

	public static boolean judge(int n) {
		StringBuilder sBuilder = new StringBuilder();
		String s = String.valueOf(n);
		sBuilder.append(s);
		return s.contentEquals(sBuilder.reverse());
	}

	public static void specialPalindromic(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 899997; i <= 999999; i++) {
			if (judge(i) && getSum(i) == n) {
				list.add(i);
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}