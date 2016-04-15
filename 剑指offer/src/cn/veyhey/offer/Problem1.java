package cn.veyhey.offer;

import java.util.*;

/**
 *  题目描述
 *
 *	输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。 
 * 	输入描述:
 * 	输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Problem1 {
	public ArrayList<String> Permutation(String str) {
       	char[] chs = str.toCharArray();
       	ArrayList<String> result = new ArrayList();
        Permutation(result,chs,0);
        Collections.sort(result);
        return result;
    }
    
    public void Permutation(ArrayList<String> result,char[] chs,int beginIndex){
        if(chs.length==0){
            return;
        }
        if(beginIndex==chs.length-1){
            String str = new String(chs);
            if(!result.contains(str))
           		 result.add(str);
        }
        else{
            for(int i = beginIndex;i<chs.length;i++){
            	char temp = chs[i];       
                chs[i] = chs[beginIndex];    
                chs[beginIndex] = temp;
                Permutation(result,chs,beginIndex+1);
         	    temp = chs[i];       
                chs[i] = chs[beginIndex];    
                chs[beginIndex] = temp;
            } 
        }
    }
	
	public static void main(String[] args) {
		System.out.println(new Problem1().Permutation("abc"));
	}
}