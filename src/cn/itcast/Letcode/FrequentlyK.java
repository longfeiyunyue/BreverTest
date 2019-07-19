package cn.itcast.Letcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FrequentlyK {
	
	public static List<Integer> topKFrequent(int[] nums,int k){
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
			else map.put(nums[i],1);
		}
		ArrayList<Integer>[] list=new ArrayList[nums.length];
		Set<Map.Entry<Integer,Integer>> set=map.entrySet();
		for(Map.Entry<Integer,Integer> en:set) {
			int times=en.getValue();
			list[times].add(en.getKey());
		}
		List<Integer> res=new ArrayList<Integer>();
		for(int i=list.length-1;i>0&&res.size()<k;i--) {
			if(list[i]!=null) res.addAll(list[i]);
		}
			return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
