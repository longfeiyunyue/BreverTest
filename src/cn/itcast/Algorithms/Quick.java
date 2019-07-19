package cn.itcast.Algorithms;

import java.util.Arrays;

public class Quick {
	public static final int M=7;
	
	public static void sort(int[] a) {
		sort(a,0,a.length-1);
	}
	
	private static void sort(int[] a,int lo,int hi) {
		//if(hi<=lo) return;
		if(lo+M<hi) {
			insertSort(a,lo,hi);
			return;
		}
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
	private static int partition(int[] a,int lo,int hi) {
		int i=lo;
		int j=hi+1;
		int v=a[lo];
		while(true) {
			while(a[++i]<v) if(i>=hi) break;
			while(a[--j]>v) if(j<=lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {2,1,5,3,88,4,5,780,9};
        sort(a);
        System.out.println(Arrays.toString(a));
	}
	public static void exch(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public static void insertSort(int[] a,int lo,int hi) {
		for(int i=lo;i<=hi;i++) {
			for(int j=i;j>lo&&a[j]<a[j-1];j--) {
				exch(a,j,j-1);
			}
		}
	}
}
