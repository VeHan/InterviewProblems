package cn.veyhey.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 
 * @author Administrator
 *
 */
public class Problem4 {

	public static void main(String[] args) {
		int num[] = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		System.out.println(new Problem4().maxInWindows(num, size));
	}

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();

		Heap<Integer> heap = new Heap<Integer>(Heap.MAX_HEAP);
		if (size <= 0) {
			return result;
		}
		for (int i = 0; i < num.length; i++) {
			queue.addFirst(num[i]);
			heap.add(num[i]);
			if (i >= size - 1) {
				result.add(heap.top());
				queue.removeLast();
				heap.remove(num[i - size + 1]);
			}
		}
		return result;
	}

	public static class Heap<T extends Comparable<T>> {

		public static final int MAX_HEAP = 0;
		public static final int MIN_HEAP = 1;
		private int heapType;

		public Heap(int heapType) {
			super();
			this.heapType = heapType;
		}

		public Heap(int heapType, List<T> list) {
			super();
			this.list.addAll(list);
			this.heapType = heapType;
			siftDown(0);
		}

		private List<T> list = new ArrayList<>();

		public int size() {
			return list.size();
		}

		public T top() {
			return list.get(0);
		}

		public T pop() {
			swap(0, list.size() - 1);
			T result = list.remove(list.size() - 1);
			if (list.size() > 0) {
				heapify(0);
			}
			return result;
		}

		public void add(T t) {
			list.add(t);
			int k = list.size() - 1;
			T temp = list.get(k);
			while ((k - 1) >= 0 && (k - 1) / 2 >= 0) {
				if (compare(temp, list.get((k - 1) / 2))) {
					list.set(k, list.get((k - 1) / 2));
					k = (k - 1) / 2;
				} else {
					break;
				}
			}
			list.set(k, temp);
		}

		public void remove(T t) {
			Iterator<T> iterator = list.iterator();
			int index = -1;
			while (iterator.hasNext()) {
				index++;
				T tt = iterator.next();
				if (tt.equals(t)) {
					break;
				}
			}
			if (index != list.size() - 1) {
				list.set(index, list.remove(list.size() - 1));
				siftDown(index);
			} else {
				list.remove(list.size() - 1);
			}
		}

		private void heapify(int k) {
			while (k >= 0) {
				siftDown(k);
				k--;
			}
		}

		private void siftDown(int k) {
			T temp = list.get(k);
			while (k < (list.size() - 1) / 2) {
				int proper = compare(k * 2 + 1, k * 2 + 2) ? k * 2 + 1 : k * 2 + 2;
				if (compare(proper, k)) {
					list.set(k, list.get(proper));
					k = proper;
				} else {
					break;
				}
			}
			list.set(k, temp);
		}

		public void swap(int x, int y) {
			T temp = list.get(x);
			list.set(x, list.get(y));
			list.set(y, temp);
		}

		public boolean compare(T x, T y) {
			int flag = 0;
			switch (heapType) {
			case MAX_HEAP:
				flag = x.compareTo(y);
				break;
			case MIN_HEAP:
				flag = y.compareTo(x);
				break;
			}
			return flag > 0 ? true : false;
		}

		public boolean compare(int x, int y) {
			return compare(list.get(x), list.get(y));
		}

		@Override
		public String toString() {
			return "Heap [heapType=" + heapType + ", list=" + list + "]";
		}

	}
}
