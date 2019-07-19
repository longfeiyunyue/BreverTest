package cn.itcast.Letcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidAnagram {//两个字符串包含的字符是否完全相同
	
	public boolean isAnagram(String s, String t) {
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(char c:s.toCharArray()) {
			if(map.containsKey(c)) map.put(c,map.get(c)+1);
			else map.put(c, 1);
		}
		for(char c:t.toCharArray()) {
			if(map.containsKey(c)) map.put(c, map.get(c)-1);
			else return false;
		}
		Set<Map.Entry<Character,Integer>> set=map.entrySet();
		for(Map.Entry<Character,Integer> en:set) {
			if(en.getValue()!=0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c='1';
        System.out.println((int)c);
	}

}
