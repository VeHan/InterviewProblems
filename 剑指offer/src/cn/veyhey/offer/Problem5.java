package cn.veyhey.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3��
 * ��ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6����
 * {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}��
 * {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 * 
 * @author Administrator
 *
 */
public class Problem5 {

	public static void main(String[] args) {
		int num[] = { 2, 3, 4, 2, 6, 2, 5, 1 };
		int size = 3;
		System.out.println(new Problem5().maxInWindows(num, size));
	}

	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0;i<size&&i<num.length;i++){
            while(!queue.isEmpty()&&queue.getLast()<num[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        for(int i = size;i<num.length;i++){
            result.add(num[queue.getFirst()]);
            while(!queue.isEmpty()&&(i-queue.getFirst())>=size){
                queue.removeFirst();
            }   
            while(!queue.isEmpty()&&num[queue.getLast()]<num[i]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        result.add(num[queue.getFirst()]);
		return result;
	}
}
