package cn.itcast.Letcode;

import java.util.ArrayList;
import java.util.List;

public class HuaFenZiMuQuJian {//划分字母区间
	public List<Integer> partitionLabels(String s) {
		List<Integer> list=new ArrayList<Integer>();
		int[] arr=new int[26];
		for(int i=0;i<s.length();i++) arr[s.charAt(i)-'a']=i;
		int start=0;
		int end=arr[s.charAt(0)-'a'];
		for(int i=0;i<s.length();i++) {
			end=Math.max(end,arr[s.charAt(i)-'a']);
			if(end>i) continue;
			else {
				list.add(end-start+1);
				start=end+1;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
