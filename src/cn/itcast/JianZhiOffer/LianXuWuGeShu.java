package cn.itcast.JianZhiOffer;

import java.util.Arrays;

public class LianXuWuGeShu {//√Ê ‘Ã‚61
	
	public static boolean isContinue(int[] arr) {
		int zero=0;
		int gap=0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) if(arr[i]==0) zero++;
		int start=zero;
		int lead=zero+1;
		while(lead<arr.length) {
			if(arr[start]==arr[lead]) return false;
			gap+=(arr[lead]-arr[start]-1);
			start=lead;
			lead++;
		}
		return zero>=gap?true:false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,4,0,3,5};
		System.out.println(isContinue(arr));
	}

}
