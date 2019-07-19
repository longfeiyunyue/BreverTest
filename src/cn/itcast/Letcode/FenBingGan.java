package cn.itcast.Letcode;

import java.util.Arrays;

public class FenBingGan {//·Ö·¢±ý¸É
	
	public int findContentChildren(int[] g, int[] s) {
		int count=0;
		Arrays.sort(g);
		Arrays.sort(s);
		int i=0,j=0;
		while(i<g.length&&j<s.length) {
			if(s[j]>=g[i]) {
				count++;
				j++;
				i++;
			}else {
				j++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
