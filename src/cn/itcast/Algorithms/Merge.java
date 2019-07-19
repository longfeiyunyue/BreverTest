package cn.itcast.Algorithms;

import java.util.Arrays;

public class Merge {//×Ô¶¥ÏòÏÂ
	private static int[] aux;
	public static void sort(int[] a) {
		aux=new int[a.length];
		sort(a,0,a.length-1);
	}
	
	private static void sort(int[] a,int lo,int hi) {
		if(lo>=hi) return;
		int mid=lo+(hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	private static void merge(int[] a,int lo,int mid,int hi) {
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<=hi;k++) aux[k]=a[k];
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k]=aux[j++];
			else if(j>hi) a[k]=aux[i++];
			else if(aux[i]>aux[j]) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        sort(a);
        System.out.println(Arrays.toString(a));
	}

}
