package cn.veyhey.offer;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int v = scanner.nextInt();
		int mohuan = 0;
		int index = 0;
		for (int i = 0; i < n; i++) {
			int ti = scanner.nextInt();
			int pi = scanner.nextInt();
			int temp = 0;
			if (ti == 1) {
				temp = v / 1 * pi;
			} else {
				temp = v / 2 * pi;
			}
			if(temp>mohuan){
				mohuan = temp;
				index = i+1;
			}
		}
		if (index>0) {
			System.out.println(mohuan);
			System.out.println(index);
		}else {
			System.out.println(0);
			System.out.println("No");
		}
	}
}
