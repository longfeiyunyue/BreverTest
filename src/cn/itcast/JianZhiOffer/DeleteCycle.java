package cn.itcast.JianZhiOffer;

import java.util.ArrayList;

public class DeleteCycle {//面试题62
	
	public static int deleteMath(int n,int m) {//从n个数字里每次删除第m个
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++) list.add(i);
		int index=0;
		while(list.size()>1) {
			index=(index+m-1)%list.size();
			list.remove(index);
		}
		return list.get(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(deleteMath(5,3));
	}

}
