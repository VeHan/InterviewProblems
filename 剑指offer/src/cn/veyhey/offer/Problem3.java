package cn.veyhey.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem3 {

	public static void main(String[] args) {
		// [5,2,3,4,1,6,7,0,8]
//		Problem3 problem3 = new Problem3();
//		problem3.Insert(5);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(2);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(3);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(4);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(1);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(6);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(7);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(0);
//		System.out.println(problem3.GetMedian());
//		problem3.Insert(8);
//		System.out.println(problem3.GetMedian());
		 List<Integer> list = new ArrayList<>();
		 list.add(2);
		 list.add(1);
		 list.add(3);
		 Heap<Integer> heap = new Heap<>(Heap.MAX_HEAP, list);
		 System.out.println(heap);
	}

	private Heap<Integer> maxHeap = new Heap<Integer>(Heap.MAX_HEAP);
	private Heap<Integer> minHeap = new Heap<Integer>(Heap.MIN_HEAP);

	public void Insert(Integer num) {
		if (maxHeap.size() == 0) {
			maxHeap.add(num);
			return;
		}
		if (maxHeap.size() == minHeap.size()) {
			if (minHeap.top() < num) {
				maxHeap.add(minHeap.pop());
				minHeap.add(num);
			} else {
				maxHeap.add(num);
			}
		} else {
			if (maxHeap.top() > num) {
				minHeap.add(maxHeap.pop());
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
	}

	public Double GetMedian() {
		if (maxHeap.size() == 0) {
			return 0.0;
		}
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.top() + minHeap.top()) / 2.0;
		} else {
			return Double.valueOf(maxHeap.top());
		}
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
			heapify();
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
			list.set(index, list.remove(list.size() - 1));
			heapify(index);
		}

		private void heapify(int k) {
			while (k >= 0) {
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
				k--;
			}
		}

		private void heapify() {
			heapify(list.size() - 1);
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
