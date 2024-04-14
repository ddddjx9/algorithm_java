package Othertest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class CalculateAreas {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double[][] arr1=new double[2][2];
		double[][] arr2=new double[2][2];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				arr1[i][j]=sc.nextDouble();
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				arr2[i][j]=sc.nextDouble();
			}
		}
		sc.close();
		
		//如果两个矩形没有交集，返回0
		BigDecimal d1=new BigDecimal(arr1[0][0]);
		BigDecimal d2=new BigDecimal(arr1[1][0]);
		BigDecimal d3=new BigDecimal(arr2[0][0]);
		BigDecimal d4=new BigDecimal(arr2[1][0]);
		BigDecimal max1; //求出第一组中的最大值
		BigDecimal min1; //求出第一组中的最小值
		BigDecimal min2;
		BigDecimal max2;
		if(d1.compareTo(d2)>0) {
			max1=d1;
			min1=d2;
		}else {
			max1=d2;
			min1=d1;
		}
		if(d3.compareTo(d4)<0) {
			min2=d3;
			max2=d4;
		}else {
			min2=d4;
			max2=d3;
		}
		if(min2.compareTo(max1)>0 || min1.compareTo(max2)>0) {
			System.out.println("0.00");
			return;
		}
		
		
		double[] dy=new double[4];
		double[] dx=new double[4];
		
		//将所有纵坐标抽取出来，然后排序，中间的两个的差就是其中一条边的值
		dy[0]=arr1[0][1];
		dy[1]=arr1[1][1];
		dy[2]=arr2[0][1];
		dy[3]=arr2[1][1];
		//将所有横坐标取出来，然后排序，中间两个的差就是其中一条边的值
		//alt + shift + a 竖向选择快捷键
		dx[0]=arr1[0][0];
		dx[1]=arr1[1][0];
		dx[2]=arr2[0][0];
		dx[3]=arr2[1][0];
		
		Arrays.sort(dy);
		Arrays.sort(dx);
		double row=Math.abs(dy[2]-dy[1]);
		double col=Math.abs(dx[2]-dx[1]);
		System.out.printf("%.2f",row*col);
	}
}
