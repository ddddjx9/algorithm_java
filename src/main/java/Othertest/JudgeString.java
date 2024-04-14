package Othertest;

import java.util.Scanner;

public class JudgeString {

	public static void main(String[] args) {
		//判断字符串属于哪一种情况
		//1. 字符串长度不等str.length()
		//2. 字符串长度相等equals()，而且相应位置上的字符完全一致
		//3. 字符串长度相等，但是不区分大小写时才能达到一致
		//4. 长度相等，不区分大小写也不一致
		Scanner scanner=new Scanner(System.in);
		String str1=scanner.next();
		String str2=scanner.next();
		scanner.close();
		if(str1.length()!=str2.length()) {
			System.out.println(1);
		}else if (str1.equals(str2)) {
			System.out.println(2);
		}else if (str1.toUpperCase().equals(str2.toUpperCase())) {
			System.out.println(3);
		}else {
			System.out.println(4);
		}
	}

}
