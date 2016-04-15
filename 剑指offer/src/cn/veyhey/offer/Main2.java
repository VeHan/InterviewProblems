package cn.veyhey.offer;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {

	public static <U> void main(String[] args) {
		TreeMap<Integer, Integer> sold = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		TreeMap<Integer, Integer> buy = new TreeMap<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int s = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String next = scanner.next();
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			if (next.equals("B")) {
				Integer jiage = buy.getOrDefault(p, 0);
				jiage += q;
				buy.put(p, jiage);
			} else {
				Integer jiage = sold.getOrDefault(p, 0);
				jiage += q;
				sold.put(p, jiage);
			}
		}
		scanner.close();
		int index = 0;
		for (Entry<Integer, Integer> item : sold.entrySet()) {
			if (index > sold.size() - s - 1) {
				System.out.println("S " + item.getKey() + " " + item.getValue());
			}
			index++;
		}
		index = 0;
		for (Entry<Integer, Integer> item : buy.entrySet()) {
			if (index < s) {
				System.out.println("B " + item.getKey() + " " + item.getValue());
			}
			index++;
		}
		System.out.println();
	}
}
