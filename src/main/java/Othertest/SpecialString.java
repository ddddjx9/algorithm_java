package Othertest;

import java.util.Scanner;

public class SpecialString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		char[] arr = string.toCharArray();
		scanner.close();
		int count=0;
		for (int i = 0; i < string.length() - 1; i++) {
			for (int j = i + 1; j < string.length(); j++) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				count++;
				if(check(String.valueOf(arr))) {
					System.out.println(count);
				}
			}
		}
	}

	public static boolean check(String str) {
		// abcde
		// abcdef
		int length = str.length();
		String start = "";
		StringBuilder end = new StringBuilder();
		if (length % 2 == 1) {
			start += str.substring(0, length / 2);
			end.append(str.substring(length / 2 + 1, length));
		} else {
			start += str.substring(0, length / 2);
			end.append(str.substring(length / 2, length));
		}
		if (start.equals(end.reverse().toString())) {
			return true;
		}
		return false;
	}
}
